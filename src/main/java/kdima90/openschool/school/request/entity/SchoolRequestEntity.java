package kdima90.openschool.school.request.entity;

import java.util.Locale;

public record SchoolRequestEntity(
    String name,
    String street,
    Integer streetNumber,
    String city,
    String postalCode,
    String federalState,
    Locale locale) {}
