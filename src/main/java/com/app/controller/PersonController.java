package com.app.controller;

import com.app.dto.ApiResponse;
import com.app.dto.PersonDTO;
import com.app.entities.AadharCard;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPerson(@RequestBody PersonDTO personDTO) {
        ApiResponse response = personService.savePerson(personDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deletePerson(@PathVariable("id") int id) {
        ApiResponse response = personService.deletePerson(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable("id") int id) {
        PersonDTO personDTO = personService.getPerson(id);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> personDTOList = personService.getAll();
        return new ResponseEntity<>(personDTOList, HttpStatus.OK);
    }

//    @PostMapping("/setaadhar")
//    public ResponseEntity<ApiResponse> setAadhar(@RequestBody AadharCard card) {
//        ApiResponse response = personService.setAadhar(card);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
