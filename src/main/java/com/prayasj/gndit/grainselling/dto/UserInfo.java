package com.prayasj.gndit.grainselling.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class UserInfo {
  @NotNull(message = "Username is required.")
  @Pattern(regexp = "^[A-Za-z0-9_]{3,10}$", message = "Please provide a valid Username")
  private String username;
  @NotNull(message = "Password is required.")
  @Pattern(regexp = "^.{6,20}$", message = "Please provide a valid Password")
  private String password;
}
