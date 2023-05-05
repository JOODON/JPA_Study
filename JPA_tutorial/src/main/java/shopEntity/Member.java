package shopEntity;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column (name = "MEMBER_ID")
    private Long member_Id;
    private String name;

    private String city;

    private String street;

    private String zipcode;
}
