package com.faceplusplus.spring.boot.req;

import com.faceplusplus.spring.boot.AgoraApiAddress;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.function.Function;

/**
 * 皮肤分析配置
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
@Builder
public class SkinAnalyzeOptions {


	/**
	 * 可通过该参数控制是否对传入图片中的人脸质量进行限制，可传入0和1：
	 *
	 *     1：进行人脸质量控制，若人脸质量不通过会返回INVALID_FACE_SIZE或INVALID_FACE_QUALITY。
	 *     0：不进行人脸质量控制，只要能够检测到人脸则返回测肤结果。
	 *
	 * 该参数默认值为0。
	 * 注意：若不进行人脸控制，则不能保证返回结果的准确性，请客户尽量保证传入图片的人脸质量（见：上方”图片要求“）。
	 */
	@JsonProperty("face_quality_control")
	private int faceQualityControl;

	/**
	 * 可通过该参数控制接口是否返回痘痘、闭口、色斑和痣的区域置信度，可传入0和1：
	 *
	 *     1：返回区域置信度。
	 *     0：不返回区域置信度。
	 *
	 * 该参数默认为0。
	 */
	@JsonProperty("return_rect_confidence")
	private int returnRectConfidence;

	/**
	 * 输入一个逗号分隔的字符串，内涵需要返回的皮肤问题检测图谱图片类型，目前支持的元素包含：
	 *
	 * -------元素--------------------描述---------------------------返回图片--------------
	 * | red_area	| 红区图，可展示面部敏感、炎症引起的泛红区域 | 	白底红区图，红色深浅表征敏感程度
	 * | brown_area	| 褐色区域图，可展示面部色素沉着区域	| 白底棕区图，棕色深浅表征色沉程度
	 * | texture_enhanced_pores	| 面部毛孔粗大区域图	| 透明底PNG，标注毛孔粗大区域，图片大小与原图相同，可叠图查看
	 * | texture_enhanced_blackheads| 	面部黑头区域图	| 透明底PNG，标注黑头区域，图片大小与原图相同，可叠图查看
	 * | texture_enhanced_oily_area	| 面部油光区域图	| 透明底PNG，标注面部油光区域，图片大小与原图相同，可叠图查看
	 * | texture_enhanced_lines	| 面部纹理图，标出面部比较明显的深纹、浅纹	| 透明底PNG，标注面部皱纹，图片大小与原图相同，可叠图查看
	 *
	 * 元素会在将来更新拓展。
	 * 输入样例："red_area, brown_area"
	 * 若传入相应元素参数，接口会返回一张原图大小的图片，您可以后续与原图进行叠图操作查看效果。
	 * 该输入默认为空字符串。
	 */
	@JsonProperty("return_maps")
	private String returnMaps;

}
