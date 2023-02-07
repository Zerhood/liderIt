package com.example.webproject.dao;

import com.example.webproject.entity.Attraction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AttractionDAOImpl implements AttractionDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    public AttractionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Attraction> getAllAttraction() {
        return entityManager
                .createQuery("FROM Attraction AS a ORDER BY a.type ASC", Attraction.class)
                .getResultList();
    }

    @Override
    public List<Attraction> getAllAttrOfCity(String city) {
        return entityManager
                .createQuery("FROM Attraction AS a WHERE a.city = ?1", Attraction.class)
                .getResultList();
    }

    @Override
    public Attraction addAttraction(Attraction attraction) {
        entityManager.persist(attraction);
        return attraction;
    }

    @Override
    public Attraction editAttraction(Attraction attraction, String description) {
        Attraction original = entityManager.find(Attraction.class, attraction.getId());
        if (original != null) {
            original.setDescription(description);
        }
        return entityManager.merge(original);
    }

    @Override
    public boolean deleteAttraction(Attraction attraction) {
        Attraction original = entityManager.find(Attraction.class, attraction.getId());
        if (original != null) {
            entityManager.remove(original);
            return true;
        } else {
            return false;
        }
    }
}
