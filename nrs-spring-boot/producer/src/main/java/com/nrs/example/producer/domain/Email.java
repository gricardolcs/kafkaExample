package com.nrs.example.producer.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Email {

    private String fecha;
    private String idEmail;
    private String email;
    private String mensajeValue;


}

