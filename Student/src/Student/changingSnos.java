package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class changingSnos {
	public static void main(String args[]) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql//127.0.0.1:3306:student","root", "mass32610");
		for (int i = 1;i < 4; i++ )
		{	
		
			String q = "update std_data set sn0 = '"+i+"' ";
			Statement sta = con.createStatement();
			sta.executeUpdate(q);
			
			
		}
	}

}
