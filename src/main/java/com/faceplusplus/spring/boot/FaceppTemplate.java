package com.faceplusplus.spring.boot;

import lombok.extern.slf4j.Slf4j;

/**
 * https://docs.agora.io/cn/Interactive%20Broadcast/rtc_channel_event?platform=RESTful
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
@Slf4j
public class FaceppTemplate {

	private FaceppOkHttp3Template faceppOkHttp3Template;
	private FaceppProperties faceppProperties;

	private final FaceppFacesetAsyncOperations facesetOps = new FaceppFacesetAsyncOperations(this);
	private final FaceppFaceAsyncOperations faceDetectOps = new FaceppFaceAsyncOperations(this);
	private final FaceppCloudRecordingAsyncOperations cloudRecordingOps = new FaceppCloudRecordingAsyncOperations(this);



	public FaceppTemplate(FaceppOkHttp3Template faceppOkHttp3Template, FaceppProperties faceppProperties) {
		this.faceppOkHttp3Template = faceppOkHttp3Template;
		this.faceppProperties = faceppProperties;
	}

	public FaceppFacesetAsyncOperations opsForFaceset() {
		return facesetOps;
	}

	public FaceppFaceAsyncOperations opsForFaceDetect() {
		return faceDetectOps;
	}
	public FaceppCloudRecordingAsyncOperations opsForCloudRecording() {
		return cloudRecordingOps;
	}

	public FaceppProperties getFaceppProperties() {
		return faceppProperties;
	}

	public FaceppOkHttp3Template getFaceppOkHttp3Template() {
		return faceppOkHttp3Template;
	}


}
