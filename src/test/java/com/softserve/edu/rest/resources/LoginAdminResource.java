package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;
import org.apache.commons.lang3.ObjectUtils;

public class LoginAdminResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

	public LoginAdminResource() {
		super(RestUrlRepository.getAdminAuthorized());
	}

}