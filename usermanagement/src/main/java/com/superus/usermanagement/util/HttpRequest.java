package com.superus.usermanagement.util;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class HttpRequest {

	public static JSONObject httprequest(HttpServletRequest request) throws Exception {
		BufferedReader reader = request.getReader();
		StringBuilder builder = new StringBuilder();
		String line = "";
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		JSONObject json = new JSONObject(builder.toString());
		return json;
	}

}
