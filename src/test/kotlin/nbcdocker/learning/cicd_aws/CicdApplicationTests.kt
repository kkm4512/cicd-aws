package nbcdocker.learning.cicd_aws

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity

import org.assertj.core.api.Assertions.assertThat


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicdApplicationTests {

	@Autowired
	lateinit var template: TestRestTemplate

	@Test
	fun contextLoads() {
	}

	@Test
	@DisplayName("/healthz 테스트")
	fun testHomeContollerHealthz() {
		val response: ResponseEntity<String> = template.getForEntity("/healthz", String::class.java)

		// 실패하는 경우
//		assertThat(response.body).isEqualTo("on failed")

		// 성공하는 경우
		assertThat(response.body).isEqualTo("healthz-aws")
	}

}
