package com.pandey.crudOpsResFullServ.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
    //this annotation i added later to validate the api beacause the datea coming first to dto
    private long id;
    @NotEmpty//user first name should not be null or empty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email//email address should be valid;
    private String email;
}
