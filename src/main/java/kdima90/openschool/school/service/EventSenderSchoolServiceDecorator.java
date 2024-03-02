package kdima90.openschool.school.service;

import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.SchoolResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventSenderSchoolServiceDecorator extends AbstractSchoolServiceDecorator{

    public EventSenderSchoolServiceDecorator(SchoolService schoolService) {
        super(schoolService);
    }

    @Override
    public SchoolResponseEntity save(SchoolRequestEntity schoolRequestEntity) {
        SchoolResponseEntity schoolResponseEntity = super.save(schoolRequestEntity);
        //TODO: send amqp message
        return schoolResponseEntity;
    }
}
