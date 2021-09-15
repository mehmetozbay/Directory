package mehmetozbay.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mehmetozbay.interfaces.CoreInterfaces;

public class CoreHelper extends CoreFields implements CoreInterfaces {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(getUrl(),getUserName(),getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	
}
