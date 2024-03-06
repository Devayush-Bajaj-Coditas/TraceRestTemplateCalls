package com.devayush.PracticeDemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Log the request if needed
        ClientHttpResponse response = execution.execute(request, body);

        System.out.println("==================== request begin ====================");
        System.out.println("URI     : " +  request.getURI());
        System.out.println("Method  : " +  request.getMethod());
        System.out.println("Headers : " +  request.getHeaders());
        System.out.println("Request : " +  new String(body, Charset.forName("UTF-8")));
        System.out.println("================ request end   ==================");



        System.out.println("================ response begin ====================");
        System.out.println("Status  : " +  response.getRawStatusCode());
        System.out.println("Status Text: "+ response.getStatusText());
        System.out.println("Headers : " + response.getHeaders());
        System.out.println("Response: " + StreamUtils.copyToString(response.getBody(), Charset.forName("UTF-8")));
        System.out.println("================ response end ====================");

        return response;
    }

}
