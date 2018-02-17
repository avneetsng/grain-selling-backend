package com.prayasj.gndit.grainselling.repository;

import com.prayasj.gndit.grainselling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String username);
}
