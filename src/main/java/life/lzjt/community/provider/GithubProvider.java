package life.lzjt.community.provider;

import com.alibaba.fastjson.JSON;
import life.lzjt.community.dto.AccessTokenDTO;
import life.lzjt.community.dto.GithubUser;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * @author 赵志文
 * @date 2021/5/4
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
    MediaType mediaType = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
    Request request = new Request.Builder()
            .url("https://github.com/login/oauth/access_token")
            .post(body)
            .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String s = string.split("&")[0].split("=")[1];
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public GithubUser getUser(String accessToken) throws Exception {
        int timeout = 60;
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout * 1000)
                .setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000)
                .build();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://api.github.com/user");
        httpget.addHeader(new BasicHeader("Authorization", "token "+accessToken));
        httpget.setProtocolVersion(HttpVersion.HTTP_1_0);
        httpget.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
        httpget.setConfig(defaultRequestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            GithubUser user = JSON.parseObject(entity.getContent(),GithubUser.class);
            EntityUtils.consume(entity);
            response.close();
            return  user;
        } catch (Exception e){
            throw e;
        } finally{
            if(response != null){
                response.close();
            }
            if(httpclient!=null){
                httpclient.close();
            }
        }
    }

}
