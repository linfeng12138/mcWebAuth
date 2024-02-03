package vip.linfeng.mcweb.common.utils;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2023/11/16 17:43
 * @apiNote
 */
@Data
public class BaseResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /** 成功状态码 */
    public static final int SUCCESS = 200;

    /** 失败状态码 */
    public static final int FAIL = 400;

    /** 返回码 */
    private Integer code;

    /** 返回消息 */
    private String message;

    /** 存放数据 */
    private Object data;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 快捷成功result对象
     * @param message 信息
     * @return 返回值不包含data
     */
    public static BaseResult ok(String message){
        return new BaseResult(BaseResult.SUCCESS, message);
    }

    /**
     * 快捷失败result对象
     * @param message 失败信息
     * @return 返回值不包含data
     */
    public static BaseResult err(String message){
        return new BaseResult(BaseResult.FAIL, message);
    }

    /**
     * 快捷失败result对象
     * @param code 自定义失败码
     * @param message 失败信息
     * @return 返回值不包含data
     */
    public static BaseResult err(int code, String message){
        return new BaseResult(code, message);
    }


    /**
     * 快捷成功result对象
     * @param message 成功信息
     * @param data 对象内容
     * @return 返回值包含data
     */
    public static BaseResult ok(String message, Object data){
        return new BaseResult(BaseResult.SUCCESS, message, data);
    }

    /**
     * 快捷成功result对象
     * @param data 对象内容
     * @return 返回值包含data
     */
    public static BaseResult ok(Object data){
        return BaseResult.ok("success", data);
    }

    /**
     * 快捷成功result对象
     * @return 返回值不包含data
     */
    public static BaseResult ok(){
        return BaseResult.ok("success");
    }

    /**
     * 快捷失败result对象
     * @return 返回值不包含data
     */
    public static BaseResult err(){
        return BaseResult.err("fail");
    }
}
