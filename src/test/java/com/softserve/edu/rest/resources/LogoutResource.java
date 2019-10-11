package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;
import org.apache.commons.lang3.ObjectUtils;

public class LogoutResource extends RestQueries<ObjectUtils.Null, SimpleEntity, ObjectUtils.Null, ObjectUtils.Null> {

    public LogoutResource() {
        super(RestUrlRepository.getLogout());
    }

}
