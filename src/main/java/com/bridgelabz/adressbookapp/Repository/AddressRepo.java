package com.bridgelabz.adressbookapp.Repository;

import com.bridgelabz.adressbookapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<AddressBookModel, Integer> {

    @Query(value = "select * from address_book_model where email = :email", nativeQuery = true)
    List<AddressBookModel> findByEmail(String email);
}
