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
public class FaceRemoveResponse extends FaceppResponse {

	/**
	 * 1、FaceSet 的标识
	 */
	@JsonProperty("faceset_token")
	private String facesetToken;

	/**
	 * 2、用户自定义的 FaceSet 标识，如果未定义则返回值为空
	 */
	@JsonProperty("outer_id")
	private String outerId;

	/**
	 * 3、成功从FaceSet中移除的face_token数量
	 */
	@JsonProperty("face_removed")
	private Integer faceRemoved;

	/**
	 * 4、操作结束后 FaceSet 中的 face_token 总数量
	 */
	@JsonProperty("face_count")
	private Integer faceCount;

	/**
	 * 5、无法从FaceSet中移除的face_token以及原因
	 * face_token：人脸标识
	 * reason：不能被移除的原因，包括 INVALID_FACE_TOKEN 人脸标识不存在
	 */
	@JsonProperty("failure_detail")
	private List<FaceAddResponse.FailureFetail> detail;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class FailureFetail {

		/**
		 * 人脸标识
		 */
		@JsonProperty("face_token")
		private String token;

		/**
		 * 不能被添加的原因，包括 INVALID_FACE_TOKEN 人脸表示不存在 ，QUOTA_EXCEEDED 已达到 FaceSet 存储上限
		 */
		@JsonProperty("reason")
		private String reason;

	}

}
