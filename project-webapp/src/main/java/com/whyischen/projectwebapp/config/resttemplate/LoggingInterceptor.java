package com.whyischen.projectwebapp.config.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        long start = System.currentTimeMillis();
        long cost = System.currentTimeMillis() - start;
        if (cost > 100) {
            log.warn("Request uri: [{}], Cost times: {}ms", request.getURI(), cost);
        }
        // 打印日志
        trace(request, body, response);
        return response;
    }

    private void trace(HttpRequest request, byte[] body, ClientHttpResponse response) throws IOException {
        // 记录日志
        String responseStr = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
        String format = """
                    \"""
                    URI          : {},
                    Method       : {},
                    Headers      : {},
                    Param        : {},
                    RespStatus   : {},
                    Response     : {}
                """;
        log.info(format
                , request.getURI(),
                request.getMethod(), request.getHeaders(), new String(body, StandardCharsets.UTF_8), response.getStatusCode(), responseStr);
    }
}
