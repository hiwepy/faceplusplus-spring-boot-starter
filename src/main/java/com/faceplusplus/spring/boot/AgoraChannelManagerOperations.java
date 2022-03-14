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

import com.faceplusplus.spring.boot.req.FacesetBo;
import com.faceplusplus.spring.boot.resp.ChannelUserListResponse;
import com.faceplusplus.spring.boot.resp.FacesetCreateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Map;

/**
 * 1、人脸库管理相关接口
 * https://docs.agora.io/cn/Video/channel_management_overview?platform=RESTful
 */
public class AgoraChannelManagerOperations extends AgoraOperations {

	public AgoraChannelManagerOperations(AgoraTemplate agoraTemplate, ObjectMapper objectMapper) {
		super(agoraTemplate, objectMapper);
	}

	/**
	 * 1、人脸库管理相关接口 > 创建人脸库 API
	 * 创建一个人脸的集合 FaceSet，用于存储人脸标识 face_token。一个 FaceSet 能够存储10000个 face_token。
	 * 试用API Key可以创建1000个FaceSet，正式API Key可以创建10000个FaceSet。
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param faceset 人脸库信息
	 * @return 操作结果
	 */
	public FacesetCreateResponse createFaceset(FacesetBo faceset) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_CREATE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getAgoraProperties().getAppId())
				.put("api_secret", getAgoraProperties().getAppCertificate())
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(faceset), Map.class))
				.build();
		FacesetCreateResponse resp = super.post(AgoraApiAddress.FACESET_CREATE, reqUrl, params, null, FacesetCreateResponse.class);
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
		String reqUrl = AgoraApiAddress.CHANNEL_USER_LIST.getUrl(getAgoraProperties().getAppId(), channelName);
		ChannelUserListResponse resp = super.get(AgoraApiAddress.CHANNEL_USER_LIST, reqUrl, ChannelUserListResponse.class);
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
		String reqUrl = AgoraApiAddress.CHANNEL_LIST.getUrl(getAgoraProperties().getAppId());
		ChannelUserListResponse resp = super.get(AgoraApiAddress.CHANNEL_LIST, reqUrl, ChannelUserListResponse.class);
		return resp;
	}

}
