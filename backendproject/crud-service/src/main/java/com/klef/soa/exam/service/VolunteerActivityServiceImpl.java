package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.VolunteerActivity;
import com.klef.soa.exam.repository.VolunteerActivityRepository;

@Service
public class VolunteerActivityServiceImpl implements VolunteerActivityService {

	@Autowired
	private VolunteerActivityRepository repo;

	@Override
	public VolunteerActivity addvs(VolunteerActivity v) {
	    return repo.save(v);
	}

	@Override
	public List<VolunteerActivity> displayAll() {
		return repo.findAll();
	}

	@Override
	public String deleteVolunteerActivityById(Long id) {
		boolean flag = repo.existsById(id); //return true or false
		if(flag) {
			repo.deleteById(id);
			return "VolunteerActivity Deleted Successfully";
			
		}else {
			return "VolunteerActivity ID Not Found";
		}
	}
	
	
}
