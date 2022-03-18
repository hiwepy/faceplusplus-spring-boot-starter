package com.faceplusplus.spring.boot.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaceRectangle {

    /**
     * 矩形框左上角像素点的纵坐标
     */
    @JsonProperty("top")
    private Integer top;

    /**
     * 矩形框左上角像素点的横坐标
     */
    @JsonProperty("left")
    private Integer left;

    /**
     * 矩形框的宽度
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * 矩形框的高度
     */
    @JsonProperty("height")
    private Integer height;

}
