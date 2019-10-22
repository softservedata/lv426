package com.softserve.edu.rest.services;

import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ResetResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {
    //protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GuestService reset() {
        ResetResource resetResource = new ResetResource();
        SimpleEntity simpleEntity = resetResource.httpGetAsEntity(null, null);
        return new GuestService();
    }
}
