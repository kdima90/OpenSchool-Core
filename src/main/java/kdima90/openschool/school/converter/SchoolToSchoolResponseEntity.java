package kdima90.openschool.school.converter;

import kdima90.openschool.school.entity.School;
import kdima90.openschool.school.response.entity.SchoolResponseEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SchoolToSchoolResponseEntity implements Converter<School, SchoolResponseEntity> {
  @Override
  public SchoolResponseEntity convert(School school) {
    return new SchoolResponseEntity(
        school.getId(),
        school.getName(),
        school.getStreet(),
        school.getStreetNumber(),
        school.getCity(),
        school.getPostalCode(),
        school.getFederalState(),
        school.getLocale());
  }
}
