package com.babyvote.common.constant;

/**
 * 	研学活动审核状态
 */
public interface CommonAuditStatus {
	/**
	 * 未提交
	 */
	public static final String NOTSUBMITTED_STATUS_1 = "1";

	/**
	 * 待学生科审批
	 */
	public static final String STAY_STUDENT_SECTION_APPROVAL_STATUS_2 = "2";
	/**
	 * 学生科审核拒绝
	 */
	public static final String STAY_STUDENT_SECTION_REFUSE_STATUS_3 = "3";
	/**
	 * 待局领导审批
	 */
	public static final String STAY_BUREAU_LEADERSHIP_APPROVAL_STATUS_4 = "4";

	/**
	 * 局领导审核拒绝
	 */
	public static final String STAY_BUREAU_LEADERSHIP_REFUSE_STATUS_5 = "5";

	/**
	 * 审批已通过'
	 */
	public static final String APPROVAL_PASSED_STATUS_6 = "6";
}
