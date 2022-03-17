package com.faceplusplus.spring.boot.resp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 响应结果
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class FaceppResponse {

	/**
	 * 响应状态码，200表示成功，非200表示失败
	 */
	@JsonProperty("code")
	private int code;

	/**
	 * 整个请求所花费的时间，单位为毫秒。除非发生404（API_NOT_FOUND )或403 （AUTHORIZATION_ERROR）错误，此字段必定返回
	 */
	@JsonProperty("time_used")
	private int timeUsed;

	/**
	 * 用于区分每一次请求的唯一的字符串。除非发生404（API_NOT_FOUND ) 或403 （AUTHORIZATION_ERROR）错误，此字段必定返回
	 */
	@JsonProperty("request_id")
	private String requestId;

	/**
	 * 当请求失败时才会返回此字符串，具体返回内容见后续错误信息章节。否则此字段不存在
	 */
	@JsonProperty("error_message")
	private String errorMsg;

	public boolean isSuccess() {
		return code == 200;
	}

}
