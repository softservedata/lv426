package com.softserve.edu.rest.resources;

import java.io.IOException;
import java.util.regex.Pattern;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class RestCrud {
	private final String NOT_SUPPORT_MESSAGE = "Method %s not Support for %s Resource";
    //
    private final String URL_PARAMETERS_SEPARATOR = "?";
    private final String NEXT_PARAMETERS_SEPARATOR = "&";
    private final String KEY_VALUE_SEPARATOR = "=";
    //
    private RestUrl restUrl;
    private OkHttpClient client;

    public RestCrud(RestUrl restUrl)
    {
        this.restUrl = restUrl;
        client = new OkHttpClient();
    }

    // protected - - - - - - - - - - - - - - - - - - - -

//    protected void ThrowException(string message)
//    {
//        // TODO Develop Custom Exception
//        string resourceName = this.GetType().ToString();
//        throw new Exception(string.Format(NOT_SUPPORT_MESSAGE, message, resourceName));
//    }

//    protected void CheckImplementation(RestUrlKeys restUrlKeys)
//    {
//        // if (restUrl.GetUrl(restUrlKeys).Length == 0)
//        if (string.IsNullOrEmpty(restUrl.GetUrl(restUrlKeys)))
//        {
//            ThrowException(restUrlKeys.ToString());
//        }
//    }

    // Parameters - - - - - - - - - - - - - - - - - - - -

    private String prepareUrlParameters(String urlTemplate, RestParameters urlParameters)
    {
        if (urlParameters != null)
        {
            boolean isFirstParameter = true;
            for (String currentKey : urlParameters.getAllParameters().keySet()) {
                if (isFirstParameter)
                {
                    urlTemplate = urlTemplate + URL_PARAMETERS_SEPARATOR;
                    isFirstParameter = false;
                }
                else
                {
                    urlTemplate = urlTemplate + NEXT_PARAMETERS_SEPARATOR;
                }
                urlTemplate = urlTemplate + currentKey + KEY_VALUE_SEPARATOR + urlParameters.getParameter(currentKey);
            }
        }
        return urlTemplate;
    }

    private String preparePathVariables(String urlTemplate, RestParameters pathVariables) {
    	String url = urlTemplate;
    	String searchVariable;
        if (pathVariables != null) {
            for (String currentKey : pathVariables.getAllParameters().keySet()) {
            	// TODO Create Const
                searchVariable = "{" + currentKey + "}";
                if (url.contains(searchVariable)) {
                	// TODO Move to RegexUtils
                    url = url.replaceFirst(Pattern.quote(searchVariable), pathVariables.getParameter(currentKey));
                }
            }
        }
        return url;
    }

    private RequestBody prepareRequestBody(RestParameters bodyParameters) {
    	RequestBody requestBody = null;
        if (bodyParameters != null) {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (String currentKey : bodyParameters.getAllParameters().keySet()) {
                formBodyBuilder.add(currentKey, bodyParameters.getParameter(currentKey));
            }
            requestBody = formBodyBuilder.build();
        }
        return requestBody;
    }

    // Request - - - - - - - - - - - - - - - - - - - -

    private Request.Builder prepareRequestBuilder(String requestUrl, RestParameters pathVariables,
            RestParameters urlParameters) {
        if ((requestUrl == null) || (requestUrl.isEmpty())) {
            // TODO Develop Custom Exception
            //log.error("prepareRequestBuilder() Error ");
            throw new RuntimeException("prepareRequestBuilder() Error");

        }
        String url = preparePathVariables(requestUrl, pathVariables);
        url = prepareUrlParameters(url, urlParameters);
        return new Request.Builder().url(url);
    }
    
    private Response executeRequest(Request request) {
        Response result = null;
        try {
            result = client.newCall(request).execute();
        } catch (IOException e) {
            // TODO Develop Custom Exception
            //log.error("Request Error ");
            throw new RuntimeException("Request Error " + e.toString());
        }
        return result;
    }
    
    private String responseBodyAsText(Response response) {
        String responseText = null;
        try {
            responseText = response.body().string();
        } catch (IOException e) {
            // TODO Develop Custom Exception + Log
            // e.printStackTrace();
            //log.error("Error to get text from ResponseBody.");
            throw new RuntimeException("Error to get text from ResponseBody." + e.toString());
        }
        return responseText;
    }
    
    // Http Get - - - - - - - - - - - - - - - - - - - -

    protected Response httpGetAsResponse(RestParameters pathVariables, RestParameters urlParameters) {
        return executeRequest(prepareRequestBuilder(restUrl.readGetUrl(), pathVariables, urlParameters).get().build());
    }

    protected String httpGetAsText(RestParameters pathVariables, RestParameters urlParameters) {
    	return responseBodyAsText(httpGetAsResponse(pathVariables, urlParameters));
    }

    // Http Post - - - - - - - - - - - - - - - - - - - -

    protected Response httpPostAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return executeRequest(prepareRequestBuilder(restUrl.readPostUrl(), pathVariables, urlParameters)
                .post(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpPostAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpPostAsResponse(pathVariables, urlParameters, bodyParameters));
    }

    // Http Put - - - - - - - - - - - - - - - - - - - -

    protected Response httpPutAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return executeRequest(prepareRequestBuilder(restUrl.readPutUrl(), pathVariables, urlParameters)
                .put(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpPutAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpPutAsResponse(pathVariables, urlParameters, bodyParameters));
    }

    // Http Delete - - - - - - - - - - - - - - - - - - - -

    protected Response httpDeleteAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return executeRequest(prepareRequestBuilder(restUrl.readDeleteUrl(), pathVariables, urlParameters)
                .delete(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpDeleteAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpDeleteAsResponse(pathVariables, urlParameters, bodyParameters));
    }

}