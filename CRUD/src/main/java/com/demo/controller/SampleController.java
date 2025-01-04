package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Sample;
import com.demo.serviceimp.SampleServiceImp;

@RestController
public class SampleController {
	
	 @Autowired
	    SampleServiceImp sampleServiceImp;

	    @PostMapping(value = "/create")
	    public List<Sample> createSample(@RequestBody  List<Sample> sample) {
			return sampleServiceImp.createData(sample);
	        
	    }

	    @GetMapping(value = "/readall")
	    public List<Sample> getAllSamples() {
	        return sampleServiceImp.readAll();
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Sample> updateSample(@PathVariable("id")int id, @RequestBody Sample samp) {
	         Sample update = sampleServiceImp.update(id, samp);
			return ResponseEntity.ok(update);
	         
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public void dteleDetails(@PathVariable("id") int id){
	    	sampleServiceImp.deleteData(id);
	    }
	}