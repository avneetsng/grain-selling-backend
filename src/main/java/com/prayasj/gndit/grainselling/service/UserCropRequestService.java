package com.prayasj.gndit.grainselling.service;

import com.fasterxml.uuid.Generators;
import com.prayasj.gndit.grainselling.dto.UserCropRequestDto;
import com.prayasj.gndit.grainselling.model.Crop;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.model.UserCropRequest;
import com.prayasj.gndit.grainselling.repository.CropRepository;
import com.prayasj.gndit.grainselling.repository.UserCropRequestRepository;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserCropRequestService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CropRepository cropRepository;

  @Autowired
  private UserCropRequestRepository userCropRequestRepository;

  public void saveCropRequest(String userName, UserCropRequestDto userCropRequestDto) {

    User user = userRepository.findByUsername(userName);
    Crop crop = cropRepository.findByName(userCropRequestDto.getCropName());
    UserCropRequest userCropRequest = new UserCropRequest
                    (user, crop, userCropRequestDto.getPrice(), userCropRequestDto.getQuantity(),new Date(),createUUID());
    userCropRequestRepository.save(userCropRequest);
  }

  public List<UserCropRequestDto> getCropRequestsForUser(String userName){
    List<UserCropRequestDto> userCropRequestDtos = new ArrayList<>();
    User user = userRepository.findByUsername(userName);
    List<UserCropRequest> userCropRequestList = userCropRequestRepository.findByUser(user);
    for (UserCropRequest userCropRequest : userCropRequestList) {
      userCropRequestDtos.add(new UserCropRequestDto(userCropRequest));
    }
    return userCropRequestDtos;
  }

  private String createUUID() {
    UUID uuid = Generators.timeBasedGenerator().generate();
    return uuid.toString();
  }
}
