package com.solstice.challenge.repository;

import com.solstice.challenge.domain.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @Query(value = "SELECT contact_id FROM phone_number WHERE number = ?1 LIMIT 1", nativeQuery = true)
    Long findByNumber(String number);
}
