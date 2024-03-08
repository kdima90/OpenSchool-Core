package kdima90.openschool.school.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("openschool.rabbitmq")
@Configuration
@Validated
@Getter
@Setter
public class ApplicationProperties {
  private String host;
  private Integer port;
  private String username;
  private String password;
}
