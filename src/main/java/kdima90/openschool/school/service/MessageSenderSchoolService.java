package kdima90.openschool.school.service;

import static kdima90.openschool.school.configuration.RabbitMqConfiguration.EXCHANGE_NAME;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.entity.SchoolResponseEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderSchoolService extends AbstractSchoolService {
  private final SchoolService schoolServiceImpl;
  private final RabbitTemplate rabbitTemplate;
  private final ObjectMapper objectMapper;

  public MessageSenderSchoolService(
      SchoolService schoolServiceImpl, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
    super(schoolServiceImpl);
    this.schoolServiceImpl = schoolServiceImpl;
    this.rabbitTemplate = rabbitTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public SchoolResponseEntity save(SchoolRequestEntity schoolRequestEntity) {
    SchoolResponseEntity schoolResponseEntity = super.save(schoolRequestEntity);
    // {
    //  "id": "d0482898-5a6f-4c90-95d8-aecb35f3bf2d",
    //  "name": "SchoolCreated",
    //  "time": "2024-01-01T00:00:00Z",
    //  "data": {
    //	"schoolId": "e31e52ed-3f84-414a-a03a-55356dcc01aa",
    //	"schoolName": "Test school",
    // 	...
    //  }
    // }

    try {
      rabbitTemplate.convertAndSend(
          EXCHANGE_NAME,
          "openschool.school.school.created",
          objectMapper.writeValueAsBytes(schoolResponseEntity));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return schoolResponseEntity;
  }
}
