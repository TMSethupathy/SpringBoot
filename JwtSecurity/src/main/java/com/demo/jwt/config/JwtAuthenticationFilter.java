package com.demo.jwt.config;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.jwt.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
    private final Map<String, UserDetails> userDetailsCache = new ConcurrentHashMap<String, UserDetails>();
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = null;
		String username =null;
		
		//Extract JWT token from the header
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			jwt =authorizationHeader.substring(7);
			username =jwtUtils.extractUsername(jwt);
		}
		
		// if user is found and the user is not authenticated yet
		if(username != null && SecurityContextHolder.getContext().getAuthentication()== null ) {
			
			// check if UserDeatisare are already cached 
			UserDetails userDetails = userDetailsCache.get(username);
			
			if(userDetails == null) {
				 
				userDetails = customUserDetailsService.loadUserByUsername(username);
				
				userDetailsCache.put(username, userDetails);
			}
			
			// Validate the token and set authentication if valid
            if (jwtUtils.validateToken(jwt, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}