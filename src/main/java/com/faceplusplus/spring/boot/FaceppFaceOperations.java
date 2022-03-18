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

import com.faceplusplus.spring.boot.req.FaceAnalyzeOptions;
import com.faceplusplus.spring.boot.req.FaceDetectOptions;
import com.faceplusplus.spring.boot.req.FaceSearchOptions;
import com.faceplusplus.spring.boot.resp.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 1、
 */
public class FaceppFaceOperations extends FaceppOperations {

	public FaceppFaceOperations(FaceppTemplate faceppTemplate) {
		super(faceppTemplate);
	}

	/**
	 * 1、人脸识别 > 人脸检测 API
	 * 传入图片进行人脸检测和人脸分析。
	 * 可以检测图片内的所有人脸，对于每个检测出的人脸，会给出其唯一标识 face_token，可用于后续的人脸分析、人脸比对等操作。对于正式 API Key，支持指定图片的某一区域进行人脸检测。
	 * 本 API 支持对检测到的人脸直接进行分析，获得人脸的关键点和各类属性信息。对于试用 API Key，最多只对人脸框面积最大的 5 个人脸进行分析，其他检测到的人脸可以使用 Face Analyze API 进行分析。对于正式 API Key，支持分析所有检测到的人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888373
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
	 * API：https://console.faceplusplus.com.cn/documents/4888373
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
	 * 3、人脸识别 > 人脸检测 API
	 * 传入图片进行人脸检测和人脸分析。
	 * 可以检测图片内的所有人脸，对于每个检测出的人脸，会给出其唯一标识 face_token，可用于后续的人脸分析、人脸比对等操作。对于正式 API Key，支持指定图片的某一区域进行人脸检测。
	 * 本 API 支持对检测到的人脸直接进行分析，获得人脸的关键点和各类属性信息。对于试用 API Key，最多只对人脸框面积最大的 5 个人脸进行分析，其他检测到的人脸可以使用 Face Analyze API 进行分析。对于正式 API Key，支持分析所有检测到的人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888373
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
	 * 4、人脸识别 > 人脸分析 API
	 * 传入在人脸检测 API 检测出的人脸标识 face_token，分析得出人脸关键点，人脸属性信息。一次调用最多支持分析 5 个人脸
	 * API：https://console.faceplusplus.com.cn/documents/4888383
	 * @param faceTokens 一个字符串，由一个或多个人脸标识组成，用逗号分隔。最多支持 5 个 face_token
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceAnalyzeResponse analyze(String[] faceTokens, FaceAnalyzeOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_ANALYZE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("face_tokens", faceTokens)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceAnalyzeResponse resp = getFaceppOkHttp3Template().post(reqUrl, null, params, FaceAnalyzeResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸比对 API
	 * 将两个人脸进行比对，来判断是否为同一个人，返回比对结果置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行比对。使用图片时会自动选取图片中检测到人脸尺寸最大的一个人脸
	 * API：https://console.faceplusplus.com.cn/documents/4887586
	 * @param imageUrl1 第一张图片的 URL
	 * @param imageUrl2 第二张图片的 URL
	 * @return 操作结果
	 */
	public FaceCompareResponse compareUrl(String imageUrl1, String imageUrl2) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_COMPARE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_url1", imageUrl1)
				.put("image_url2", imageUrl2)
				.build();
		FaceCompareResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceCompareResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸比对 API
	 * 将两个人脸进行比对，来判断是否为同一个人，返回比对结果置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行比对。使用图片时会自动选取图片中检测到人脸尺寸最大的一个人脸
	 * API：https://console.faceplusplus.com.cn/documents/4887586
	 * @param faceToken1 第一个人脸标识 face_token，优先使用该参数
	 * @param faceToken2 第二个人脸标识 face_token，优先使用该参数
	 * @return 操作结果
	 */
	public FaceCompareResponse compareToken(String faceToken1, String faceToken2) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_COMPARE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("face_token1", faceToken1)
				.put("face_token2", faceToken2)
				.build();
		FaceCompareResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceCompareResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸比对 API
	 * 将两个人脸进行比对，来判断是否为同一个人，返回比对结果置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行比对。使用图片时会自动选取图片中检测到人脸尺寸最大的一个人脸
	 * API：https://console.faceplusplus.com.cn/documents/4887586
	 * @param imageBase64_1 base64 编码的二进制图片数据；如果同时传入了 image_url1、image_file1 和 image_base64_1 参数，本 API 使用顺序为image_file1 优先，image_url1 最低
	 * @param imageBase64_2 base64 编码的二进制图片数据；如果同时传入了 image_url2、image_file2 和 image_base64_2 参数，本API 使用顺序为 image_file2优先，image_url2 最低。
	 * @return 操作结果
	 */
	public FaceCompareResponse compareBase64(String imageBase64_1, String imageBase64_2) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_DETECT.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_base64_1", imageBase64_1)
				.put("image_base64_2", imageBase64_2)
				.build();
		FaceCompareResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceCompareResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸比对 API
	 * 将两个人脸进行比对，来判断是否为同一个人，返回比对结果置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行比对。使用图片时会自动选取图片中检测到人脸尺寸最大的一个人脸
	 * API：https://console.faceplusplus.com.cn/documents/4887586
	 * @param imageFile1 第一张图片，二进制文件，需要用 post multipart/form-data 的方式上传
	 * @param imageFile2 第二张图片，二进制文件，需要用 post multipart/form-data 的方式上传
	 * @return 操作结果
	 */
	public FaceCompareResponse compareFile(File imageFile1, File imageFile2) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_COMPARE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_file1", imageFile1)
				.put("image_file2", imageFile2)
				.build();
		FaceCompareResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceCompareResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸搜索 API
	 * 在一个已有的 FaceSet 中找出与目标人脸最相似的一张或多张人脸，返回置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行人脸搜索。使用图片进行搜索时会选取图片中检测到人脸尺寸最大的一个人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888381
	 * @param imageUrl 目标人脸所在的图片的 URL
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceSearchResponse searchUrl(String imageUrl, FaceSearchOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_COMPARE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_url", imageUrl)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceSearchResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceSearchResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸搜索 API
	 * 在一个已有的 FaceSet 中找出与目标人脸最相似的一张或多张人脸，返回置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行人脸搜索。使用图片进行搜索时会选取图片中检测到人脸尺寸最大的一个人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888381
	 * @param faceToken 进行搜索的目标人脸的 face_token，优先使用该参数
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceSearchResponse searchToken(String faceToken, FaceSearchOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_COMPARE.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("face_token", faceToken)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceSearchResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceSearchResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸搜索 API
	 * 在一个已有的 FaceSet 中找出与目标人脸最相似的一张或多张人脸，返回置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行人脸搜索。使用图片进行搜索时会选取图片中检测到人脸尺寸最大的一个人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888381
	 * @param imageBase64 base64 编码的二进制图片数据；如果同时传入了 image_url、image_file 和 image_base64 参数，本 API 使用顺序为 image_file 优先，image_url 最低。
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceSearchResponse searchBase64(String imageBase64, FaceSearchOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_DETECT.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_base64", imageBase64)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceSearchResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceSearchResponse.class);
		return resp;
	}

	/**
	 * 5、人脸识别 > 人脸搜索 API
	 * 在一个已有的 FaceSet 中找出与目标人脸最相似的一张或多张人脸，返回置信度和不同误识率下的阈值。
	 * 支持传入图片或 face_token 进行人脸搜索。使用图片进行搜索时会选取图片中检测到人脸尺寸最大的一个人脸。
	 * API：https://console.faceplusplus.com.cn/documents/4888381
	 * @param imageFile 目标人脸所在的图片，二进制文件，需要用 post multipart/form-data 的方式上传
	 * @param options 可选参数
	 * @return 操作结果
	 */
	public FaceSearchResponse searchFile(File imageFile, FaceSearchOptions options) throws IOException {
		String reqUrl = AgoraApiAddress.FACE_SEARCH.getUrl();
		Map params = new ImmutableMap.Builder<String, Object>()
				.put("api_key", getFaceppProperties().getAppId())
				.put("api_secret", getFaceppProperties().getAppCertificate())
				.put("image_file", imageFile)
				.putAll(getObjectMapper().readValue(getObjectMapper().writeValueAsString(options), Map.class))
				.build();
		FaceSearchResponse resp = getFaceppOkHttp3Template().doPartRequest(reqUrl, params, FaceSearchResponse.class);
		return resp;
	}


}
