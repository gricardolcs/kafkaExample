package com.nrs.example.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fecha;
    private String idEmail;
    private String email;
    private String mensajeValue;

}
