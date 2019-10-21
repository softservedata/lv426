package com.softserve.edu.rest.resources;

import com.google.gson.Gson;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

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
    private Type classType;
    private Map<String, Integer> mapOfType;


    private Gson gson;

    protected RestQueries(RestUrl restUrl) {
        super(restUrl);
        classType = getClass().getGenericSuperclass();
        initClasses();
        gson = new Gson();
    }

    private void initClasses() {
        mapOfType = getMapOfIndex();
        this.classTGET = getClassInstance(classTGET, mapOfType.get("TGET"));
        this.classTPOST = getClassInstance(classTPOST, mapOfType.get("TPOST"));
        this.classTPUT = getClassInstance(classTPUT,  mapOfType.get("TPUT"));
        this.classTDELETE = getClassInstance(classTDELETE,  mapOfType.get("TDELETE"));

    }

    private Map<String, Integer> getMapOfIndex() {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < RestQueries.class.getTypeParameters().length; i++) {
            result.put(RestQueries.class.getTypeParameters()[i].getName(), i);
        }
        return result;
    }

    private <Z> Z convertToEntity(String json, Class<Z> someClass) {
        return gson.fromJson(json, someClass);
    }

    @SuppressWarnings("unchecked")
    private <X> Class<X> getClassInstance(Class<X> anyClass, int index) {
        return anyClass = (Class<X>) ((ParameterizedType) classType).getActualTypeArguments()[index];
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
