package com.softserve.edu;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.regex.Pattern;

class MyGet {}
class MyPost {}
class MyPut {}
class MyDelete {}

class RestQs<TGET, TPOST, TPUT, TDELETE> {

	private <T> void convertToEnt(String json, Class<T> someClass) {
		System.out.println("json text = " + json + "  someClass name = " + someClass.getName());
	}

	//@SuppressWarnings("unchecked")
	private <T> String convertToEnt(Class<T> anyClass, int index) {
		Type mt = getClass().getGenericSuperclass();
		System.out.println("mt type name" + mt.getTypeName());
		String className = ((ParameterizedType) mt).getActualTypeArguments()[index].getTypeName();
		System.out.println("convertToEnt className = " + className);
		return className;
	}

	public void anyMethodGET() throws Exception {
		convertToEnt("anyMethodGET()", Class.forName(convertToEnt(MyGet.class, 0)));
	}

//	public void anyMethodPOST() {
//		convertToEnt("anyMethodGET()", (Class<TPOST>) convertToEnt(1));
//	}
//
//	public void anyMethodPUT() {
//		convertToEnt("anyMethodGET()", (Class<TPUT>) convertToEnt(2));
//	}
//
//	public void anyMethodDELETE() {
//		convertToEnt("anyMethodGET()", (Class<TDELETE>) convertToEnt(3));
//	}
}

public class ApplRst {

	public static void main(String[] args) throws Exception {
//		RestQs<MyGet, MyPost, MyPut, MyDelete> rs = new RestQs<>();
//		rs.anyMethodGET();
//		rs.anyMethodPOST();
//		rs.anyMethodPUT();
//		rs.anyMethodDELETE();
		String url = "http://localhost:8080/locked/user/{name}";
        String searchVariable = "{name}";
        String newPar = "123";
        url = url.replaceFirst(Pattern.quote(searchVariable), newPar);
        System.out.println("url = " + url);
	}
}
