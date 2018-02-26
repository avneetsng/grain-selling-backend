package com.prayasj.gndit.grainselling.service;

import com.prayasj.gndit.grainselling.model.Crop;
import com.prayasj.gndit.grainselling.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<String> getAllCropsName(){
        List<Crop> crops = cropRepository.findAll();
        return crops.stream().map(new Function<Crop, String>() {
            @Override
            public String apply(Crop crop) {
                return crop.getName();
            }
        }).collect(Collectors.toList());
    }
}
