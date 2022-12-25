package com.bridgelabz.adressbookapp.service;


import com.bridgelabz.adressbookapp.dto.AddressBookDto;
import com.bridgelabz.adressbookapp.model.AddressBookModel;

import java.util.List;
public interface IAddressBookService {
    List<AddressBookModel> getAddressBookData();

    AddressBookModel getAddressBookDataById(int personId);

    AddressBookModel createDataToAddressBook(AddressBookDto addressBookDto);

    AddressBookModel updateDataOfAddressBook(int personId, AddressBookDto addressBookDto);

    void deleteDataOfAddressBook(int personId);

    List<AddressBookModel> getAddressBookDataByIdEmail(String email);
}

