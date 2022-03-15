package com.faceplusplus.spring.boot.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 人脸识别配置
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
@Builder
public class FaceDetectOptions {

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
	 * 是否检测并返回所有人脸的人脸关键点和人脸属性。如果不使用此功能，则本 API 只会对人脸面积最大的五个人脸分析人脸关键点和人脸属性。合法值为：
	 * 1 是
	 * 0 否
	 * 注：本参数默认值为 0
	 */
	@JsonProperty("calculate_all")
	private int calculateAll;

	/**
	 * 是否指定人脸框位置进行人脸检测。
	 * 如果此参数传入值为空，或不传入此参数，则不使用此功能。本 API 会自动检测图片内所有区域的所有人脸。
	 * 如果使用正式 API Key 对此参数传入符合格式要求的值，则使用此功能。需要传入一个字符串代表人脸框位置，系统会根据此坐标对框内的图像进行人脸检测，以及人脸关键点和人脸属性等后续操作。系统返回的人脸矩形框位置会与传入的 face_rectangle 完全一致。对于此人脸框之外的区域，系统不会进行人脸检测，也不会返回任何其他的人脸信息。
	 * 参数规格：四个正整数，用逗号分隔，依次代表人脸框左上角纵坐标（top），左上角横坐标（left），人脸框宽度（width），人脸框高度（height）。例如：70,80,100,100
	 */
	@JsonProperty("face_rectangle")
	private String faceRectangle;

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
