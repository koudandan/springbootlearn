package com.chinamobile.cmss.tbd.result.shop;

/**
 * Created by hjb on 2018/2/12.
 */
public enum ShopStateEnum {

    SUCCESS("0","店铺操作成功");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ShopStateEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
