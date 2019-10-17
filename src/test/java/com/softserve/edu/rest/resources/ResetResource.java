package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class ResetResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {
    public ResetResource() {
        super(RestUrlRepository.getResetUrl());
    }
}
