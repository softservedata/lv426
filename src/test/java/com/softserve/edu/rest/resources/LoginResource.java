package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;
import org.apache.commons.lang3.ObjectUtils;

public class LoginResource extends RestQueries<ObjectUtils.Null, SimpleEntity, ObjectUtils.Null, ObjectUtils.Null> {

	public LoginResource() {
		super(RestUrlRepository.getUserAuthorized());
	}

}