package JDBC;

public class Member {
    private String memberID;

    private String name;

    private String tel;
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(String memberID, String name, String tel) {
        this.memberID = memberID;
        this.name = name;
        this.tel = tel;
    }

    public Member(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }


}
