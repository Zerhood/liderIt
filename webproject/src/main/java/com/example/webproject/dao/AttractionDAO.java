package com.example.webproject.dao;

import com.example.webproject.entity.Attraction;

import java.util.List;

public interface AttractionDAO {

    public List<Attraction> getAllAttraction();

    public List<Attraction> getAllAttrOfCity(String city);

    public Attraction addAttraction(Attraction attraction);

    public Attraction editAttraction(Attraction attraction, String description);

    public boolean deleteAttraction(Attraction attraction);
}
