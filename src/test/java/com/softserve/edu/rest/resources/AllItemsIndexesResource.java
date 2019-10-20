package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class AllItemsIndexesResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public AllItemsIndexesResource() {
        super(RestUrlRepository.getAllItemsIndexes());
    }
}
