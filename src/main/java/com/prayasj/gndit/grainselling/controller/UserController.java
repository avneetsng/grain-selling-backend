package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.dto.UserProfileDto;
import com.prayasj.gndit.grainselling.model.UserProfile;
import com.prayasj.gndit.grainselling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static com.prayasj.gndit.grainselling.config.security.JWTAuthenticationFilter.JWT_TOKEN;
import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/api/signup")
  @ResponseBody
  public ResponseEntity signup(@Valid @RequestBody UserInfo userInfo) {
    return userService.signup(userInfo) ?
        ResponseEntity.status(CREATED).build() :
        ResponseEntity.badRequest().build();
  }

  @PostMapping("/api/profile")
  @ResponseBody
  public ResponseEntity addProfileInfo(@RequestBody UserProfileDto userProfileDto,
                                       @RequestHeader(JWT_TOKEN) String token) {
    UserProfile userProfile = userService.saveProfile(token, userProfileDto);
    return userProfile != null ?
        ResponseEntity.status(CREATED).build() :
        ResponseEntity.badRequest().build();
  }
}
