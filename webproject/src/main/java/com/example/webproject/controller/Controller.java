package com.example.webproject.controller;

import com.example.webproject.entity.Attraction;
import com.example.webproject.entity.City;
import com.example.webproject.service.AttractionService;
import com.example.webproject.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final CityService cityService;
    private final AttractionService attractionService;

    public Controller(CityService cityService,
                      AttractionService attractionService) {
        this.cityService = cityService;
        this.attractionService = attractionService;
    }

    @GetMapping("/attractions")
    public ResponseEntity<?> getAllAttraction() {
        List<Attraction> allAttraction = attractionService.getAllAttraction();
        return ResponseEntity.ok().body(allAttraction);
    }

    @GetMapping("/attractions/{city}")
    public ResponseEntity<?> getAllAttrOfCity(@PathVariable("city") String city) {
        return ResponseEntity.ok().body(attractionService.getAllAttrOfCity(city));
    }

    @PostMapping("/city")
    public ResponseEntity<?> createCity(@RequestBody City city) {
        return ResponseEntity.ok().body(cityService.addCity(city));
    }


    @PostMapping("/attractions")
    public ResponseEntity<?> createAttraction(@RequestBody Attraction attraction) {
        return ResponseEntity.ok().body(attractionService.addAttraction(attraction));
    }

    @PutMapping("/city/{cityId}")
    public ResponseEntity<?> updateCity(@PathVariable("cityId") City city,
                                        @RequestParam int population,
                                        @RequestParam boolean metro) {
        return ResponseEntity.ok().body(cityService.editCity(city, population, metro));
    }

    @PutMapping("/attractions/{attractionId}")
    public ResponseEntity<?> updateAttraction(@PathVariable("attractionId") Attraction attraction, String description) {
        return ResponseEntity.ok().body(attractionService.editAttraction(attraction, description));
    }

    @DeleteMapping("/attractions/{attractionId}")
    public ResponseEntity<?> deleteAttraction(@PathVariable("attractionId") Attraction attraction) {
        return ResponseEntity.ok().body(attractionService.deleteAttraction(attraction));
    }
}