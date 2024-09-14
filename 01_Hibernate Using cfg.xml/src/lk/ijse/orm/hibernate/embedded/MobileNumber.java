package lk.ijse.orm.hibernate.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {

    private String type;
    private String mobile_number;

    public MobileNumber() {}

    public MobileNumber(String type, String mobile_number) {
        this.type = type;
        this.mobile_number = mobile_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "type='" + type + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }

}
