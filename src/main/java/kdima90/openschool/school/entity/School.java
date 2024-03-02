package kdima90.openschool.school.entity;

import jakarta.persistence.*;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="school", schema="openschool")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private Integer streetNumber;
    @Column
    private Locale locale;
    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String postalCode;
    @Column
    private String federalState;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFederalState() {
        return federalState;
    }

    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(streetNumber, school.streetNumber) && Objects.equals(locale, school.locale) && Objects.equals(name, school.name) && Objects.equals(street, school.street) && Objects.equals(city, school.city) && Objects.equals(postalCode, school.postalCode) && Objects.equals(federalState, school.federalState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, locale, name, street, city, postalCode, federalState);
    }
}
