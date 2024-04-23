package com.josiasmartins.spring_dynamodb_aws.controller;

import com.josiasmartins.spring_dynamodb_aws.entity.Galaxia;
import com.josiasmartins.spring_dynamodb_aws.entity.Planet;
import com.josiasmartins.spring_dynamodb_aws.models.DTO.PlanetGalaxDTO;
import com.josiasmartins.spring_dynamodb_aws.repository.GalaxiaRepository;
import com.josiasmartins.spring_dynamodb_aws.repository.PlanetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vi/galaxia")
public class GalaxiaController {

    private final GalaxiaRepository galaxiaRepository;
    private final PlanetRepository planetRepository;

    public GalaxiaController(GalaxiaRepository galaxiaRepository, PlanetRepository planetRepository) {
        this.galaxiaRepository = galaxiaRepository;
        this.planetRepository = planetRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Galaxia createGalaxia(@RequestBody Galaxia galaxia) {

        return this.galaxiaRepository.save(galaxia);
    }

    @GetMapping("/{id_planet}/{id_galaxia}")
    @ResponseStatus(HttpStatus.OK)
    public PlanetGalaxDTO getGalaxia(
            @PathVariable("id_planet") String idPlanet,
            @PathVariable("id_galaxia") String idGalaxia
    ) {
//        Galaxia galaxia = this.galaxiaRepository.findById(idPlanet)
        Planet planet = this.planetRepository.findById(idPlanet).get();
        Galaxia galaxia = this.galaxiaRepository.findById(idGalaxia).get();

        return new PlanetGalaxDTO(planet, galaxia);

    }

}
