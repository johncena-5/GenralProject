package genral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC {

	public static void main(String[] args) throws Throwable {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hebbal","root","root");
		Statement state = con.createStatement();
		String query = "select * from student";
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}
	}
}
