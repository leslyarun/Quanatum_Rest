package com.quantumstrides;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {


	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void contextLoads() {

		ResponseEntity<String> hello = restTemplate.getForEntity("http://localhost:8080/api/create/hello", String.class, "hello");
		Assertions.assertThat(hello.getStatusCode()).isEqualTo("200");
		Assertions.assertThat(hello).isEqualTo("{\n" +
				"  \"id\": \"1\",\n" +
				"  \"name\": \"hello\"\n" +
				"}");

	}

}
