package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/api/signup")
  @ResponseBody
  public ResponseEntity signup(@RequestBody User user) {
    userRepository.save(user);
    return ResponseEntity.ok().build();
  }
}
