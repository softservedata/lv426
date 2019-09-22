package com.softserve.edu;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRequest {
	
	public static void main(String[] args) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://me.citrus.ua/api/users/profile").get().addHeader(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE1NjgzODAwMDUsImV4cCI6MTU5OTkxNjAwNSwiaWQiOjYwNTg1NTcsInVzZXJuYW1lIjoidXdpYnBiQGtsZmIuYm5wIiwiYXV0aG9yaXphdGlvblR5cGUiOiJkZWZhdWx0In0.X-dywQHOOgieq9U04YJ4ii_aCZqS_kkbhfj6r6SIAb7XbcBVKwGWkaCBjCHU5ko_J5dI5bnosXCAvF_zsE2ehtgVy_ySAaHYVg3-uISEqIPh2nazWrN5dA69crSR2wg9Kk_9LeAcsNxBIeI8vKkK8LbBg63t1l43q4o6S4TuigBDTNMgcdnhxfSEi2nOnD1ikcJODZxokEDRy8jA-d_Wm7PysXNPUahbOK0YXbj6egqL6wAkPBzUyD9zud81tqQpVToILeWTC7uPRWL--wktHjCcfaASNMHxnH55_dwMhcfwdcBQD3iyCRMlQdV3Gy-O3BO1wo2cXBaWazFIVUJKtlrsEcaOEqsKAH20L2k-U5Ktv8Ovh5WQfuCdtOxOqkPLLvU9On53-SkG_3QlnZ8B3n9DF-Ab5jegAB22bjG5xo1Cv-E16DdfPhohEVe_cqKBuKQnmoL6HTM4ZvMdFyElFHmySwwxZtEmOTjcq9Wj_iI5d61QH-Oz47H187Ridyo2zOap8KhiURs6s_9oj3rYU5Qru50bwzgqxZhDYqm9Pt010TpYH4u4ftQT8DuYACbVHLLR_okpXLgdH9krTWlXdN-9OJXDMYdiD0C8Jk7KSyTjdqgW5w5ZbRMriVhSnvWkqOUhMyVTDas3IA0ULwyeDEPBGd3AwsAqqX9XV6poewY")
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
	}
	
}
