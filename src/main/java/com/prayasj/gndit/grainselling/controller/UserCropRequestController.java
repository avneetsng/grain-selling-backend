package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.dto.UserCropRequestDto;
import com.prayasj.gndit.grainselling.service.UserCropRequestService;
import com.prayasj.gndit.grainselling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.prayasj.gndit.grainselling.config.security.JWTAuthenticationFilter.JWT_TOKEN;

@Controller
public class UserCropRequestController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserCropRequestService userCropRequestService;

  @PostMapping("/api/crop-request")
  @ResponseBody
  public ResponseEntity createCropRequest(@RequestBody UserCropRequestDto userCropRequestDto,
                                          @RequestHeader(JWT_TOKEN) String token) {
    String userName = userService.getUsernameFromToken(token);
    userCropRequestService.saveCropRequest(userName, userCropRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
