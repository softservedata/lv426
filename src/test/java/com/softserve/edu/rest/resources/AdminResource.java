package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class AdminResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity>  {
    public AdminResource() {
        super(RestUrlRepository.getAllAdmins());
    }
}
