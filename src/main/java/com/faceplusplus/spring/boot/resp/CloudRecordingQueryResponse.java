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

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude( JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class CloudRecordingQueryResponse extends FaceppResponse {

	/**
	 * 1、录制 ID。成功开始云端录制后，你会得到一个 sid （录制 ID)。该 ID 是一次录制周期的唯一标识
	 */
	@JsonProperty("sid")
	private String sid;

	/**
	 * 2、云端录制使用的 resource ID
	 */
	@JsonProperty("resourceId")
	private String resourceId;

	/**
	 * 3、服务器返回的具体信息。该字段中的子元素与你在 start 请求中的设置有关
	 */
	@JsonProperty("serverResponse")
	private CloudRecordingServiceResponse serverResponse;


}
