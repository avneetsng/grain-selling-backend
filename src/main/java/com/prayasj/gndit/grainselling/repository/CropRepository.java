package com.prayasj.gndit.grainselling.repository;

import com.prayasj.gndit.grainselling.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

}
