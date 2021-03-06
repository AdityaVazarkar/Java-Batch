package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MysqlUpdateDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "aditya";
        String password = "Aditya@02";

        String QUERY = "updateFirstName emp1 set name = ? where id = ?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = con.prepareStatement(QUERY);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name ");
            ps.setString(1,sc.next());
            System.out.println("Enter id ");
            ps.setInt(2,sc.nextInt());
            int rows = ps.executeUpdate();
            System.out.println(rows + " row/s are affected");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
