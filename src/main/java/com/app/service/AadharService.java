package com.app.service;

import java.util.List;

import com.app.dto.AadharDTO;
import com.app.dto.ApiResponse;

public interface AadharService {
	public ApiResponse saveAadhar(AadharDTO card);
	public ApiResponse deleteAadhar(int i);
	public List<AadharDTO> getAll();
	public AadharDTO getById(int i);
}
