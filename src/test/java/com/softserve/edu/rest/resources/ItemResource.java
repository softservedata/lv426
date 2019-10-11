package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class ItemResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity>{

    public ItemResource() {
        super(RestUrlRepository.getItem());
    }
}
