package com.softserve.edu.rest.resources;

import com.google.gson.Gson;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;

import java.lang.reflect.ParameterizedType;

public class RestQueries<TGET, TPOST, TPUT, TDELETE> extends RestCrud {

    private final String CONVERT_OBJECT_ERROR = "ConvertToObject Error. %s%s";
    //
    //protected final Logger log = Logger.getLogger(this.getClass());
    //
    // TODO Move Converter to class

    private Class<TGET> classTGET;
    private Class<TPOST> classTPOST;
    private Class<TPUT> classTPUT;
    private Class<TDELETE> classTDELETE;

    private Gson gson;

    protected RestQueries(RestUrl restUrl) {
        super(restUrl);
        this.classTGET = getClassInstance(classTGET, 0);
        this.classTPOST = getClassInstance(classTPOST, 1);
        this.classTPUT = getClassInstance(classTPUT, 2);
        this.classTDELETE = getClassInstance(classTDELETE, 3);
        gson = new Gson();
    }

    private <Z> Z convertToEntity(String json, Class<Z> someClass) {
        return gson.fromJson(json, someClass);
    }

    @SuppressWarnings("unchecked")
    private <X> Class<X> getClassInstance(Class<X> anyClass, int index) {
        return anyClass = (Class<X>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[index];

    }

    // Entity - - - - - - - - - - - - - - - - - - - -
    public TGET httpGetAsEntity(RestParameters pathVariables, RestParameters urlParameters) {
        return convertToEntity(httpGetAsText(pathVariables, urlParameters), classTGET);
    }

    public TPOST httpPostAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                  RestParameters bodyParameters) {
        return convertToEntity(httpPostAsText(pathVariables, urlParameters, bodyParameters), classTPOST);
    }

    public TPUT httpPutAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                RestParameters bodyParameters) {
        return convertToEntity(httpPutAsText(pathVariables, urlParameters, bodyParameters), classTPUT);
    }

    public TDELETE httpDeleteAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                      RestParameters bodyParameters) {
        return convertToEntity(httpDeleteAsText(pathVariables, urlParameters, bodyParameters), classTDELETE);

    }

    // List Entity - - - - - - - - - - - - - - - - - - - -

    // TODO
    //public List<TGET> httpGetAsObject(RestParameters urlParameters, RestParameters pathVariables)
    //public List<TPOST> httpPostAsObject(RestParameters urlParameters,
    //    RestParameters pathVariables, RestParameters bodyParameters)
    //public List<TPUT> httpPutAsObject(RestParameters urlParameters,
    //    RestParameters pathVariables, RestParameters bodyParameters)
    //public List<TDELETE> httpDeleteAsObject(RestParameters urlParameters,
    //    RestParameters pathVariables, RestParameters bodyParameters)
}
