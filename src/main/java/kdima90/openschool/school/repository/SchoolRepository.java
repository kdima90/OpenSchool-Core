package kdima90.openschool.school.repository;

import java.util.UUID;
import kdima90.openschool.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, UUID> {}
