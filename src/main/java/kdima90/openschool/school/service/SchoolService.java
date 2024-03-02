package kdima90.openschool.school.service;

import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.SchoolResponseEntity;

public interface SchoolService {
    SchoolResponseEntity save(SchoolRequestEntity schoolRequestEntity);
}
