package com.faceplusplus.spring.boot;

import okhttp3.*;

import com.faceplusplus.media.RtcTokenBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * https://docs.agora.io/cn/Interactive%20Broadcast/rtc_channel_event?platform=RESTful
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */

@Slf4j
public class AgoraTemplate {

	public final static String APPLICATION_JSON_VALUE = "application/json";
	public final static String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
	public final static MediaType APPLICATION_JSON = MediaType.parse(APPLICATION_JSON_VALUE);
	public final static MediaType APPLICATION_JSON_UTF8 = MediaType.parse(APPLICATION_JSON_UTF8_VALUE);

    public static int TRY_MAX = 5;

	private static RtcTokenBuilder token = new RtcTokenBuilder();

	private AgoraUserIdProvider userIdProvider;
	private AgoraOkHttp3Template agoraOkHttp3Template;
	private FaceppProperties agoraProperties;

	private final AgoraChannelManagerAsyncOperations facesetOps = new AgoraChannelManagerAsyncOperations(this);
	private final AgoraCloudRecordingAsyncOperations cloudRecordingOps = new AgoraCloudRecordingAsyncOperations(this);

	public AgoraTemplate(AgoraUserIdProvider userIdProvider, AgoraOkHttp3Template agoraOkHttp3Template, FaceppProperties agoraProperties) {
		this.userIdProvider = userIdProvider;
		this.agoraOkHttp3Template = agoraOkHttp3Template;
		this.agoraProperties = agoraProperties;
	}

	public AgoraChannelManagerAsyncOperations opsForFaceset() {
		return facesetOps;
	}

	public AgoraCloudRecordingAsyncOperations opsForCloudRecording() {
		return cloudRecordingOps;
	}

	public String generateToken(String userId, String channelName) {
		return this.generateToken(userId, channelName, RtcTokenBuilder.Role.Role_Publisher);
	}

    public String generateToken(int userId, String channelName, RtcTokenBuilder.Role role) {
        int timestamp = (int)(System.currentTimeMillis() / 1000 + agoraProperties.getExpirationTimeInSeconds());
        log.info("{} >> Agora Token Expiration Time : {}s ", channelName, timestamp);
        String result = token.buildTokenWithUid(agoraProperties.getAppId(), agoraProperties.getAppCertificate(),
        		channelName, userId, role, timestamp);
        log.info("{} >> Agora Token : {} << AppId:{}, AppCertificate: {}, Role : {}", channelName, result, agoraProperties.getAppId(), agoraProperties.getAppCertificate(), role);
        return result;
    }

	public String generateToken(String userId, String channelName, RtcTokenBuilder.Role role) {
		int timestamp = (int)(System.currentTimeMillis() / 1000 + agoraProperties.getExpirationTimeInSeconds());
		log.info("{} >> Agora Token Expiration Time : {}s ", channelName, timestamp);
		String result = token.buildTokenWithUserAccount(agoraProperties.getAppId(), agoraProperties.getAppCertificate(),
				channelName, userId, role, timestamp);
		log.info("{} >> Agora Token : {} << AppId:{}, AppCertificate: {}, Role : {}", channelName, result, agoraProperties.getAppId(), agoraProperties.getAppCertificate(), role);
		return result;
	}


	/**
	 * 根据Agora频道名称获取用户id
	 *
	 * @param channel Agora频道名称
	 * @return 从Agora频道名称解析出来的用户ID
	 */
	public String getUserIdByChannel(String channel) {
		return userIdProvider.getUserIdByChannel(agoraProperties.getAppId(), channel);
	}

	/**
	 * 根据用户id获取Agora频道名称
	 *
	 * @param userId 用户ID
	 * @return 用户ID生成的Agora频道名称
	 */
	public String getChannelByUserId(String userId) {
		return userIdProvider.getChannelByUserId(agoraProperties.getAppId(), userId);
	}

	public FaceppProperties getAgoraProperties() {
		return agoraProperties;
	}

	public AgoraOkHttp3Template getAgoraOkHttp3Template() {
		return agoraOkHttp3Template;
	}
}
