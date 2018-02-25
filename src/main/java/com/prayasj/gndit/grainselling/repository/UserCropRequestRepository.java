package com.prayasj.gndit.grainselling.repository;

import com.prayasj.gndit.grainselling.model.UserCropRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCropRequestRepository extends JpaRepository<UserCropRequest, Integer> {

}
