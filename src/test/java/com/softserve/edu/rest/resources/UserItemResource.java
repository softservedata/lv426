package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class UserItemResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity>{

    public UserItemResource() {
        super(RestUrlRepository.getUserItem());
    }
}
