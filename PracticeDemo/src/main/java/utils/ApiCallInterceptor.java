//package utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//@Slf4j
//@Component
//public class ApiCallInterceptor implements ClientHttpRequestInterceptor {
//
//    private final String externalServiceBaseUrl;
//
//    public ApiCallInterceptor(String externalServiceBaseUrl) {
//        this.externalServiceBaseUrl = externalServiceBaseUrl;
//    }
//
//    private void logAndStoreRequest(HttpRequest request, byte[] body) {
//        // Implement your logging logic (e.g., using a logger framework)
//        // Log request
//        log.debug("==================== request begin ====================");
//        log.debug("URI     : {}", request.getURI());
//        log.debug("Method  : {}", request.getMethod());
//        log.debug("Headers : {}", request.getHeaders());
//        log.debug("Request : {}", new String(body, Charset.forName("UTF-8")));
//        log.debug("==================== request end   ==================");
//
////log response
//        log.debug("==================== response begin ====================");
//        log.debug("Status  : {}", response.getRawStatusCode());
//        log.debug("Status  : {}", response.getRawStatusCode());
//        log.debug("Status Text: {}", response.getStatusText());
//        log.debug("Headers : {}", response.getHeaders());
//        log.debug("Response: {}", responseBody.toString());
//        log.debug("==================== response end   ====================");
//
//        // Store request details for later access (optional)
//        // This could involve storing in a thread-local variable or another mechanism
//        storeRequest(request, body); // Implementation depends on your needs
//    }
//
//    private void storeRequest(HttpRequest request, byte[] body) {
//        // Implement logic to store request details (e.g., thread-local variable)
//        // ...
//    }
//
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        if (request.getURI().toString().startsWith(externalServiceBaseUrl)) {
//            // Log request details and store them for database saving later
//            logAndStoreRequest(request, body);
//        }
//        return execution.execute(request, body);
//    }
//}
//
