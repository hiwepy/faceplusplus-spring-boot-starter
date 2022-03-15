package com.faceplusplus.spring.boot.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 人脸集合库
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class FacesetBo {

	/**
	 * 人脸集合的名字，最长256个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("display_name")
    private String displayName;

	/**
	 * 账号下全局唯一的 FaceSet 自定义标识，可以用来管理 FaceSet 对象。最长255个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("outer_id")
	private String outerId;

	/**
	 * FaceSet 自定义标签组成的字符串，用来对 FaceSet 分组。最长255个字符，多个 tag 用逗号分隔，每个 tag 不能包括字符^@,&=*'"
	 */
	@JsonProperty("tags")
	private String tags;

	/**
	 * 人脸标识 face_token，可以是一个或者多个，用逗号分隔。最多不超过5个 face_token
	 */
	@JsonProperty("face_tokens")
	private String faceTokens;

	/**
	 * 自定义用户信息，不大于16 KB，不能包括字符^@,&=*'"
	 */
	@JsonProperty("user_data")
	private String userData;

	/**
	 * 在传入 outer_id 的情况下，如果 outer_id 已经存在，是否将 face_token 加入已经存在的 FaceSet 中
	 * 0：不将 face_tokens 加入已存在的 FaceSet 中，直接返回 FACESET_EXIST 错误
	 * 1：将 face_tokens 加入已存在的 FaceSet 中
	 * 默认值为0
	 */
	@JsonProperty("force_merge")
	private int forceMerge;

}
