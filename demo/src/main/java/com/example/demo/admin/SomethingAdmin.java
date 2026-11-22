package com.example.demo.admin;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Something;
import com.reightvoid.jja.annotation.AdminModel;

@Component 
@AdminModel(name = "Something", path="something", value=Something.class)
public class SomethingAdmin {
}
