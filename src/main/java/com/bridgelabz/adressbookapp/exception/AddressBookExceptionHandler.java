package com.bridgelabz.adressbookapp.exception;


//import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.adressbookapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice

public class AddressBookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handelMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto("Exception While processing REST Request", errMsg);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDto> handelAddressBookException(AddressBookException exception) {
        ResponseDto responseDto = new ResponseDto("Exception while processing REST request", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
