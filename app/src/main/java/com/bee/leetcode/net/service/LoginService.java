package com.bee.leetcode.net.service;

import com.bee.leetcode.db.bean.User;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.rxjava3.core.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import static com.bee.leetcode.util.MapUtil.str2Form;
import static com.bee.leetcode.util.MapUtil.str2Json;

/**
 * created by dr_chene on 2021/2/5
 * desc 登录
 */
public interface LoginService {

    @POST("/user/login")
    Single<User> login(
            @Body RequestBody json
    );

    /**
     * 参数与{@link RegisterService}含义一致
     */
    default Single<User> login(String registerBody, String password, String method){
        JSONObject json = new JSONObject();
        try {
            json.put("registerBody", registerBody);
            json.put("password", password);
            json.put("method", method);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return login(str2Json(json.toString()));
    }
}
