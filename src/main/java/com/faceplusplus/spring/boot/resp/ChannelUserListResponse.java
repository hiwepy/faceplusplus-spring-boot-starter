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
public class ChannelUserListResponse extends AgoraResponse {

	/**
	 * 响应体
	 */
	@JsonProperty("data")
	private ChannelUserListData data;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class ChannelUserListData {

		/**
		 * 1、指定的频道是否存在
		 *     true：存在。
		 *     false：不存在。
		 *
		 * 注意事项：当 channel_exist 的值为 false 时，不会返回其他字段
		 */
		@JsonProperty("channel_exist")
		private Boolean exist;

		/**
		 * 2、频道场景
		 *     1：通信场景
		 *     2：直播场景
		 */
		@JsonProperty("mode")
		private Integer mode;

		/**
		 * 3、频道内的用户总人数。该字段仅在通信场景 （mode 的值为 1）下返回。
		 */
		@JsonProperty("total")
		private Long total;

		/**
		 * 4、频道内所有用户的用户 ID。该字段仅在通信场景 （mode 的值为 1）下返回
		 */
		@JsonProperty("users")
		private List<String> users;

		/**
		 * 5、频道内所有主播的用户 ID。该字段仅在直播场景 （mode 的值为 2）下返回
		 */
		@JsonProperty("broadcasters")
		private List<String> broadcasters;

		/**
		 * 6、频道内观众的用户 ID。最多包含当前频道内前 10,000 名观众的用户 ID。该字段仅在直播场景 （mode 的值为 2）下返回
		 */
		@JsonProperty("audience")
		private List<String> audience;

		/**
		 * 7、频道内的观众总人数。该字段仅在直播场景 （mode 的值为 2）下返回
		 */
		@JsonProperty("audience_total")
		private Long audienceTotal;

	}

}
