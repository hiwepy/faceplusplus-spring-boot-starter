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
public class FacesetListResponse extends FaceppResponse {

	/**
	 * 1、用于进行下一次请求。返回值表示排在此次返回的所有 faceset_token 之后的下一个 faceset_token 的序号。
	 * 如果返回此字段，则说明未返回完此 API Key 下的所有 faceset_token。可以将此字段的返回值，在下一次调用时传入 start 字段中，获取接下来的 faceset_token。
	 * 如果没有返回该字段，则说明已经返回此 API Key 下的所有 faceset_token。
	 */
	@JsonProperty("next")
	private String next;

	/**
	 * 2、该 API Key 下的 FaceSet 信息。包含的元素见下文。
	 * 注：如果该 API Key 下没有 FaceSet，则返回空数组。
	 */
	@JsonProperty("facesets")
	private List<FacesetFetail> facesets;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class FacesetFetail {

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
		 * 3、人脸集合的名字，最长256个字符，不能包括字符^@,&=*'"
		 */
		@JsonProperty("display_name")
		private String displayName;

		/**
		 * 4、FaceSet 自定义标签组成的字符串，用来对 FaceSet 分组。最长255个字符，多个 tag 用逗号分隔，每个 tag 不能包括字符^@,&=*'"
		 */
		@JsonProperty("tags")
		private String tags;

	}

}
