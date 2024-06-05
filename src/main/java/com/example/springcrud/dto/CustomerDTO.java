package com.example.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    Long id;
    String name;
    String email;
    String phone;

    public CustomerDTO(Long id, String name, String email, String phone) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

}
