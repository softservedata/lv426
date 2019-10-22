package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class LoginResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

	public LoginResource() {
		super(RestUrlRepository.getUserAuthorized(),
				SimpleEntity.class, SimpleEntity.class,
				SimpleEntity.class, SimpleEntity.class);
	}

}