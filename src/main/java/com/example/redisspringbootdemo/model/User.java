package com.example.redisspringbootdemo.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private  String userId;
    private String name;
    private String email;
}
