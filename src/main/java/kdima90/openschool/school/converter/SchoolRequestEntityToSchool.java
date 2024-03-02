package kdima90.openschool.school.converter;

import kdima90.openschool.school.entity.School;
import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SchoolRequestEntityToSchool implements Converter<SchoolRequestEntity, School> {

    @Override
    public School convert(SchoolRequestEntity schoolRequestEntity) {
        School school = new School();
        school.setStreetNumber(schoolRequestEntity.streetNumber());
        school.setLocale(schoolRequestEntity.locale());
        school.setName(schoolRequestEntity.name());
        school.setStreet(schoolRequestEntity.street());
        school.setCity(schoolRequestEntity.city());
        school.setPostalCode(schoolRequestEntity.postalCode());
        school.setFederalState(schoolRequestEntity.federalState());
        return school;
    }
}
