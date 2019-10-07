package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class LogoutResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public LogoutResource() {
    	super(RestUrlRepository.getLogout(),
				SimpleEntity.class, SimpleEntity.class,
				SimpleEntity.class, SimpleEntity.class);
    }

}
