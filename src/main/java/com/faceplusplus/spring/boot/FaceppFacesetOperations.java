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
import com.faceplusplus.spring.boot.req.FacesetDeleteBo;
import com.faceplusplus.spring.boot.req.FacesetUpdateBo;
import com.faceplusplus.spring.boot.resp.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1、人脸库管理相关接口
 */
public class FaceppFacesetOperations extends FaceppOperations {

	public FaceppFacesetOperations(FaceppTemplate faceppTemplate) {
		super(faceppTemplate);
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
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(faceset), Map.class))
				.build();
		FacesetCreateResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params, FacesetCreateResponse.class);
		return resp;
	}

	/**
	 * 2、人脸库管理相关接口 > 删除人脸库 API
	 * 删除一个人脸集合
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param faceset 人脸库信息
	 * @return 操作结果
	 */
	public FacesetCreateResponse deleteFaceset(FacesetDeleteBo faceset) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_DELETE.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(faceset), Map.class))
				.build();
		FacesetCreateResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FacesetCreateResponse.class);
		return resp;
	}

	/**
	 * 3、人脸库管理相关接口 > 更新人脸库信息 API
	 * 更新一个人脸集合的属性
	 * API：https://console.faceplusplus.com.cn/documents/4888391
	 * @param faceset 人脸库信息
	 * @return 操作结果
	 */
	public FacesetCreateResponse updateFaceset(FacesetUpdateBo faceset) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_UPDATE.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(faceset), Map.class))
				.build();
		FacesetCreateResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FacesetCreateResponse.class);
		return resp;
	}

	/**
	 * 2、人脸库管理相关接口 > 获取人脸库列表及信息 API
	 * 获取某一 API Key 下的 FaceSet 列表及其 faceset_token、outer_id、display_name 和 tags 等信息。
	 * 注意：2017年8月16日后，调用本接口将不会一次性返回全量的 FaceSet。单次查询最多返回 100 个 FaceSet。如需获取全量数据，需要配合使用 start 和 next 参数。请尽快修改调整您的程序。
	 * API：https://console.faceplusplus.com.cn/documents/4888397
	 * @param lastSequence 一个数字 n，表示开始返回的 faceset_token 在传入的 API Key 下的序号。
	 * 通过传入数字 n，可以控制本 API 从第 n 个 faceset_token 开始返回。返回的 faceset_token 按照创建时间排序。每次返回1000个FaceSets。 默认值为1。
	 * 注意：2017年8月16日后，每次返回的 FaceSet 数量上限从 1000 改为 100。并且您可以输入上一次请求本 API 返回的 next 值，用以获得接下来的 100 个 faceset_token。请尽快修改调整您的程序。
	 * @param tags 包含需要查询的FaceSet标签的字符串，用逗号分隔
	 * @return 操作结果
	 */
	public FacesetListResponse getFacesetList(int lastSequence, String... tags) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_LIST.getUrl();
		ImmutableMap.Builder builder = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("start", lastSequence);
		if(tags != null && tags.length > 0){
			if(tags.length == 1){
				builder.put("tags", tags[0]);
			} else {
				builder.put("tags", Stream.of(tags).collect(Collectors.joining(", ")));
			}
		}
		FacesetListResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, builder.build(),  FacesetListResponse.class);
		return resp;
	}

	/**
	 * 2、人脸库管理相关接口 > 获取人脸库信息 API
	 * 获取一个 FaceSet 的所有信息，包括此 FaceSet 的 faceset_token, outer_id, display_name 的信息，以及此 FaceSet 中存放的 face_token 数量与列表。
	 * 注意：2017年8月16日后，调用本接口将不会一次性返回全部的 face_token 列表。单次查询最多返回 100 个 face_token。如需获取全量数据，需要配合使用 start 和 next 参数。请尽快修改调整您的程序。
	 * API：https://console.faceplusplus.com.cn/documents/4888395
	 * @param facesetToken FaceSet的标识
	 * @param lastSequence 一个数字 n，表示开始返回的 faceset_token 在传入的 API Key 下的序号。
	 * 通过传入数字 n，可以控制本 API 从第 n 个 faceset_token 开始返回。返回的 faceset_token 按照创建时间排序。每次返回1000个FaceSets。 默认值为1。
	 * 注意：2017年8月16日后，每次返回的 FaceSet 数量上限从 1000 改为 100。并且您可以输入上一次请求本 API 返回的 next 值，用以获得接下来的 100 个 faceset_token。请尽快修改调整您的程序。
	 * @return 操作结果
	 */
	public FacesetDetailResponse getFacesetByToken(String facesetToken, int lastSequence) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_LIST.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("faceset_token", facesetToken)
				.put("start", lastSequence)
				.build();
		FacesetDetailResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FacesetDetailResponse.class);
		return resp;
	}

	/**
	 * 2、人脸库管理相关接口 > 获取人脸库信息 API
	 * 获取一个 FaceSet 的所有信息，包括此 FaceSet 的 faceset_token, outer_id, display_name 的信息，以及此 FaceSet 中存放的 face_token 数量与列表。
	 * 注意：2017年8月16日后，调用本接口将不会一次性返回全部的 face_token 列表。单次查询最多返回 100 个 face_token。如需获取全量数据，需要配合使用 start 和 next 参数。请尽快修改调整您的程序。
	 * API：https://console.faceplusplus.com.cn/documents/4888395
	 * @param outerId 用户提供的FaceSet标识
	 * @param lastSequence 一个数字 n，表示开始返回的 faceset_token 在传入的 API Key 下的序号。
	 * 通过传入数字 n，可以控制本 API 从第 n 个 faceset_token 开始返回。返回的 faceset_token 按照创建时间排序。每次返回1000个FaceSets。 默认值为1。
	 * 注意：2017年8月16日后，每次返回的 FaceSet 数量上限从 1000 改为 100。并且您可以输入上一次请求本 API 返回的 next 值，用以获得接下来的 100 个 faceset_token。请尽快修改调整您的程序。
	 * @return 操作结果
	 */
	public FacesetDetailResponse getFacesetByOuterId(String outerId, int lastSequence) throws IOException {
		String reqUrl = AgoraApiAddress.FACESET_DETAIL.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("outer_id", outerId)
				.put("start", lastSequence)
				.build();
		FacesetDetailResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FacesetDetailResponse.class);
		return resp;
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
	public FaceAddResponse addFaceWithToken(String facesetToken, String ... faceTokens) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("faceset_token", facesetToken)
				.put("face_tokens", faceTokens)
				.build();
		FaceAddResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FaceAddResponse.class);
		return resp;
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
	public FaceAddResponse addFaceWithOuterId(String outerId, String ... faceTokens) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ADD.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("outer_id", outerId)
				.put("face_tokens", faceTokens)
				.build();
		FaceAddResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FaceAddResponse.class);
		return resp;
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
	public FaceRemoveResponse removeFaceByToken(String facesetToken, String ... faceTokens) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_REMOVE.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("faceset_token", facesetToken)
				.put("face_tokens", faceTokens)
				.build();
		FaceRemoveResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FaceRemoveResponse.class);
		return resp;
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
	public FaceRemoveResponse removeFaceByOuterId(String outerId, String ... faceTokens) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_REMOVE.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("outer_id", outerId)
				.put("face_tokens", faceTokens)
				.build();
		FaceRemoveResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FaceRemoveResponse.class);
		return resp;
	}

	/**
	 * 1、人脸库中的人脸管理 > 自定义人脸信息 API
	 * 为检测出的某一个人脸添加标识信息，该信息会在Search接口结果中返回，用来确定用户身份。
	 * API：https://console.faceplusplus.com.cn/documents/4888387
	 * @param faceToken 人脸标识face_token
	 * @param userId 用户自定义的user_id，不超过255个字符，不能包括^@,&=*'"；建议将同一个人的多个face_token设置同样的user_id
	 * @return 操作结果
	 */
	public FaceSetUserIdResponse createFace(String faceToken, String userId) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_SET_USERID.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("user_id", userId)
				.put("face_token", faceToken)
				.build();
		FaceSetUserIdResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params, FaceSetUserIdResponse.class);
		return resp;
	}

	/**
	 * 2、人脸库中的人脸管理 > 获取人脸信息 API
	 * 通过传入在Detect API检测出的人脸标识face_token，获取一个人脸的关联信息，包括源图片ID、归属的FaceSet。
	 * API：https://console.faceplusplus.com.cn/documents/4888385
	 * @param faceToken 人脸标识face_token
	 * @return 操作结果
	 */
	public FaceDetailResponse getFaceDetail(String faceToken) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_GET_DETAIL.getUrl();
		Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("face_token", faceToken)
				.build();
		FaceDetailResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params,  FaceDetailResponse.class);
		return resp;
	}


}
