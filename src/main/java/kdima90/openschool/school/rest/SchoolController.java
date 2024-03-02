package kdima90.openschool.school.rest;

import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.service.SchoolServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
  private final SchoolServiceImpl schoolServiceImpl;

  public SchoolController(SchoolServiceImpl schoolServiceImpl) {
    this.schoolServiceImpl = schoolServiceImpl;
  }

  @PostMapping(value = "/api/school")
  public ResponseEntity<?> createSchool(
      @Validated @RequestBody SchoolRequestEntity schoolRequestEntity) {
    return ResponseEntity.ok().body(schoolServiceImpl.save(schoolRequestEntity));
  }
}
