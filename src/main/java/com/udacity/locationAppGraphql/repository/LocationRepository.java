package com.udacity.locationAppGraphql.repository;

import com.udacity.locationAppGraphql.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
