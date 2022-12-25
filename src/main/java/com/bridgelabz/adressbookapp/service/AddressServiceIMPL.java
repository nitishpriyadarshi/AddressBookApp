package com.bridgelabz.adressbookapp.service;


import com.bridgelabz.adressbookapp.Repository.AddressRepo;
import com.bridgelabz.adressbookapp.dto.AddressBookDto;
import com.bridgelabz.adressbookapp.exception.AddressBookException;
import com.bridgelabz.adressbookapp.model.AddressBookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceIMPL implements IAddressBookService  {
    @Autowired
    private AddressRepo addressRepo;

    private List<AddressBookModel> addData = new ArrayList<>();

    @Override
    public List<AddressBookModel> getAddressBookData() {
        List<AddressBookModel> addData = addressRepo.findAll();
        return addData;
    }

    @Override
    public AddressBookModel getAddressBookDataById(int personId) {
        Optional<AddressBookModel> addressBookModel = addressRepo.findById(personId);
        if (addressBookModel.isPresent()) {
            return addressBookModel.get();
        } else {
            throw new AddressBookException("PersonId Not Found..!!");
        }
    }

    @Override
    public AddressBookModel createDataToAddressBook(AddressBookDto addressBookDto) {
        AddressBookModel addData = new AddressBookModel(addressBookDto);
        addressRepo.save(addData);
        return addData;
    }

    @Override
    public AddressBookModel updateDataOfAddressBook(int personId, AddressBookDto addressBookDto) {
        Optional<AddressBookModel> addressBookModel = addressRepo.findById(personId);
        if (addressBookModel.isPresent()) {
            AddressBookModel addData = new AddressBookModel(personId, addressBookDto);
            addressRepo.save(addData);
            return addData;
        } else {
            throw new AddressBookException("Id Not Found..!!");
        }

    }

    @Override
    public void deleteDataOfAddressBook(int personId) {
        Optional<AddressBookModel> addressBookModel = addressRepo.findById(personId);
        if (addressBookModel.isPresent()) {
            addressRepo.deleteById(personId);
        } else {
            throw new AddressBookException("Id Not Found..!!");
        }
    }

    @Override
    public List<AddressBookModel> getAddressBookDataByIdEmail(String email) {
        List<AddressBookModel> addressBookModel = addressRepo.findByEmail(email);

        if (!addressBookModel.isEmpty()) {
            return addressBookModel;
        } else {
            throw new AddressBookException("No Data Found Through This e-mail Id");
        }


    }

}
