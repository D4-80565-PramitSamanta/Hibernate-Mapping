package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AadharDTO;
import com.app.dto.ApiResponse;
import com.app.service.AadharService;

@RestController
@RequestMapping("/api/aadhar")
public class AadharController {

    @Autowired
    private AadharService aadharService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAadhar(@RequestBody AadharDTO aadharDTO) {
        ApiResponse response = aadharService.saveAadhar(aadharDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAadhar(@PathVariable("id") int id) {
        ApiResponse response = aadharService.deleteAadhar(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AadharDTO>> getAllAadhar() {
        List<AadharDTO> aadharList = aadharService.getAll();
        return new ResponseEntity<>(aadharList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AadharDTO> getAllAadhar(@PathVariable int id) {
    	AadharDTO dto = aadharService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
