package com.faceplusplus.spring.boot;

import com.faceplusplus.spring.boot.resp.FacesetCreateResponse;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

public class FaceppTemplate_Test {

	ObjectMapper objectMapper = new ObjectMapper();
	OkHttpClient okhttp3Client = new OkHttpClient.Builder().build();
	FaceppProperties properties = new FaceppProperties();
	FaceppTemplate template;

	@Before
	public void setup() {
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		properties.setAppId("");
		properties.setAppCertificate("");
		properties.setLoginKey("");
		properties.setLoginSecret("");
		FaceppOkHttp3Template faceppOkHttp3Template = new FaceppOkHttp3Template(okhttp3Client, objectMapper, properties);
		template = new FaceppTemplate(faceppOkHttp3Template, properties );

	}

	@Test
	public void testGetChannelUserState() throws Exception {

		FacesetCreateResponse response =  template.opsForFaceset().createFaceset(null);
		System.out.println(objectMapper.writeValueAsString(response));

	}

}
