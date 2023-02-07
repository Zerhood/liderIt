package com.example.webproject.dao;

import com.example.webproject.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CityDAOImpl implements CityDAO {

    private final EntityManager entityManager;

    public CityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean addCity(City city) {
        City original = entityManager.find(City.class, city.getId());
        if (original == null) {
            entityManager.persist(city);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editCity(City city, int population, boolean metro) {
        City original = entityManager.find(City.class, city.getId());
        if (original != null) {
            original.setPopulation(population);
            original.setMetro(metro);
            entityManager.merge(original);
            return true;
        } else {
            return false;
        }
    }
}