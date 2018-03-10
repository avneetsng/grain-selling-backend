package com.prayasj.gndit.grainselling.dto;

import lombok.Getter;

@Getter
public class ErrorResponse {
  private String message;

  private ErrorResponse(String message) {
    this.message = message;
  }

  public static ErrorResponse withMessage(String errorMsg) {
    return new ErrorResponse(errorMsg);
  }
}
