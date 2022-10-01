package tech.reliab.course.anisimov.entity.internalComponents;

import java.util.Objects;

final public class FullName {
    //region ===================== Properties ======================
    private String name;
    private String surname;
    private String patronymic;

    //region ===================== Constructor ======================
    public FullName(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    //region ===================== Setters ======================
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    //region ===================== Getters ======================
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return getName().equals(fullName.getName()) && getSurname().equals(fullName.getSurname()) && Objects.equals(getPatronymic(), fullName.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic());
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
