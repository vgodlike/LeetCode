package com.bee.leetcode.net.service;

import com.bee.leetcode.net.TempBean;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * created by dr_chene on 2021/2/5
 * desc 忘记密码接口，有两种方式：phone，email
 */
public interface ForgetService {

    String FORGET_METHOD_PHONE = "phone";
    String FORGET_METHOD_EMAIL = "email";

    /**
     *
     * @param method 重设密码的方式：FORGET_METHOD_PHONE/FORGET_METHOD_EMAIL
     * @param code 发送的验证码
     */
    @POST("/user/forget")
    Single<TempBean> forget(
            @Query("method") String method,
            @Query("username") String username,
            @Query("code") String code,
            @Query("newpassword") String newPassword
    );

    /**
     *
     * @param method 获取验证码方式：FORGET_METHOD_PHONE/FORGET_METHOD_EMAIL
     * @param number method对应的phone或者email账号
     */
    @POST("/user/requestcode")
    Single<TempBean> getCode(
            @Query("method") String method,
            @Query("number") String number
    );
}
