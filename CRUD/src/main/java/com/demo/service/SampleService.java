package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Sample;

@Service
public interface SampleService {

    // POST
    List<Sample> createData(List<Sample> sample);

    // GET ALL
    List<Sample> readAll();

    // PUT
    Sample update(int id, Sample samp);
    
    //delete
    
    void deleteData(int id);
}