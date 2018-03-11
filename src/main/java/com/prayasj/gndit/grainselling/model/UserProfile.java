package com.prayasj.gndit.grainselling.model;

import com.prayasj.gndit.grainselling.dto.UserProfileDto;
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
import java.util.Date;

@Entity
@Table(name = "user_profile")
@NoArgsConstructor
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "name")
  @Getter
  private String name;

  @Column(name = "gender")
  @Getter
  private String gender;

  @Column(name = "address")
  @Getter
  private String address;

  @Column(name = "contact")
  @Getter
  private String contact;

  @Column(name = "dob")
  @Getter
  private Date dob;

  public UserProfile(User user, UserProfileDto userProfileDto) {
    this.user = user;
    this.name = userProfileDto.getName();
    this.gender = userProfileDto.getGender();
    this.address = userProfileDto.getAddress();
    this.contact = userProfileDto.getContact();
    this.dob = userProfileDto.getDob();
  }
}
