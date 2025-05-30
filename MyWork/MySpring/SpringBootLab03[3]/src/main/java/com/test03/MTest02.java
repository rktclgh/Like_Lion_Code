package com.test03;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MTest02 {
    public static void main(String[] args) throws Exception {
        // 발급받은 액세스 토큰
        String accessToken = "eyJhbGciOiJSUzI1NiIsInR...";

       
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("http://localhost:9000/v1/users/me"))
            .header("Authorization", "Bearer " + accessToken)
            .GET()
            .build();

       
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

       
        System.out.println("응답 코드: " + response.statusCode());
        System.out.println("응답 내용: " + response.body());
    }
}
