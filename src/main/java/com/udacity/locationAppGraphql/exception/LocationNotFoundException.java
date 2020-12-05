package com.udacity.locationAppGraphql.exception;


import com.udacity.locationAppGraphql.entity.Location;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationNotFoundException extends RuntimeException implements GraphQLError {
    HashMap<String, Object> extensions = new HashMap();

    public LocationNotFoundException(Long Id,String message){
        super(message);
        extensions.put("InvalidLocationId",message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
