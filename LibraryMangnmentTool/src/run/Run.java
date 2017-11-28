package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Run {

	public static void main(String[] args) {
		Connection con = null;
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("JDBC:sqlite:test.db");
			PreparedStatement p = con.prepareStatement("create databse mytest");
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(0));
			}
			
			System.out.println("connected");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
