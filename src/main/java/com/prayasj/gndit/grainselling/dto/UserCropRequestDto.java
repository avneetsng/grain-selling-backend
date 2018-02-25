package com.prayasj.gndit.grainselling.dto;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class UserCropRequestDto {
  private String cropName;
  private BigDecimal quantity;
  private BigDecimal price;
}
