package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.dto.UserCropRequestDto;
import com.prayasj.gndit.grainselling.model.UserCropRequest;
import com.prayasj.gndit.grainselling.service.UserCropRequestService;
import com.prayasj.gndit.grainselling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.prayasj.gndit.grainselling.config.security.JWTAuthenticationFilter.JWT_TOKEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

  @GetMapping(value = "/api/crop-request", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<UserCropRequestDto>> getCropRequests(@RequestHeader(JWT_TOKEN) String token) {
    String userName = userService.getUsernameFromToken(token);
    List<UserCropRequestDto> cropRequestsForUser = userCropRequestService.getCropRequestsForUser(userName);
    return ResponseEntity.ok(cropRequestsForUser);
  }
}
