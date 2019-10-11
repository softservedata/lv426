package com.softserve.edu.rest.resources;

import com.google.gson.Gson;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public class RestQueries<TGET, TPOST, TPUT, TDELETE> extends RestCrud {

    private final String CONVERT_OBJECT_ERROR = "ConvertToObject Error. %s\n%s";
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
        this.classTGET = getEmptyInstance(classTGET, 0);  // TODO Get Class<T> from <T>
        this.classTPOST = getEmptyInstance(classTPOST, 1);
        this.classTPUT = getEmptyInstance(classTPUT, 2);
        this.classTDELETE = getEmptyInstance(classTDELETE, 3);
        gson = new Gson();
    }

    @SuppressWarnings("unchecked")
    private <X> Class<X> getEmptyInstance(Class<X> clazz, int index) {
        clazz = ((Class<X>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[index]);
        return clazz;
    }
    private <T> T convertTo(String json, Class<T> current) {
        return gson.fromJson(json, current);
    }
    // Entity - - - - - - - - - - - - - - - - - - - -
    public TGET httpGetAsEntity(RestParameters pathVariables, RestParameters urlParameters) {

        return convertTo(httpGetAsText(pathVariables, urlParameters), classTGET);
    }

    public TPOST httpPostAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                  RestParameters bodyParameters) {
        return convertTo(httpPostAsText(pathVariables, urlParameters, bodyParameters), classTPOST);
    }

    public TPUT httpPutAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                RestParameters bodyParameters) {
        return convertTo(httpPutAsText(pathVariables, urlParameters, bodyParameters), classTPUT);
    }

    public TDELETE httpDeleteAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                      RestParameters bodyParameters) {
        return convertTo(httpDeleteAsText(pathVariables, urlParameters, bodyParameters), classTDELETE);
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
