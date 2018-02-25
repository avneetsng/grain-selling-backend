package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.properties.AppProperties;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.prayasj.gndit.grainselling.config.security.JWTAuthenticationFilter.HEADER_PREFIX;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AppProperties appProperties;

  public boolean signup(UserInfo userInfo) {
    if (userRepository.findByUsername(userInfo.getUsername()) != null) {
      return false;
    }
    String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
    userRepository.save(new User(userInfo.getUsername(), encodedPassword));
    return true;
  }

  public String getUsernameFromToken(String token) {
    return Jwts.parser()
        .setSigningKey(appProperties.getSecret().getBytes())
        .parseClaimsJws(token.replace(HEADER_PREFIX, ""))
        .getBody()
        .getSubject();
  }
}
