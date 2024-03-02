package kdima90.openschool.school.response;

import java.util.Locale;
import java.util.UUID;

public record SchoolResponseEntity(
    UUID id,
    String name,
    String street,
    Integer streetNumber,
    String city,
    String postalCode,
    String federalState,
    Locale locale) {}
