package com.faceplusplus.spring.boot.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaceSetFetail {

    /**
     * FaceSet 的标识
     */
    @JsonProperty("faceset_token")
    private String facesetToken;

    /**
     * FaceSet 自定义标签组成的字符串，用来对 FaceSet 分组。最长255个字符，多个 tag 用逗号分隔，每个 tag 不能包括字符^@,&=*'"
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * 用户自定义的 FaceSet 标识，如果未定义则返回值为空
     */
    @JsonProperty("outer_id")
    private String outerId;

}
