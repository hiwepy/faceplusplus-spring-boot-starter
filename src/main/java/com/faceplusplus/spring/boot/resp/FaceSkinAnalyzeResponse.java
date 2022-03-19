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

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude( JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class FaceSkinAnalyzeResponse extends FaceppResponse {

	/**
	 * 1、人脸矩形框，坐标数字为整数，代表像素点坐标
	 * top：矩形框左上角像素点的纵坐标
	 * left：矩形框左上角像素点的横坐标
	 * width：矩形框的宽度
	 * height：矩形框的高度
	 */
	@JsonProperty("face_rectangle")
	private FaceRectangle faceRectangle;

	/**
	 * 2、人脸皮肤分析的结果，具体包含的返回值信息见下表
	 * https://console.faceplusplus.com.cn/documents/307316314
	 */
	@JsonProperty("result")
	private JSONObject result;

	/**
	 * 3、表示影响计算结果的干扰因素.
	 * 干扰因素可能有:
	 *     imporper_headpose：头部角度不当 (判断条件roll,yaw,pitch超过[-45,45])
	 * 当有影响因素存在时返回（有影响即返回相应字段）：["improper_headpose"]
	 * 无影响因素的返回：[]
	 */
	@JsonProperty("warning")
	private JSONArray warning;

}
