package com.example.webproject.dao;

import com.example.webproject.entity.City;

public interface CityDAO {

    public boolean addCity(City city);

    public boolean editCity(City city,
                            int population,
                            boolean metro);
}