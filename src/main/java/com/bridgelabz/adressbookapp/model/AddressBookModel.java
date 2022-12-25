package com.bridgelabz.adressbookapp.model;

import com.bridgelabz.adressbookapp.dto.AddressBookDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private  String name;
    private String address;
    private  String city;
    private String state;
    private long phoneNum;
    private String email;


//    public AddressBookModel(){
//
//    }

    public AddressBookModel(AddressBookDto addressBookDto) {
        this.name = addressBookDto.getName();
        this.address = addressBookDto.getAddress();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.phoneNum = addressBookDto.getPhoneNum();
        this.email = addressBookDto.getEmail();
    }

    public AddressBookModel(int personId, AddressBookDto addressBookDto) {
        this.personId = personId;
        this.name = addressBookDto.getName();
        this.address = addressBookDto.getAddress();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.phoneNum = addressBookDto.getPhoneNum();
        this.email = addressBookDto.getEmail();
    }

}
