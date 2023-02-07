package com.example.webproject.service;

import com.example.webproject.entity.City;

public interface CityService {

    public boolean addCity(City city);

    public boolean editCity(City city,
                            int population,
                            boolean metro);
}