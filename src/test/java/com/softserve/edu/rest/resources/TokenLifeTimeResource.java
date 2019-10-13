package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class TokenLifeTimeResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public TokenLifeTimeResource() {
        super(RestUrlRepository.getTokenLifetime());

    }
}
