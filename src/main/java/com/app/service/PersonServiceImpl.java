package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.PersonDTO;
import com.app.entities.AadharCard;
import com.app.entities.Person;
import com.app.exception.ResourceNotFound;
import com.app.repository.UserRepo;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
	@Autowired
	UserRepo urepo;
	@Autowired
	ModelMapper mapper;
	@Override
	public ApiResponse savePerson(PersonDTO dto) {
		Person person = mapper.map(dto, Person.class);
		urepo.save(person);
		return (new ApiResponse(201,"person added successfully!!")); 
	}

	@Override
	public ApiResponse deletePerson(int i) {
		Person person = urepo.findById(i).orElseThrow(()->new ResourceNotFound("person not found!!"));
		urepo.delete(person);
		return (new ApiResponse(201,"person deleted successfully!!")); 
	}

	@Override
	public PersonDTO getPerson(int i) {
		Person person = urepo.findById(i).orElseThrow(()->new ResourceNotFound("person not found!!"));
		return mapper.map(person, PersonDTO.class);
	}

	@Override
	public List<PersonDTO> getAll() {
		List<PersonDTO> dtos = urepo.findAll()
				.stream()
				.map(e->mapper.map(e, PersonDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ApiResponse setAadhar(AadharCard card) {
		// TODO Auto-generated method stub
		return null;
	}

}
