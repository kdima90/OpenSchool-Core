package kdima90.openschool.school.configuration;

import kdima90.openschool.school.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitMqConfiguration {
  private final ApplicationProperties applicationProperties;
  public static final String EXCHANGE_NAME = "openschool";

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(EXCHANGE_NAME);
  }

  @Bean
  public ConnectionFactory rabbitConnectionFactory() {
    CachingConnectionFactory connectionFactory =
        new CachingConnectionFactory(
            applicationProperties.getHost(), applicationProperties.getPort());
    connectionFactory.setUsername(applicationProperties.getUsername());
    connectionFactory.setPassword(applicationProperties.getPassword());
    return connectionFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory) {
    return new RabbitTemplate(rabbitConnectionFactory);
  }
}
