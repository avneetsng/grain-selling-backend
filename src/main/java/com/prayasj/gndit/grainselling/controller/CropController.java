package com.prayasj.gndit.grainselling.controller;

import com.prayasj.gndit.grainselling.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping("/api/crops")
    @ResponseBody
    public ResponseEntity<List<String>> getCropName(){
        return ResponseEntity.ok(cropService.getAllCropsName());
    }
}
