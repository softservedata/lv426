package com.softserve.edu.rest.resources;

import com.google.gson.Gson;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;

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

    protected RestQueries(RestUrl restUrl,
    		Class<TGET> classTGET, Class<TPOST> classTPOST,
    		Class<TPUT> classTPUT, Class<TDELETE> classTDELETE) {
        super(restUrl);
        this.classTGET = classTGET;  // TODO Get Class<T> from <T>
        this.classTPOST = classTPOST;
        this.classTPUT = classTPUT;
        this.classTDELETE = classTDELETE;
        gson = new Gson();
    }
    
    // TODO Move Converter to class
    private TGET convertToEntityTGET(String json) {
        return gson.fromJson(json, classTGET);
    }
    
    private TPOST convertToEntityTPOST(String json) {
        return gson.fromJson(json, classTPOST);
    }
    
    private TPUT convertToEntityTPUT(String json) {
        return gson.fromJson(json, classTPUT);
    }
    
    private TDELETE convertToEntityTDELETE(String json) {
        return gson.fromJson(json, classTDELETE);
    }
    
    // Entity - - - - - - - - - - - - - - - - - - - -

    public TGET httpGetAsEntity(RestParameters pathVariables, RestParameters urlParameters) {
        return convertToEntityTGET(httpGetAsText(pathVariables, urlParameters));
    }

    public TPOST httpPostAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                              RestParameters bodyParameters) {
        return convertToEntityTPOST(httpPostAsText(pathVariables, urlParameters, bodyParameters));
    }

    public TPUT httpPutAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                             RestParameters bodyParameters) {
        return convertToEntityTPUT(httpPutAsText(pathVariables, urlParameters, bodyParameters));
    }

    public TDELETE httpDeleteAsEntity(RestParameters pathVariables, RestParameters urlParameters,
                                RestParameters bodyParameters) {
        return convertToEntityTDELETE(httpDeleteAsText(pathVariables, urlParameters, bodyParameters));
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
