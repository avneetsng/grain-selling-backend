package com.prayasj.gndit.grainselling;

import com.prayasj.gndit.grainselling.model.Crop;
import com.prayasj.gndit.grainselling.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class DataSeedController {

  @Autowired
  private CropRepository cropRepository;

  @Autowired
  private Environment env;

  @GetMapping("/seed")
  @ResponseBody
  public ResponseEntity seedData() {
    if (Arrays.asList(env.getActiveProfiles()).contains("prod")) {
      return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
    cropRepository.save(Arrays.asList(new Crop("WHEAT"), new Crop("RICE")));
    return ResponseEntity.ok().build();
  }
}
