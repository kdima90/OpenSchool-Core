package kdima90.openschool.school.rest;

import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SchoolController {
  private final SchoolService messageSenderSchoolService;

  @PostMapping(value = "/api/school")
  public ResponseEntity<?> createSchool(
      @Validated @RequestBody SchoolRequestEntity schoolRequestEntity) {
    return ResponseEntity.ok().body(messageSenderSchoolService.save(schoolRequestEntity));
  }
}
