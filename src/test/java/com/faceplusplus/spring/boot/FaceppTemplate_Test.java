package com.faceplusplus.spring.boot;

import com.faceplusplus.spring.boot.resp.FacesetCreateResponse;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.faceplusplus.spring.boot.resp.AcquireResourceResponse;
import okhttp3.OkHttpClient;

public class FaceppTemplate_Test {

	ObjectMapper objectMapper = new ObjectMapper();
	OkHttpClient okhttp3Client = new OkHttpClient.Builder().build();
	FaceppProperties properties = new FaceppProperties();
	AgoraTemplate template;

	@Before
	public void setup() {
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		properties.setAppId("");
		properties.setAppCertificate("");
		properties.setLoginKey("");
		properties.setLoginSecret("");
		AgoraOkHttp3Template agoraOkHttp3Template = new AgoraOkHttp3Template(okhttp3Client, objectMapper, properties);
		template = new AgoraTemplate(agoraOkHttp3Template, properties );

	}

	//@Test
	public void testAcquireId() throws Exception {

		AcquireResourceResponse response =  template.opsForCloudRecording().acquireId("10000", "121212");
		System.out.println(objectMapper.writeValueAsString(response));

	}


	@Test
	public void testGetChannelUserState() throws Exception {

		FacesetCreateResponse response =  template.opsForFaceset().createFaceset(null);
		System.out.println(objectMapper.writeValueAsString(response));

	}

}
