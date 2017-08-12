package com.pengttyy;

import com.pengttyy.domain.Result;
import com.pengttyy.mapper.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloApplicationTests {
    @Autowired
    RestTemplate restTemplate;
    @Test
    public void contextLoads() throws URISyntaxException {
        String url = "http://localhost:8080/bs/result";
        RequestEntity requestEntity = new RequestEntity(HttpMethod.GET, new URI(url));
        ParameterizedTypeReference<Result<User>> resultTypeReference = new ParameterizedTypeReference<Result<User>>() {
        };
        ResponseEntity<Result<User>> exchange = restTemplate.exchange(requestEntity, resultTypeReference);
        Result<User> body = exchange.getBody();

        body.getData().getList().stream().forEach(t -> System.out.println(t.getName()));

    }

}
