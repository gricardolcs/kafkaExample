package com.nrs.example.consumer.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class EmailDto {
    private String fecha;
    private String idEmail;
    private String email;
    private String mensajeValue;

}
