package com.rudraksh.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {
    @NotNull(message = "User's name should not be null") // throws message that we pass when name field is null
    private String name;
    @Email(message = "Invalid email address") // validation annotation for email
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number") // a regular expression for 10 digit mobile number
    private String mobile;
    private String gender;
    @Min(18) // minimum age should be 18
    @Max(60) // maximum age should be 60
    private int age;
    @NotBlank // a combination of @NotNull and @NotEmpty
    private String nationality;
}
