package com.prayasj.gndit.grainselling.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
public class UserProfileDto {
  @NotNull(message = "Name is required.")
  @Pattern(regexp = "^[A-Za-z-, ]{3,20}$", message = "Please provide a valid Name")
  private String name;

  @NotNull(message = "Gender is required.")
  @Pattern(regexp = "^[MF]$", message = "Please provide a valid Gender")
  private String gender;

  @NotNull(message = "Address is required.")
  @Pattern(regexp = "^.{10,200}$", message = "Please provide a valid Address")
  private String address;

  @NotNull(message = "Contact number is required.")
  @Pattern(regexp = "^[0-9]{5,16}$", message = "Please provide a valid Contact Number")
  private String contact;

  @NotNull(message = "Date of birth is required.")
  private Date dob;
}
