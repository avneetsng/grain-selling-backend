package com.prayasj.gndit.grainselling.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prayasj.gndit.grainselling.dto.UserInfo;
import com.prayasj.gndit.grainselling.model.LoginResponse;
import com.prayasj.gndit.grainselling.properties.AppProperties;
import com.prayasj.gndit.grainselling.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  public static final String JWT_TOKEN = "jwt_token";
  public static final String HEADER_PREFIX = "Bearer ";
  private AuthenticationManager authenticationManager;
  private UserService userService;
  private AppProperties appProperties;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, AppProperties appProperties) {
    super(new AntPathRequestMatcher("/api/login", "POST"));
    this.authenticationManager = authenticationManager;
    this.userService = userService;
    this.appProperties = appProperties;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      UserInfo creds = new ObjectMapper()
          .readValue(request.getInputStream(), UserInfo.class);

      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              creds.getUsername(),
              creds.getPassword(),
              new ArrayList<>())
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest req,
                                          HttpServletResponse res,
                                          FilterChain chain,
                                          Authentication auth) throws UnsupportedEncodingException {
    String username = ((User) auth.getPrincipal()).getUsername();
    String token = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + 864000000))
        .signWith(SignatureAlgorithm.HS256, appProperties.getSecret().getBytes("UTF-8"))
        .compact();
    res.addHeader(JWT_TOKEN, HEADER_PREFIX + token);
    res.setContentType("application/json");
    res.setCharacterEncoding("utf-8");
    LoginResponse loginResponse = new LoginResponse(userService.hasProfile(username));
    try {
      res.getWriter().write(new ObjectMapper().writeValueAsString(loginResponse));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
