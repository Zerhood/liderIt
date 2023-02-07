package com.example.webproject.service;

import com.example.webproject.dao.AttractionDAO;
import com.example.webproject.entity.Attraction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImp implements AttractionService {

    private final AttractionDAO attractionDAO;

    public AttractionServiceImp(AttractionDAO attractionDAO) {
        this.attractionDAO = attractionDAO;
    }

    @Override
    public List<Attraction> getAllAttraction() {
        return attractionDAO.getAllAttraction();
    }

    @Override
    public List<Attraction> getAllAttrOfCity(String city) {
        return attractionDAO.getAllAttrOfCity(city);
    }

    @Override
    public Attraction addAttraction(Attraction attraction) {
        return attractionDAO.addAttraction(attraction);
    }

    @Override
    public Attraction editAttraction(Attraction attraction, String description) {
        return attractionDAO.editAttraction(attraction, description);
    }

    @Override
    public boolean deleteAttraction(Attraction attraction) {
        return attractionDAO.deleteAttraction(attraction);
    }
}