package kdima90.openschool.school.service;

import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.SchoolResponseEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractSchoolService implements SchoolService {
  private final SchoolService schoolService;

  @Override
  public SchoolResponseEntity save(SchoolRequestEntity schoolRequestEntity) {
    return schoolService.save(schoolRequestEntity);
  }
}
