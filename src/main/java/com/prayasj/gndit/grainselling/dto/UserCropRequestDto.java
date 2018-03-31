package com.prayasj.gndit.grainselling.dto;

import com.prayasj.gndit.grainselling.model.UserCropRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
public class UserCropRequestDto {
  private String cropName;
  private BigDecimal quantity;
  private BigDecimal price;


  private String requestId;

  public UserCropRequestDto(UserCropRequest userCropRequest) {
    cropName = userCropRequest.getCrop().getName();
    quantity = userCropRequest.getQuantity();
    price = userCropRequest.getPrice();
    requestId = userCropRequest.getRequestId();
  }

}
