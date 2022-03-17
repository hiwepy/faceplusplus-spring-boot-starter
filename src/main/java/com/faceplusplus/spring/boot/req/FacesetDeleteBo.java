package com.faceplusplus.spring.boot.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 人脸集合库
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class FacesetDeleteBo {

	/**
	 * 账号下全局唯一的 FaceSet 自定义标识，可以用来管理 FaceSet 对象。最长255个字符，不能包括字符^@,&=*'"
	 */
	@JsonProperty("outer_id")
	private String outerId;

	/**
	 * 人脸标识 face_token，可以是一个或者多个，用逗号分隔。最多不超过5个 face_token
	 */
	@JsonProperty("face_tokens")
	private String faceTokens;

	/**
	 * 删除时是否检查FaceSet中是否存在face_token，默认值为1
	 * 0：不检查
	 * 1：检查
	 * 如果设置为1，当FaceSet中存在face_token则不能删除
	 */
	@JsonProperty("check_empty")
	private int checkEmpty = 1;

}
