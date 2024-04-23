package com.josiasmartins.spring_dynamodb_aws.controller;

import com.josiasmartins.spring_dynamodb_aws.entity.Planet;
import com.josiasmartins.spring_dynamodb_aws.models.DTO.PlanetRequest;
import com.josiasmartins.spring_dynamodb_aws.models.DTO.PlanetResponse;
import com.josiasmartins.spring_dynamodb_aws.repository.PlanetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/vi/planet")
public class PlanetController {

    private final PlanetRepository planetRepository;

    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetResponse createPlanet(@RequestBody PlanetRequest planetRequest) {
        var planet = new Planet(planetRequest);

        var result = this.planetRepository.save(planet);

        return new PlanetResponse(result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Planet> listPlanet() {

        List<Planet> listPlanet = toList(this.planetRepository.findAll());

        return listPlanet;
    }

    private static List<Planet> toList(final Iterable<Planet> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

}
