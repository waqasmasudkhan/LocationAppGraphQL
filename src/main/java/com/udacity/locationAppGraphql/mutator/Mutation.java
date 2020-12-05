package com.udacity.locationAppGraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.locationAppGraphql.entity.Location;
import com.udacity.locationAppGraphql.exception.LocationNotFoundException;
import com.udacity.locationAppGraphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    public boolean newLocation(Long Id, String name, String address){
        Location location = new Location(Id,name,address);
        Optional<Location> optionalLocation = Optional.ofNullable(locationRepository.save(location));
        if(optionalLocation.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteLocation(Long Id){
        boolean deleted;
        locationRepository.deleteById(Id);
        return true;
    }

    public Location updateLocationName(Long Id, String name){
        Optional optionalLocation = Optional.ofNullable(locationRepository.findById(Id));
        if(optionalLocation.isPresent()){
            Location newLocation = (Location) optionalLocation.get();
            newLocation.setName(name);
            locationRepository.save(newLocation);
            return newLocation;
        }
        else{
            throw new LocationNotFoundException(Id,"Location was not found");
        }
    }



}
