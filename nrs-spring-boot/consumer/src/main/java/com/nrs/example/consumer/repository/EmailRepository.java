package com.nrs.example.consumer.repository;

import com.nrs.example.consumer.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
