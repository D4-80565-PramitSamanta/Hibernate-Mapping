package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AadharDTO;
import com.app.dto.ApiResponse;
import com.app.entities.AadharCard;
import com.app.exception.ResourceNotFound;
import com.app.repository.AadharRepo;


@Service
@Transactional
public class AadharServiceImpl implements AadharService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	AadharRepo aadharrepo;
	
	@Override
	public ApiResponse saveAadhar(AadharDTO card) {
		AadharCard acard = mapper.map(card, AadharCard.class);
		aadharrepo.save(acard);
		return (new ApiResponse(201,"aadhar card added successfully!!"));
	}

	@Override
	public ApiResponse deleteAadhar(int i) {
		AadharCard acard = aadharrepo.findById(i).orElseThrow(()->new ResourceNotFound("aadhar not found!!"));
		aadharrepo.delete(acard);
		return (new ApiResponse(201,"aadhar card deleted successfully!!"));
	}

	@Override
	public List<AadharDTO> getAll() {
		return aadharrepo.findAll()
				.stream()
				.map(e->mapper.map(e, AadharDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AadharDTO getById(int i) {
		AadharCard acard = aadharrepo.findById(i).orElseThrow(()->new ResourceNotFound("aadhar not found!!"));
		return mapper.map(acard, AadharDTO.class);
	}

}
