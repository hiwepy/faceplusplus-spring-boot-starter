package com.faceplusplus.spring.boot;

import lombok.extern.slf4j.Slf4j;

/**
 * https://docs.agora.io/cn/Interactive%20Broadcast/rtc_channel_event?platform=RESTful
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
@Slf4j
public class AgoraTemplate {

	private AgoraOkHttp3Template agoraOkHttp3Template;
	private FaceppProperties agoraProperties;

	private final AgoraChannelManagerAsyncOperations facesetOps = new AgoraChannelManagerAsyncOperations(this);
	private final AgoraCloudRecordingAsyncOperations cloudRecordingOps = new AgoraCloudRecordingAsyncOperations(this);

	public AgoraTemplate(AgoraOkHttp3Template agoraOkHttp3Template, FaceppProperties agoraProperties) {
		this.agoraOkHttp3Template = agoraOkHttp3Template;
		this.agoraProperties = agoraProperties;
	}

	public AgoraChannelManagerAsyncOperations opsForFaceset() {
		return facesetOps;
	}

	public AgoraCloudRecordingAsyncOperations opsForCloudRecording() {
		return cloudRecordingOps;
	}

	public FaceppProperties getAgoraProperties() {
		return agoraProperties;
	}

	public AgoraOkHttp3Template getAgoraOkHttp3Template() {
		return agoraOkHttp3Template;
	}
}
