package com.prayasj.gndit.grainselling.repository;

import com.prayasj.gndit.grainselling.dto.UserCropRequestDto;
import com.prayasj.gndit.grainselling.model.User;
import com.prayasj.gndit.grainselling.model.UserCropRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCropRequestRepository extends JpaRepository<UserCropRequest, Integer> {
  List<UserCropRequest> findByUser(User user);
}
