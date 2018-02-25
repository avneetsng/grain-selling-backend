package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.dto.UserCropRequestDto;
import com.prayasj.gndit.grainselling.model.Crop;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.model.UserCropRequest;
import com.prayasj.gndit.grainselling.repository.CropRepository;
import com.prayasj.gndit.grainselling.repository.UserCropRequestRepository;
import com.prayasj.gndit.grainselling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    UserCropRequest userCropRequest = new UserCropRequest(user, crop, userCropRequestDto.getPrice(), userCropRequestDto.getQuantity());
    userCropRequestRepository.save(userCropRequest);
  }

  public List<UserCropRequest> getCropRequestsForUser(String userName){
    User user = userRepository.findByUsername(userName);
    return userCropRequestRepository.findByUser(user);
  }
}
