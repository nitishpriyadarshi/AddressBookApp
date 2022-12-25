package com.bridgelabz.adressbookapp.controller;



import com.bridgelabz.adressbookapp.dto.AddressBookDto;
import com.bridgelabz.adressbookapp.dto.ResponseDto;

import com.bridgelabz.adressbookapp.model.AddressBookModel;
import com.bridgelabz.adressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/addressbook")

public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAddressBookData() {
        List<AddressBookModel> addData = service.getAddressBookData();
        ResponseDto responseDto = new ResponseDto("Getting All AddressBook data", addData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDto> getAddressBookDataById(
            @PathVariable("personId") int personId) {
        AddressBookModel addData = service.getAddressBookDataById(personId);
        ResponseDto responseDto = new ResponseDto("Getting AddressBook data By Id", addData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createDataToAddressBook(
            @Valid @RequestBody AddressBookDto addressBookDto) {
        AddressBookModel addData = service.createDataToAddressBook(addressBookDto);
        ResponseDto responseDto = new ResponseDto("Data Created To AddressBook", addData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDto> updateDataOfAddressBook(
            @PathVariable("personId") int personId,
            @RequestBody AddressBookDto addressBookDto) {
        AddressBookModel addData = service.updateDataOfAddressBook(personId, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Data Updated ..!!", addData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @DeleteMapping("delete/{personId}")
    public ResponseEntity<ResponseDto> deleteDataOfAddressBook(
            @PathVariable("personId") int personId) {
        service.deleteDataOfAddressBook(personId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "Deleted Id:" + personId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseDto> getAddressBookDataByEmail(
            @PathVariable("email") String email) {
        List<AddressBookModel> dataByEmailList = service.getAddressBookDataByIdEmail(email);
        ResponseDto responseDto = new ResponseDto("Data Call Through Email is Done Successfully"
                , dataByEmailList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }


}
