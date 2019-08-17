import okhttp3.*;

import java.io.IOException;

/**
 * Created by dat on 2019-08-07.
 */
public class SlackClient {
    public SlackClient(String token) {
        this.token = token;
    }

    OkHttpClient client = new OkHttpClient();
    private String token;

    String post(String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://slack.com/api/chat.postMessage")
                .header("Authorization", "Bearer " + token)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            String responseBody = response.body().string();
            System.out.println("Response Body: " + responseBody);
            return responseBody;
        }
    }
    
    String postImage(String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.get("application/x-www-form-urlencoded; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://slack.com/api/files.up")
                .header("Authorization", "Bearer " + token)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            String responseBody = response.body().string();
            System.out.println("Response Body: " + responseBody);
            return responseBody;
        }
    }
}