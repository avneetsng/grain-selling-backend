package com.prayasj.gndit.grainselling.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "user_crop_request")
@NoArgsConstructor
public class UserCropRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "crop_id", nullable = false)
  @Getter
  private Crop crop;

  @Column(name = "price")
  @Getter
  private BigDecimal price;

  @Column(name = "quantity")
  @Getter
  private BigDecimal quantity;

  public UserCropRequest(User user, Crop crop, BigDecimal price, BigDecimal quantity) {
    this.user = user;
    this.crop = crop;
    this.price = price;
    this.quantity = quantity;
  }
}
