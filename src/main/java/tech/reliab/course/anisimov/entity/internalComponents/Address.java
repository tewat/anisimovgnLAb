package tech.reliab.course.anisimov.entity.internalComponents;

import java.util.Objects;

final public class Address {
    //region ===================== Properties ======================
    private String id;
    private String cityName;
    private String streetAndHouse;

    //region ===================== Constructor ======================
    public Address(String id, String cityName, String streetAndHouse) {
        this.id = id;
        this.cityName = cityName;
        this.streetAndHouse = streetAndHouse;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStreetAndHouse(String streetAndHouse) {
        this.streetAndHouse = streetAndHouse;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStreetAndHouse() {
        return streetAndHouse;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return getId().equals(address.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", streetAndHouse='" + streetAndHouse + '\'' +
                '}';
    }
}
