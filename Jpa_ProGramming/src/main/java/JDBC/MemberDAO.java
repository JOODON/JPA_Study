package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    private String user = "root";
    private String password = "kkjjss103@";
    private String dbName = "jdbc:mysql://localhost:3306/memberDB";


    public Member find(String memberID){
        Member member = null;
        String sql = "SELECT MemberID , name FROM member WHERE MemberID = ? ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbName,user,password); //데이터베이스 접근부분
            ps = connection.prepareStatement(sql);
            ps.setString(1,memberID);
            rs = ps.executeQuery();
            if (rs.next()){
                String id = rs.getString(1);

                String name = rs.getString(2);

                member=new Member(id,name);

            }//이부분 예외처리 꼭 해주기!
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return member;
    }

    public int memberInsert(Member member){
        int insertCont = 0;
        String sql = "INSERT INTO member (MemberID,name,tel) VALUES (?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbName,user,password); //데이터베이스 접근부분
            ps = connection.prepareStatement(sql);
            ps.setString(1,member.getMemberID());
            ps.setString(2,member.getName());
            ps.setString(3,member.getTel());

            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return insertCont;
    }
}
