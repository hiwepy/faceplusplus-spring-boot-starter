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

import com.faceplusplus.spring.boot.resp.FaceAddResponse;
import com.faceplusplus.spring.boot.resp.FaceRemoveResponse;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

public class FaceppFacesetAsyncOperations extends FaceppFacesetOperations {

	public FaceppFacesetAsyncOperations(FaceppTemplate faceppTemplate) {
		super(faceppTemplate);
	}

	/**
	 * 3、人脸库管理相关接口 > 添加人脸 API
	 * 为一个已经创建的 FaceSet 添加人脸标识 face_token。一个 FaceSet 最多存储1,000个 face_token。
	 * 注意：2017年8月16日后，一个 FaceSet 能够存储的 face_token 数量将从 1000 提升至 10000。
	 * API：https://console.faceplusplus.com.cn/documents/4888389
	 * @param facesetToken FaceSet的标识
	 * @param faceTokens 人脸标识 face_token 组成的字符串，可以是一个或者多个，用逗号分隔。最多不超过5个face_token
	 * @return 操作结果
	 */
	public void asyncAddFaceWithToken(String facesetToken, String[] faceTokens, Consumer<FaceAddResponse> consumer) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("faceset_token", facesetToken)
				.put("face_tokens", faceTokens)
				.build();
		getFaceppOkHttp3Template().doAsyncRequest(reqUrl, FaceppOkHttp3Template.HttpMethod.POST, consumer, FaceAddResponse.class);
	}

	/**
	 * 3、人脸库管理相关接口 > 添加人脸 API
	 * 为一个已经创建的 FaceSet 添加人脸标识 face_token。一个 FaceSet 最多存储1,000个 face_token。
	 * 注意：2017年8月16日后，一个 FaceSet 能够存储的 face_token 数量将从 1000 提升至 10000。
	 * API：https://console.faceplusplus.com.cn/documents/4888389
	 * @param outerId 用户提供的FaceSet标识
	 * @param faceTokens 人脸标识 face_token 组成的字符串，可以是一个或者多个，用逗号分隔。最多不超过5个face_token
	 * @return 操作结果
	 */
	public void asyncAddFaceWithOuterId(String outerId, String[] faceTokens, Consumer<FaceAddResponse> consumer) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("outer_id", outerId)
				.put("face_tokens", faceTokens)
				.build();
		getFaceppOkHttp3Template().doAsyncRequest(reqUrl, FaceppOkHttp3Template.HttpMethod.POST, consumer, FaceAddResponse.class);
	}

	/**
	 * 3、人脸库管理相关接口 > 删除人脸 API
	 * 移除一个FaceSet中的某些或者全部face_token
	 * API：https://console.faceplusplus.com.cn/documents/4888399
	 * @param facesetToken FaceSet的标识
	 * @param faceTokens 需要移除的人脸标识字符串，可以是一个或者多个face_token组成，用逗号分隔。最多不能超过1,000个face_token
	 * 注：face_tokens字符串传入“RemoveAllFaceTokens”则会移除FaceSet内所有的face_token
	 * @return 操作结果
	 */
	public void asyncRemoveFaceByToken(String facesetToken, String[] faceTokens, Consumer<FaceRemoveResponse> consumer) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("faceset_token", facesetToken)
				.put("face_tokens", faceTokens)
				.build();
		getFaceppOkHttp3Template().doAsyncRequest(reqUrl, FaceppOkHttp3Template.HttpMethod.POST, consumer, FaceRemoveResponse.class);
	}

	/**
	 * 3、人脸库管理相关接口 > 删除人脸 API
	 * 移除一个FaceSet中的某些或者全部face_token
	 * API：https://console.faceplusplus.com.cn/documents/4888399
	 * @param outerId 用户提供的FaceSet标识
	 * @param faceTokens 需要移除的人脸标识字符串，可以是一个或者多个face_token组成，用逗号分隔。最多不能超过1,000个face_token
	 * 注：face_tokens字符串传入“RemoveAllFaceTokens”则会移除FaceSet内所有的face_token
	 * @return 操作结果
	 */
	public void asyncRemoveFaceByOuterId(String outerId, String[] faceTokens, Consumer<FaceRemoveResponse> consumer) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("outer_id", outerId)
				.put("face_tokens", faceTokens)
				.build();
		getFaceppOkHttp3Template().doAsyncRequest(reqUrl, FaceppOkHttp3Template.HttpMethod.POST, consumer, FaceRemoveResponse.class);
	}


}
