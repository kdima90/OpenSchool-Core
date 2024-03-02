package kdima90.openschool.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class OpenschoolSchoolApplicationTests {
	@Container
	private static PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>("postgres:16-alpine")
			.withDatabaseName("core")
			.withUsername("postgres")
			.withPassword("admin");
	@Test
	void contextLoads() {
	}

}
