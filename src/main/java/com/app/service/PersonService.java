package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ApiResponse;
import com.app.dto.PersonDTO;
import com.app.entities.AadharCard;


public interface PersonService {
	public ApiResponse savePerson(PersonDTO dto);
	public ApiResponse deletePerson(int i);
	public PersonDTO getPerson(int i);
	public List<PersonDTO> getAll();
	public ApiResponse setAadhar(AadharCard card);
}
