package com.josiasmartins.spring_dynamodb_aws.models.DTO;

import com.josiasmartins.spring_dynamodb_aws.entity.Planet;
import lombok.Data;

@Data
public class PlanetResponse {

    private String name;
    private String planetChildren;

//    public PlanetResponse() {}

    public PlanetResponse(Planet planet) {
        this.name = planet.getName();
        this.planetChildren = planet.getPlanetChildren();
    }

}
