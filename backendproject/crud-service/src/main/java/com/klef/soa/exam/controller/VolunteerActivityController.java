
package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.exam.entity.VolunteerActivity;
import com.klef.soa.exam.service.VolunteerActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/VolunteerActivity")
public class VolunteerActivityController {
	
	@Autowired 
	private VolunteerActivityService service;
	
	@GetMapping("/")
	public ResponseEntity<String> demo() {
	    return ResponseEntity.ok("Volunteer Activity Service Running");
	}
	
	@PostMapping("/add")
	public ResponseEntity<VolunteerActivity> addvss(
	        @RequestBody VolunteerActivity v) {

		VolunteerActivity volunteer = service.addvs(v);

	    return ResponseEntity.status(201).body(volunteer);
	}
	
	
	
	@GetMapping("/displayall")
	public ResponseEntity<List<VolunteerActivity>> displayAll()
	{
		List<VolunteerActivity> vv = service.displayAll();
		return ResponseEntity.status(200).body(vv);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletevsById(@PathVariable Long id)
	{
		String message = service.deleteVolunteerActivityById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	

}
