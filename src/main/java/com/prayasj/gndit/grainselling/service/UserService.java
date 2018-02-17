package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public boolean signup(UserInfo userInfo) {
    if (userRepository.findByUsername(userInfo.getUsername()) != null) {
      return false;
    }
    String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
    userRepository.save(new User(userInfo.getUsername(), encodedPassword));
    return true;
  }
}
