package com.tynet;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HttpClientTest {

    /**
     * 同步与异步 HTTP 请求
     */
    @Test
    void readsResponseBodyAndChecksHttpStatus()
            throws IOException, InterruptedException, ExecutionException, TimeoutException {
        byte[] body = "服务正常".getBytes(StandardCharsets.UTF_8);
        // 端口 0 让系统分配空闲端口
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        try {
            server.createContext("/health", exchange -> {
                try {
                    exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
                    exchange.sendResponseHeaders(200, body.length);
                    exchange.getResponseBody().write(body);
                } finally {
                    exchange.close();
                }
            });
            server.start();

            URI baseUri = URI.create("http://127.0.0.1:" + server.getAddress().getPort());
            HttpClient client = HttpClient.newBuilder()
                    .proxy(HttpClient.Builder.NO_PROXY)
                    .connectTimeout(Duration.ofSeconds(5))
                    .build();
            HttpRequest healthRequest = HttpRequest.newBuilder(baseUri.resolve("/health"))
                    .timeout(Duration.ofSeconds(5))
                    .build();

            HttpResponse<String> health = client.send(healthRequest, HttpResponse.BodyHandlers.ofString());
            assertEquals(200, health.statusCode());
            assertEquals("服务正常", health.body());

            HttpRequest missingRequest = HttpRequest.newBuilder(baseUri.resolve("/missing"))
                    .timeout(Duration.ofSeconds(5))
                    .build();
            // HTTP 404 仍会正常返回响应
            HttpResponse<Void> missing = client.sendAsync(missingRequest, HttpResponse.BodyHandlers.discarding())
                    .get(5, TimeUnit.SECONDS);
            assertEquals(404, missing.statusCode());
        } finally {
            server.stop(0);
        }
    }
}
