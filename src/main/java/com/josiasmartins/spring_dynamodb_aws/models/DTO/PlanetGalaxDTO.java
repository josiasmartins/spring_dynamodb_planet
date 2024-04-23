package com.josiasmartins.spring_dynamodb_aws.models.DTO;


import com.josiasmartins.spring_dynamodb_aws.entity.Galaxia;
import com.josiasmartins.spring_dynamodb_aws.entity.Planet;
import lombok.Data;

@Data
public class PlanetGalaxDTO {

    private Galaxia galaxia;
    private Planet planet;

    public PlanetGalaxDTO(Planet planet, Galaxia galaxia) {
        this.planet = planet;
        this.galaxia = galaxia;
    }

}
