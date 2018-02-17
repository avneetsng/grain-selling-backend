package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public boolean signup(UserInfo userInfo) {
    if (userRepository.findByUsername(userInfo.getUsername()) != null) {
      return false;
    }
    userRepository.save(new User(userInfo.getUsername(), userInfo.getPassword()));
    return true;
  }
}
