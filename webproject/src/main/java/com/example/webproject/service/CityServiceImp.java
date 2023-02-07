package com.example.webproject.service;

import com.example.webproject.dao.CityDAO;
import com.example.webproject.entity.City;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImp implements CityService {

    private final CityDAO cityDAO;

    public CityServiceImp(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public boolean addCity(City city) {
        return cityDAO.addCity(city);
    }

    @Override
    public boolean editCity(City city, int population, boolean metro) {
        return cityDAO.editCity(city, population, metro);
    }
}