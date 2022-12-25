package com.bridgelabz.adressbookapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data

public class AddressBookDto {
    @NotEmpty(message = "Please Enter Your Name")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid Name")
    private String name;
    @NotEmpty(message = "Please Enter Your Address")
    private String address;
    @NotEmpty(message = "Please Enter Your City")
    private String city;
    @NotEmpty(message = "Please Enter Your State")
    private String state;
    @NotNull(message = "Please Enter Your Number")
//  @Pattern(regexp = "^(91)()[6-9]{1}[0-9]{9}$")
    private long phoneNum;
    @NotEmpty(message = "Please Enter Your e-mail")
    private String email;

//    public AddressBookDto(String name, String address, String city,
//                          String state, long phoneNum, String email) {
//        this.name = name;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.phoneNum = phoneNum;
//        this.email = email;
//    }
}
