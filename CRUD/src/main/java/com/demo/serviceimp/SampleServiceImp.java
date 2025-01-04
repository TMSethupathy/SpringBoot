package com.demo.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.entity.Sample;
import com.demo.repo.SampleRepo;
import com.demo.service.SampleService;

@Component
public class SampleServiceImp implements SampleService{

	@Autowired
	SampleRepo sampleRepo;

	@Override
	public List<Sample> createData(List<Sample> sample) {
		return sampleRepo.saveAll(sample);
	}

	@Override
	public Sample update(int id, Sample samp) {
	    Optional<Sample> findById = sampleRepo.findById(id);
	  
	        Sample update = findById.get();
	        update.setName(samp.getName());
	        update.setEmail(samp.getEmail());
	        update.setPhoneNo(samp.getPhoneNo());
	        return sampleRepo.save(update);
	   
	}

	@Override
	public void deleteData(int id) {
		sampleRepo.deleteById(id);
	}


	@Override
	public List<Sample> readAll() {
		return sampleRepo.findAll();
	}



	
	


}
