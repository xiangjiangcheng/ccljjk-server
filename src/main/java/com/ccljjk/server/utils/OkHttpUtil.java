package com.ccljjk.server.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHttpUtils工具类
 *
 * @author Xiang Jiangcheng
 * @date 2020/6/29
 */
@Slf4j
public class OkHttpUtil {
    public final static int READ_TIMEOUT = 100;
    public final static int CONNECT_TIMEOUT = 60;
    public final static int WRITE_TIMEOUT = 60;
    public static final String JSON_STR = "application/json; charset=utf-8";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType APPLICATION_FORM_URLENCODED = MediaType.parse("application/x-www-form-urlencoded");
    public static final String APPLICATION_FORM_URLENCODED_STR = "application/x-www-form-urlencoded";
    private static final byte[] LOCKER = new byte[0];
    private static OkHttpUtil mInstance;
    private OkHttpClient mOkHttpClient;


    private OkHttpUtil() {
        OkHttpClient.Builder ClientBuilder = new OkHttpClient.Builder();
        //读取超时
        ClientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        //连接超时
        ClientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        //写入超时
        ClientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        mOkHttpClient = ClientBuilder.build();
    }

    /**
     * 单例模式获取OkHttpUtil
     *
     * @return OkHttpUtil
     */
    public static OkHttpUtil getInstance() {
        if (mInstance == null) {
            synchronized (LOCKER) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * Get方式请求
     *
     * @param url 请求地址
     * @return 请求结果
     */
    public static String doGet(String url) {

        try {
            Response response = OkHttpUtil.getInstance().getData(url);

            if (response != null && response.code() == 200) {
                assert response.body() != null;
                String result = response.body().string();
                log.info("Get url:{} ---> response: {},", url, result);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Exception happened when Get url: {}", url);
        }
        return null;
    }

    /**
     * Pot方式请求
     *
     * @param url        请求地址
     * @param bodyParams 请求参数
     * @return 请求结果
     */
    public static String doPost(String url, Map<String, String> bodyParams) {

        try {
            Response response = OkHttpUtil.getInstance().postData(url, bodyParams, JSON_STR);

            if (response != null && response.code() == 200) {
                assert response.body() != null;
                String result = response.body().string();
                log.info("Post url:{} ---> response: {},", url, result);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Exception happened when Post url: {}", url);
        }
        return null;
    }

    /**
     * x-www-form-urlencoded 格式请求
     *
     * @param url  请求路径
     * @param body 参数
     * @return 响应结果
     */
    public static String postFormBody(String url, RequestBody body) {
        Request request = new Request.Builder().url(url)
                .post(body).build();
        try {
            Response response = OkHttpUtil.getInstance().execute(request);
            if (response != null && response.code() == 200) {
                String result = response.body().string();
                log.info("Response from third party ---> post url:{} --->response: {},", url, result);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Exception happened when post url: {}", url);
        }
        return null;
    }

    /**
     * get请求，同步方式，获取网络数据，是在主线程中执行的，需要新起线程，将其放到子线程中执行
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public Response getData(String url) {
        //1 构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(url).build();
        //2 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //3 执行Call，得到response
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * post请求，同步方式，提交数据，是在主线程中执行的，需要新起线程，将其放到子线程中执行
     *
     * @param url         请求地址
     * @param bodyParams  请求参数
     * @param contentType 媒体格式类型
     * @return 响应结果
     */
    public Response postData(String url, Map<String, String> bodyParams, String contentType) {
        //1 构造RequestBody
        RequestBody body = setRequestBody(bodyParams);
        //2 构造Request
        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder.addHeader("Content-Type", contentType).post(body).url(url).build();
        //3 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //4 执行Call，得到response
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * post的请求参数，构造RequestBody，FormBody构建时需要指定媒体类型
     *
     * @param bodyParams 参数
     * @return RequestBody
     */
    private RequestBody setRequestBody(Map<String, String> bodyParams) {
        // RequestBody body = null;
        // okhttp3.FormBody.Builder formEncodingBuilder = new okhttp3.FormBody.Builder();
        // if (bodyParams != null) {
        //     Iterator<RegisterRequest> iterator = bodyParams.keySet().iterator();
        //     RegisterRequest key = "";
        //     while (iterator.hasNext()) {
        //         key = iterator.next().toString();
        //         formEncodingBuilder.add(key, bodyParams.get(key));
        //         log.info("post http post_Params=== {} === {}", key, bodyParams.get(key));
        //     }
        // }
        // body = formEncodingBuilder.build();
        Gson gson = new Gson();
        String params = gson.toJson(bodyParams);

        log.info("Post data ---> {}", params);
        return RequestBody.create(JSON, params);
    }
}
