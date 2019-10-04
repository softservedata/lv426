package com.softserve.edu.rest.dto;

import java.util.HashMap;
import java.util.Map;

public class RestUrl {
	private Map<RestUrlKeys, String> urls;

	public RestUrl() {
		urls = new HashMap<>();
	}

	public RestUrl addUrl(RestUrlKeys key, String url) {
		urls.put(key, url);
		return this;
	}

	public String getUrl(RestUrlKeys key) {
		return urls.get(key);
	}

	public RestUrl addBaseUrl(String url) {
		urls.put(RestUrlKeys.BASE, url);
		return this;
	}

	public RestUrl addGetUrl(String url) {
		urls.put(RestUrlKeys.GET, url);
		return this;
	}

	public RestUrl addPostUrl(String url) {
		urls.put(RestUrlKeys.POST, url);
		return this;
	}

	public RestUrl addPutUrl(String url) {
		urls.put(RestUrlKeys.PUT, url);
		return this;
	}

	public RestUrl addDeleteUrl(String url) {
		urls.put(RestUrlKeys.DELETE, url);
		return this;
	}

	public String readBaseUrl() {
		return urls.get(RestUrlKeys.BASE);
	}

	public String readGetUrl() {
		return urls.get(RestUrlKeys.GET);
	}

	public String readPostUrl() {
		return urls.get(RestUrlKeys.POST);
	}

	public String readPutUrl() {
		return urls.get(RestUrlKeys.PUT);
	}

	public String readDeleteUrl() {
		return urls.get(RestUrlKeys.DELETE);
	}
}
