package com.faceplusplus.spring.boot.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 人脸集合库
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class FacesetUpdateBo {


	/**
	 * FaceSet的标识
	 */
	@JsonProperty("faceset_token")
	private String faceToken;

	/**
	 * 账号下全局唯一的 FaceSet 自定义标识，可以用来管理 FaceSet 对象。最长255个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("outer_id")
	private String outerId;

	/**
	 * 账号下全局唯一的 FaceSet 自定义标识，可以用来管理 FaceSet 对象。最长255个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("new_outer_id")
	private String newOuterId;

	/**
	 * 人脸集合的名字，最长256个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("display_name")
	private String displayName;

	/**
	 * FaceSet 自定义标签组成的字符串，用来对 FaceSet 分组。最长255个字符，多个 tag 用逗号分隔，每个 tag 不能包括字符^@,&=*'"
	 */
	@JsonProperty("tags")
	private String tags;

	/**
	 * 自定义用户信息，不大于16 KB，不能包括字符^@,&=*'"
	 */
	@JsonProperty("user_data")
	private String userData;

}
