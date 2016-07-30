package com.shang.spray.common.base;

/**
 * info:状态码
 * Created by shang on 16/7/1.
 */
public enum  BaseApiCode {


    STATUS_200(200, "OK"),
    STATUS_400(400, "ERROR"),
    STATUS_500(500, "Exception"),

    STATUS_1070(1070, "没有版本信息"),
    STATUS_1100(1100, "参数不能为空"),
    STATUS_1001(1001, "手机号格式不正确"),
    STATUS_1002(1002, "请输入手机号和密码"),
    STATUS_1003(1003, "手机号已存在"),
    STATUS_1004(1004, "不是手机来源"),
    STATUS_1005(1005, "手机验证码不能为空"),
    STATUS_1006(1006, "验证码超时，请重新获取"),
    STATUS_1007(1007, "验证码错误，请重新输入"),
    STATUS_1008(1008, "该手机号码还未注册"),
    STATUS_1009(1009, "手机号或者密码不正确"),
    STATUS_1010(1010, "请输入手机号和验证码"),
    STATUS_1011(1011, "请绑定账号后使用授权登录"),
    STATUS_1012(1012, "请使用正确的身份证"),


    STATUS_1000(1000, "手机号不能为空");


    private int status;

    private String msg;

    BaseApiCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
