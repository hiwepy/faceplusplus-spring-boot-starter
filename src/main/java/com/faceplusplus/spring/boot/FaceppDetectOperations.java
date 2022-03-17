/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.faceplusplus.spring.boot;

import com.faceplusplus.spring.boot.req.FaceDetectOptions;
import com.faceplusplus.spring.boot.resp.ChannelUserListResponse;
import com.faceplusplus.spring.boot.resp.FaceDetectResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 1、人脸库管理相关接口
 * https://docs.agora.io/cn/Video/channel_management_overview?platform=RESTful
 */
public class FaceppDetectOperations extends FaceppOperations {

	public FaceppDetectOperations(FaceppTemplate faceppTemplate) {
		super(faceppTemplate);
	}

	/**
	 * 1、人脸识别 > 人脸检测 API
	 * 传入图片进行人脸检测和人脸分析。
	 * 可以检测图片内的所有人脸，对于每个检测出的人脸，会给出其唯一标识 face_token，可用于后续的人脸分析、人脸比对等操作。对于正式 API Key，支持指定图片的某一区域进行人脸检测。
	 * 本 API 支持对检测到的人脸直接进行分析，获得人脸的关键点和各类属性信息。对于试用 API Key，最多只对人脸框面积最大的 5 个人脸进行分析，其他检测到的人脸可以使用 Face Analyze API 进行分析。对于正式 API Key，支持分析所有检测到的人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param imageUrl 图片的 URL。注：在下载图片时可能由于网络等原因导致下载图片时间过长，建议使用 image_file 或 image_base64 参数直接上传图片
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceDetectResponse detectUrl(String imageUrl, FaceDetectOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_DETECT.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_url", imageUrl)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceDetectResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params, FaceDetectResponse.class);
		return resp;
	}

	/**
	 * 2、人脸识别 > 人脸检测 API
	 * 传入图片进行人脸检测和人脸分析。
	 * 可以检测图片内的所有人脸，对于每个检测出的人脸，会给出其唯一标识 face_token，可用于后续的人脸分析、人脸比对等操作。对于正式 API Key，支持指定图片的某一区域进行人脸检测。
	 * 本 API 支持对检测到的人脸直接进行分析，获得人脸的关键点和各类属性信息。对于试用 API Key，最多只对人脸框面积最大的 5 个人脸进行分析，其他检测到的人脸可以使用 Face Analyze API 进行分析。对于正式 API Key，支持分析所有检测到的人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param imageBase64 图片的 URL。注：在下载图片时可能由于网络等原因导致下载图片时间过长，建议使用 image_file 或 image_base64 参数直接上传图片
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceDetectResponse detectBase64(String imageBase64, FaceDetectOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_DETECT.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_base64", imageBase64)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceDetectResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params, FaceDetectResponse.class);
		return resp;
	}

	/**
	 * 2、人脸识别 > 人脸检测 API
	 * 传入图片进行人脸检测和人脸分析。
	 * 可以检测图片内的所有人脸，对于每个检测出的人脸，会给出其唯一标识 face_token，可用于后续的人脸分析、人脸比对等操作。对于正式 API Key，支持指定图片的某一区域进行人脸检测。
	 * 本 API 支持对检测到的人脸直接进行分析，获得人脸的关键点和各类属性信息。对于试用 API Key，最多只对人脸框面积最大的 5 个人脸进行分析，其他检测到的人脸可以使用 Face Analyze API 进行分析。对于正式 API Key，支持分析所有检测到的人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param imageFile 图片的 URL。注：在下载图片时可能由于网络等原因导致下载图片时间过长，建议使用 image_file 或 image_base64 参数直接上传图片
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceDetectResponse detectFile(File imageFile, FaceDetectOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_DETECT.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_file", imageFile)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceDetectResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceDetectResponse.class);
		return resp;
	}

	/**
	 * 2、查询在线频道信息 > 查询指定频道内的用户列表
	 * 在不同频道场景下，该方法返回的列表具体如下：
	 *     通信场景下，频道内的用户列表。
	 *     直播场景下，频道内的主播列表和观众列表。
	 * API：https://docs.agora.io/cn/Video/rtc_channel_management_restfulapi?platform=RESTful#%E6%9F%A5%E8%AF%A2%E7%94%A8%E6%88%B7%E5%88%97%E8%A1%A8
	 * @param channelName 频道名称
	 * @return 操作结果
	 */
	public ChannelUserListResponse getChannelUserList(String channelName) throws IOException {
		String reqUrl = AgoraApiAddress.CHANNEL_USER_LIST.getUrl(getFaceppProperties().getAppId(), channelName);
		ChannelUserListResponse resp = getFaceppOkHttp3Template().get(reqUrl, ChannelUserListResponse.class);
		return resp;
	}

	/**
	 * 3、查询在线频道信息 > 查询项目的频道列表
	 * 该方法按页查询指定项目下的频道列表。你可以在请求路径中指定要查询的页面和每页显示的频道数量。请求成功后，会根据你指定的 page_size 返回指定页面的频道列表。
	 * API：https://docs.agora.io/cn/Video/rtc_channel_management_restfulapi?platform=RESTful#%E6%9F%A5%E8%AF%A2%E9%A1%B9%E7%9B%AE%E7%9A%84%E9%A2%91%E9%81%93%E5%88%97%E8%A1%A8
	 * @param pageNo 你想要查询的页面，默认值为 0，即第一页。
	 * 注意事项：page_no 的取值不能大于（频道总数/每页显示的频道数 - 1）。否则，指定的页面将不包含任何频道列表。
	 * @param pageSize 每个页面显示的频道数量，取值范围为 [1,500]，默认值为 100。
	 * @return 操作结果
	 */
	public ChannelUserListResponse getChannelList(Integer pageNo, Integer pageSize) throws IOException {
		String reqUrl = AgoraApiAddress.CHANNEL_LIST.getUrl(getFaceppProperties().getAppId());
		ChannelUserListResponse resp = getFaceppOkHttp3Template().get(reqUrl, ChannelUserListResponse.class);
		return resp;
	}

}
