package com.udacity.locationAppGraphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.locationAppGraphql.entity.Location;
import com.udacity.locationAppGraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    LocationRepository locationRepository;

    public Query(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }

}
