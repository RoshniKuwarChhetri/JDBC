package preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5433/jdbc";
			String username="postgres";
			String password="root";
			
			Connection c=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=c.prepareStatement("insert into fruit values(?,?,?)");
			Scanner sc =new Scanner(System.in);
			
			int id= sc.nextInt();
			sc.nextLine();
			
			String name=sc.nextLine();
			String color=sc.nextLine();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, color);
			
			int rowAff=ps.executeUpdate();
			if(rowAff>0) {
				System.out.println("row inserted syccessfully");
			}else {
				System.out.println("not inserted");
			}
			c.close();
		}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

}
