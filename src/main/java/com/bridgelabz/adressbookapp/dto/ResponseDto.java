package com.bridgelabz.adressbookapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    public String message;
    public Object data;

//    public ResponseDto(String message, Object data) {
//        this.message = message;
//        this.data = data;
//   }


}
