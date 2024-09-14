package lk.ijse.orm.hibernate.entity;

import lk.ijse.orm.hibernate.embedded.MobileNumber;
import lk.ijse.orm.hibernate.embedded.NameIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* We can define the @Entity and @Table(name = "customer") OR @Entity(name = "customer") without @Table */
@Entity
@Table (name = "customer")
public class Customer_01 {

    @Id // Tells that Hibernate this is the primary key.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "customer_id")
    private int id;

//    @Column (name = "customer_name")
//    private String name;


    private NameIdentifier nameIdentifier;

    @Column (name = "customer_address")
    private String address;

    @Column (name = "customer_salary")
    private double salary;

    @Transient // It will not be persisted. No db column created. Save assign values in variable. When the application is closed, data will be lost.
    @Column (name = "customer_dob")
    private String dob;

    @ElementCollection
    @CollectionTable (name = "customer_mobile_numbers", joinColumns = @JoinColumn(name = "customer_id")) // want to give column name. not variable name
    private List <MobileNumber> mobileNumbers = new ArrayList<>();  // Customer has list of mobile numbers ⇒ HAS A relationship

    public Customer_01() {
    }

    public Customer_01(int id, NameIdentifier nameIdentifier, String address, double salary, String dob, List<MobileNumber> mobileNumbers) {
        this.id = id;
        this.nameIdentifier = nameIdentifier;
        this.address = address;
        this.salary = salary;
        this.dob = dob;
        this.mobileNumbers = mobileNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdentifier getNameIdentifier() {
        return nameIdentifier;
    }

    public void setNameIdentifier(NameIdentifier nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nameIdentifier=" + nameIdentifier +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}
