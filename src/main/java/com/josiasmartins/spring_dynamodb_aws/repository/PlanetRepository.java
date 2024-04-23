package com.josiasmartins.spring_dynamodb_aws.repository;

import com.josiasmartins.spring_dynamodb_aws.entity.Planet;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@EnableScan
public interface PlanetRepository extends CrudRepository<Planet, UUID> {
}
