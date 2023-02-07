package com.example.webproject.service;

import com.example.webproject.entity.Attraction;

import java.util.List;

public interface AttractionService {

    public List<Attraction> getAllAttraction();

    public List<Attraction> getAllAttrOfCity(String city);

    public Attraction addAttraction(Attraction attraction);

    public Attraction editAttraction(Attraction attraction, String description);

    public boolean deleteAttraction(Attraction attraction);
}