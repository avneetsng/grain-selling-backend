package com.prayasj.gndit.grainselling.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserProfileDto {
  private String name;

  private String gender;

  private String address;

  private String contact;

  private Date dob;
}
