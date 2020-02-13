package com.babyvote.common.constants;

import com.ketai.common.model.response.ResultCode;
import lombok.Getter;

@Getter
public enum ResultCodeEnum implements ResultCode {
    SUCCESS(true, 20000, "成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),
    USERLOGIN_INVALID_ERROR(false, 21007, "登录信息过期，请重新登录"),
    USERUNLOGIN_ERROR(false, 21008, "用户未登录，请重新登录"),
    VIDEO_UPLOAD_TOMCAT_ERROR(false, 21009, "视频上传云服务器失败!"),
    VIDEO_UPLOAD_ALIYUN_ERROR(false, 21010, "视频上传阿里云错误!"),
    VIDEO_DELETE_ALIYUN_ERROR(false, 21011, "视频删除失败"),
    FETCH_VIDEO_PLAYAUTH_ERROR(false, 21012, "获取视频播放验证错误"),
    REFRESH_VIDEO_PLAYAUTH_ERROR(false, 21013, "刷新视频上传凭证错误"),
    FETCH_PLAYAUTH_ERROR(false, 21014, "获取凭证错误"),
    URL_ENCODE_ERROR(false, 21015, "URL编码错误"),
    FETCH_ACCESSTOKEN_FAILD(false, 21016, "获取访问令牌失败"),
    FETCH_USERINFO_ERROR(false, 21017, "用户账号或密码错误"),
    ILLEGAL_CALLBACK_REQUEST_ERROR(false, 21018, "非法回调请求错误")




    ;


    private Boolean success;
    private Integer code;
    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}