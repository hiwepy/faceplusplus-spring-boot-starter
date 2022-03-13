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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudRecordingServiceFile {
	
	/**
	 * 1、录制产生的 M3U8 文件和 MP4 文件的文件名
	 */
	@JsonProperty("fileName")
	private String fileName;

	/**
	 * 2、录制文件的类型
	 *  "audio"：纯音频文件。
	 *  "video"：纯视频文件。
	 *  "audio_and_video"：音视频文件。
	 */
	@JsonProperty("trackType")
	private String trackType;

	/**
	 * 3、用户 UID，表示录制的是哪个用户的音频流或视频流。合流录制模式下，uid 为 "0"
	 */
	@JsonProperty("uid")
	private String uid;

	/**
	 * 4、是否可以在线播放
	 * true：可以在线播放。
	 * false：无法在线播放
	 */
	@JsonProperty("mixedAllUser")
	private Boolean mixedAllUser;

	/**
	 * 5、该文件的录制开始时间，Unix 时间戳，单位为毫秒
	 */
	@JsonProperty("sliceStartTime")
	private Long sliceStartTime;

}
