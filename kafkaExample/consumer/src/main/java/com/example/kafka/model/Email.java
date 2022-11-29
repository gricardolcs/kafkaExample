package com.example.kafka.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Email implements Serializable {

    private LocalDate fecha;
    private String idemail;
    private String email;
    private String mensajeValue;
}
