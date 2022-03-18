package com.faceplusplus.spring.boot.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaceAttributes {

    /**
     * 性别分析结果。返回值为：
     * Male	男性
     * Female 女性
     */
    @JsonProperty("gender")
    private FaceAttrValue gender;

    /**
     * 年龄分析结果。返回值为一个非负整数。
     */
    @JsonProperty("age")
    private FaceAttrValue age;

    /**
     * 笑容分析结果。返回值包含以下属性：
     *     value：值为一个 [0,100] 的浮点数，小数点后3位有效数字。数值越大表示笑程度高。
     *     threshold：代表笑容的阈值，超过该阈值认为有笑容。
     */
    @JsonProperty("smile")
    private FaceAttrSmile smile;

    /**
     * 人脸姿势分析结果。返回值包含以下属性，每个属性的值为一个 [-180, 180] 的浮点数，小数点后 6 位有效数字。单位为角度。
     * pitch_angle：抬头
     * roll_angle：旋转（平面旋转）
     * yaw_angle：摇头
     */
    @JsonProperty("headpose")
    private FaceAttrHeadpose headpose;

    /**
     * 人脸模糊分析结果。返回值包含以下属性：
     *     blurness：人脸模糊分析结果。
     * 每个属性都包含以下字段：
     *     value 的值为是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。值越大，越模糊。
     *     threshold 表示人脸模糊度是否影响辨识的阈值。
     */
    @JsonProperty("blur")
    private FaceAttrBlur blur;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FaceAttrValue {

        @JsonProperty("value")
        private String value;

    }


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FaceAttrSmile {

        /**
         * 值为一个 [0,100] 的浮点数，小数点后3位有效数字。数值越大表示笑程度高
         */
        @JsonProperty("value")
        private Float value;

        /**
         * 代表笑容的阈值，超过该阈值认为有笑容
         */
        @JsonProperty("threshold")
        private Float threshold;

    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FaceAttrHeadpose {

        /**
         * 摇头角度
         */
        @JsonProperty("yaw_angle")
        private Float yaw;

        /**
         * 抬头角度
         */
        @JsonProperty("pitch_angle")
        private Float pitch;

        /**
         * 旋转（平面旋转）角度
         */
        @JsonProperty("roll_angle")
        private Float roll;

    }


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FaceAttrBlur {

        /**
         * 摇头角度
         */
        @JsonProperty("yaw_angle")
        private Float yaw;

        /**
         * 抬头角度
         */
        @JsonProperty("pitch_angle")
        private Float pitch;

        /**
         * 旋转（平面旋转）角度
         */
        @JsonProperty("roll_angle")
        private Float roll;

    }

}
