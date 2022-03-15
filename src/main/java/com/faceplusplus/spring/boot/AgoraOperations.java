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

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import com.faceplusplus.spring.boot.resp.AgoraResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.beans.BeanUtils;

/**
 * Tim 接口集成
 * https://cloud.tencent.com/document/product/269/42440
 */
@Slf4j
public abstract class AgoraOperations {

	protected ObjectMapper objectMapper;
	protected AgoraTemplate agoraTemplate;

	public AgoraOperations(AgoraTemplate agoraTemplate, ObjectMapper objectMapper) {
		this.agoraTemplate = agoraTemplate;
		this.objectMapper = objectMapper;
	}

	protected FaceppProperties getAgoraProperties() {
		return agoraTemplate.getAgoraProperties();
	}

	protected AgoraOkHttp3Template getAgoraOkHttp3Template(){
		return agoraTemplate.getAgoraOkHttp3Template();
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
