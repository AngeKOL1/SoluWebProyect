package com.example.MR.Barda.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Clase S2
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String email;
    private String password;
}
