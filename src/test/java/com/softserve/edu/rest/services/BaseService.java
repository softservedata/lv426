package com.softserve.edu.rest.services;

import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ResetResource;

public class BaseService {

    public GuestService reset() {
        ResetResource resetResource = new ResetResource();
        SimpleEntity simpleEntity = resetResource.httpGetAsEntity(null, null);
        return new GuestService();
    }
}
