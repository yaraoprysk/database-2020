package model.implementation;

import model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_info", schema = "oprysk_db")
public class InfoClient implements IGeneralModel {
    private static final String tableName = InfoClient.class.getSimpleName();
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String email;
    private String passport;

    public InfoClient() {
    }

    public InfoClient(Integer id, String firstName, String middleName, String lastName, String phone, String email, String passport) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.passport = passport;
    }

    public static String getTableName() {
        return tableName;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoClient infoClient = (InfoClient) o;
        return Objects.equals(id, infoClient.id) &&
                Objects.equals(firstName, infoClient.firstName) &&
                Objects.equals(middleName, infoClient.middleName) &&
                Objects.equals(lastName, infoClient.lastName) &&
                Objects.equals(phone, infoClient.phone) &&
                Objects.equals(email, infoClient.email) &&
                Objects.equals(passport, infoClient.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, phone, email, passport);
    }

    @Override
    public String toString() {
        return "InfoClient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}

