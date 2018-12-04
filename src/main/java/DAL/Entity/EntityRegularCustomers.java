package DAL.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "regular_customers", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class EntityRegularCustomers {
    private int cardNumber;
    private String customerName;
    private Timestamp birthDate;
    private String email;
    private String phoneNumber;
    private Integer minutesInCafe;
    private Integer age;
    private Integer discount;

    @Id
    @Column(name = "card_number", nullable = false)
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 50)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "birth_date", nullable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 15)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "minutes_in_cafe", nullable = true)
    public Integer getMinutesInCafe() {
        return minutesInCafe;
    }

    public void setMinutesInCafe(Integer minutesInCafe) {
        this.minutesInCafe = minutesInCafe;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityRegularCustomers that = (EntityRegularCustomers) o;
        return cardNumber == that.cardNumber &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(minutesInCafe, that.minutesInCafe) &&
                Objects.equals(age, that.age) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, customerName, birthDate, email, phoneNumber, minutesInCafe, age, discount);
    }
}
