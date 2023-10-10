package org.example.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * 单元测试
 */
public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112828452524/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxqsessionid=e962af60a8b80343952e63bb73d4fa45; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818284154155812%22%2C%22first_id%22%3A%2218b14bcfef53d0-0a3f35ba7819488-26031e51-1327104-18b14bcfef6acb%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMTRiY2ZlZjUzZDAtMGEzZjM1YmE3ODE5NDg4LTI2MDMxZTUxLTEzMjcxMDQtMThiMTRiY2ZlZjZhY2IiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTgyODQxNTQxNTU4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818284154155812%22%7D%2C%22%24device_id%22%3A%2218b14bcfef53d0-0a3f35ba7819488-26031e51-1327104-18b14bcfef6acb%22%7D; zsxq_access_token=9DC3644B-7D7E-D0C6-D829-431D4121C56D_D51CA57B92FA76CD");

        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/411542555485158/answer");

        post.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxqsessionid=e962af60a8b80343952e63bb73d4fa45; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818284154155812%22%2C%22first_id%22%3A%2218b14bcfef53d0-0a3f35ba7819488-26031e51-1327104-18b14bcfef6acb%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMTRiY2ZlZjUzZDAtMGEzZjM1YmE3ODE5NDg4LTI2MDMxZTUxLTEzMjcxMDQtMThiMTRiY2ZlZjZhY2IiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTgyODQxNTQxNTU4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818284154155812%22%7D%2C%22%24device_id%22%3A%2218b14bcfef53d0-0a3f35ba7819488-26031e51-1327104-18b14bcfef6acb%22%7D; zsxq_access_token=9DC3644B-7D7E-D0C6-D829-431D4121C56D_D51CA57B92FA76CD");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"zijiqubaodu!\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
