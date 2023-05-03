package JDBC;

public class Main {
    public static void main(String[] args) {
        MemberDAO memberDAO=new MemberDAO();
        Member member=memberDAO.find("JDH");

        System.out.println(member.getMemberID() + " " +member.getName());

        Member member1=new Member("JDH","주동호2","010-7761-8484");
        int result = memberDAO.memberInsert(member1);

        System.out.println(result);
    }

}