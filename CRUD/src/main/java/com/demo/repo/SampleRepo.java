package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Sample;

@Repository
public interface SampleRepo extends JpaRepository<Sample, Integer> {

}