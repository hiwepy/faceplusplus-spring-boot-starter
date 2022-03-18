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
public class FaceDetailResponse extends FaceppResponse {

	/**
	 * 1、face_token所属图片在系统中的标识
	 */
	@JsonProperty("image_id")
	private String imageId;

	/**
	 * 2、人脸token
	 */
	@JsonProperty("face_token")
	private String faceToken;

	/**
	 * 3、用户自定义的标识信息
	 */
	@JsonProperty("user_id")
	private String userId;

	/**
	 * 3、人脸矩形框，坐标数字为整数，代表像素点坐标
	 * top：矩形框左上角像素点的纵坐标
	 * left：矩形框左上角像素点的横坐标
	 * width：矩形框的宽度
	 * height：矩形框的高度
	 */
	@JsonProperty("face_rectangle")
	private FaceRectangle faceRectangle;

	/**
	 * 5、包含该face_token的FaceSet数组
	 * faceset_token：FaceSet的标识
	 * outer_id：用户自定义的FaceSet标识，如果没有设置则值为空。
	 * tags: 用户自定义的FaceSet标签，如果没有设置则值为空。
	 */
	@JsonProperty("facesets")
	private List<FaceSetFetail> facesets;


}
