package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
}
