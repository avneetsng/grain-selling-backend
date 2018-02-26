package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.model.Crop;
import com.prayasj.gndit.grainselling.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<String> getAllCropsName(){
        List<Crop> crops = cropRepository.findAll();
        List<String> cropNames = new ArrayList<>();
        for (Crop crop : crops) {
            cropNames.add(crop.getName());
        }
        return cropNames;
    }
}
