package com.faceplusplus.spring.boot.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 人脸分析配置
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
@Builder
public class FaceAnalyzeOptions {

	/**
	 * 是否检测并返回人脸关键点。合法值为：
	 * 2 	检测。返回 106 个人脸关键点。
	 * 1	检测。返回 83 个人脸关键点。
	 * 0	检测
	 * 注：本参数默认值为 0
	 */
	@JsonProperty("return_landmark")
    private int returnLandmark;

	/**
	 * 是否检测并返回根据人脸特征判断出的年龄、性别、情绪等属性。合法值为：
	 * none	 不检测属性
	 *
	 *     gender
	 *     age
	 *     smiling
	 *     headpose
	 *     facequality
	 *     blur
	 *     eyestatus
	 *     emotion
	 *     beauty
	 *     mouthstatus
	 *     eyegaze
	 *     skinstatus
	 *     nose_occlusion
	 *     chin_occlusion
	 *     face_occlusion
	 *
	 * 希望检测并返回的属性。
	 *
	 * 需要将属性组成一个用逗号分隔的字符串，属性之间的顺序没有要求。
	 *
	 * 关于各属性的详细描述，参见下文“返回值”说明的 "attributes" 部分。
	 *
	 * 注：在此参数中的传入参数smiling，对应在返回值的attributes中参数名为smile。在使用时请注意。
	 *
	 * 注：本参数默认值为 none
	 */
	@JsonProperty("return_attributes")
	private String returnAttributes = "none";

	/**
	 * 颜值评分分数区间的最小值。默认为0
	 * 注：默认颜值评分分数区间为0-100.可通过beauty_score_min和beauty_score_max来调节分数区间，满足您的场景需求。
	 */
	@JsonProperty("beauty_score_min")
	private int beautyScoreMin = 0;

	/**
	 * 颜值评分分数区间的最大值。默认为100
	 */
	@JsonProperty("beauty_score_max")
	private int beautyScoreMax = 100;

}
