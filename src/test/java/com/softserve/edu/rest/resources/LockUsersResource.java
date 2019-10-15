package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestUrl;
import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.entity.SimpleEntity;

public class LockUsersResource  extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity>{
    public LockUsersResource() {
        super(RestUrlRepository.getLockedUsers());
    }
}
