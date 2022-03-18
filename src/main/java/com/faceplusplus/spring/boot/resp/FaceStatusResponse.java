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
public class FaceStatusResponse extends FaceppResponse {

	/**
	 * 1、标示当前异步请求的唯一task标识，之后调用任务状态查询接口时，使用当前值作为参数，如果发生错误，此字段不返回。
	 */
	@JsonProperty("task_id")
	private String taskId;

	/**
	 * 2、1: 标示当前异步任务已经完成
	 */
	@JsonProperty("status")
	private Integer status;

	/**
	 * 3、FaceSet 的标识
	 */
	@JsonProperty("faceset_token")
	private String facesetToken;

	/**
	 * 4、用户自定义的 FaceSet 标识，如果未定义则返回值为空
	 */
	@JsonProperty("outer_id")
	private String outerId;

	/**
	 * 5、成功加入 FaceSet 的 face_token 数量（如果当前任务类型为添加人脸，返回此字段）
	 */
	@JsonProperty("face_added")
	private Integer faceAdded;

	/**
	 * 6、成功从FaceSet中移除的face_token数量（如果当前任务类型为删除人脸，返回此字段）
	 */
	@JsonProperty("face_removed")
	private Integer faceRemoved;

	/**
	 * 7、操作结束后 FaceSet 中的 face_token 总数量
	 */
	@JsonProperty("face_count")
	private Integer faceCount;

	/**
	 * 8、无法被加入/删除FaceSet的face_token以及原因
	 * face_token：人脸标识不存在
	 * reason：不能被添加的原因，包括 INVALID_FACE_TOKEN 人脸标识不存在 ，QUOTA_EXCEEDED 已达到FaceSet存储上限
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
