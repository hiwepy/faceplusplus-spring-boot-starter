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
package com.faceplusplus.spring.boot.resp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude( JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class FaceCompareResponse extends FaceppResponse {

	/**
	 * 1、比对结果置信度，范围 [0,100]，小数点后3位有效数字，数字越大表示两个人脸越可能是同一个人。
	 * 注：如果传入图片但图片中未检测到人脸，则无法进行比对，本字段不返回。
	 */
	@JsonProperty("confidence")
	private Float confidence;

	/**
	 * 2、一组用于参考的置信度阈值，包含以下三个字段。每个字段的值为一个 [0,100] 的浮点数，小数点后 3 位有效数字。
	 *     1e-3：误识率为千分之一的置信度阈值；
	 *     1e-4：误识率为万分之一的置信度阈值；
	 *     1e-5：误识率为十万分之一的置信度阈值；
	 * 如果置信值低于“千分之一”阈值则不建议认为是同一个人；如果置信值超过“十万分之一”阈值，则是同一个人的几率非常高。
	 * 请注意：阈值不是静态的，每次比对返回的阈值不保证相同，所以没有持久化保存阈值的必要，更不要将当前调用返回的 confidence 与之前调用返回的阈值比较。
	 * 注：如果传入图片但图片中未检测到人脸，则无法进行比对，本字段不返回。
	 */
	@JsonProperty("thresholds")
	private JSONObject thresholds;

	/**
	 * 3、通过 image_url1、image_file1 或 image_base64_1 传入的图片在系统中的标识。
	 * 注：如果未传入图片，本字段不返回。
	 */
	@JsonProperty("image_id1")
	private String imageId1;

	/**
	 * 4、通过 image_url2、image_file2 或 image_base64_2 传入的图片在系统中的标识。
	 * 注：如果未传入图片，本字段不返回。
	 */
	@JsonProperty("image_id2")
	private String imageId2;

	/**
	 * 5、通过 image_url1、image_file1 或 image_base64_1 传入的图片中检测出的人脸数组，采用数组中的第一个人脸进行人脸比对。
	 * 注：如果未传入图片，本字段不返回。如果没有检测出人脸则为空数组
	 */
	@JsonProperty("faces1")
	private JSONArray faces1;

	/**
	 * 6、通过 image_url2、image_file2 或 image_base64_2 传入的图片中检测出的人脸数组，采用数组中的第一个人脸进行人脸比对。
	 * 注：如果未传入图片，本字段不返回。如果没有检测出人脸则为空数组
	 */
	@JsonProperty("faces2")
	private JSONArray faces2;

}
