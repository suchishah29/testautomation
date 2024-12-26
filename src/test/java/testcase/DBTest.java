package testcase;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;
import org.testng.annotations.Test;

public class DBTest {

	public static void main() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("connection string", "username", "pwd");
		Statement stmt = con.createStatement();
		String query = "select * from table";
		stmt.execute(query);
	}
}
