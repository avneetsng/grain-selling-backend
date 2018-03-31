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
import java.util.Date;

@Entity
@Table(name = "user_crop_request")
@NoArgsConstructor
public class UserCropRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Getter
    @Column(name = "requestid")
    private String requestId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "crop_id", nullable = false)
    @Getter
    private Crop crop;

    @Column(name = "price")
    @Getter
    private BigDecimal price;

    @Column(name = "quantity")
    @Getter
    private BigDecimal quantity;


    @Column(name = "created_at")
    @Getter
    private Date createdAt;

    public UserCropRequest(User user, Crop crop, BigDecimal price, BigDecimal quantity, Date createdAt, String requestId) {
        this.user = user;
        this.crop = crop;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.requestId = requestId;
    }
}
