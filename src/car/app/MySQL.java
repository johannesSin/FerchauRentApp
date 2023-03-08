package car.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	private static final String host = "localhost"; // for local XAMPP
	private static final String port = "3306"; // Standart port MySQL
	private static final String database = "mysql-carapp";
	private static final String user = "root";
	private static final String password = "";

	private static Connection con;

	public static boolean isConnected() { // prove connection to MySQL
		return (con == null ? false : true);
	}

	public static void connect() throws ClassNotFoundException {
		if (!isConnected()) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
				System.out.println("MySQL - Connected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
				System.out.println("MySQL - Disconnected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static void update(String qry) { // the query get executed
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(qry);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// save into list for further usage - i.e. prove if a car is available
	public static void showTable(String nameTable) throws SQLException, ClassNotFoundException {
		MySQL.connect();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `" + nameTable + "` WHERE 1");
		int columns = rs.getMetaData().getColumnCount();
		System.out.println();
		System.out.println("All entries in " + nameTable);

		// show column names
		for (int i = 1; i <= columns; i++)
			System.out.print(rs.getMetaData().getColumnLabel(i) + "\t\t");
		System.out.println();
		System.out.println();

		// show all entries
		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + "\t\t");
			}
			System.out.println();
		}
		// Stream close, and free table
		rs.close();
		stmt.close();
		MySQL.disconnect();
	}

	// prove if car is availaible
	public static boolean carAvailable(int id) throws ClassNotFoundException, SQLException {
		MySQL.connect();

		// Create an SQL statement to select the row with the specified ID
		String sql = "SELECT * FROM `car` WHERE id = " + id;
		PreparedStatement stmt = con.prepareStatement(sql);

		/*
		 * ResultSet rs1 = stmt.executeQuery(); // print the row int columns =
		 * rs1.getMetaData().getColumnCount(); while (rs1.next()) { for (int i = 1; i <=
		 * columns; i++) { System.out.print(rs1.getString(i) + "\t\t"); }
		 * System.out.println(); }
		 */

		// Execute the SQL statement and retrieve the result set
		ResultSet rs = stmt.executeQuery();
		// Check if the specified value is in the specified column of the row
		boolean hasValue = false;
		if (rs.next()) {
			String value = rs.getString("available");
			if (value != null && value.equals("1")) {
				hasValue = true;
			}
		}

		// Close the result set, statement, and connection
		rs.close();
		stmt.close();
		MySQL.disconnect();

		// Print the result
		if (hasValue) {
			System.out.println("Car ID " + id + " is available!");
			return true;
		} else {
			System.out.println("row ID " + id + " is NOT available! ");
			return false;
		}

	}

	public static void amountKm(int id) throws ClassNotFoundException, SQLException {
		MySQL.connect();

		// Create an SQL statement to select the row with the specified ID
		String sql = "SELECT * FROM `car` WHERE id = " + id;
		PreparedStatement stmt = con.prepareStatement(sql);

		// Execute the SQL statement and retrieve the result set
		ResultSet rs = stmt.executeQuery();
		// get km
		String amountKm = null;
		if (rs.next()) {
			amountKm = rs.getString("km");
		}

		// Close the result set, statement, and connection
		rs.close();
		stmt.close();
		MySQL.disconnect();

		System.out.println("The car with id " + id + " was rented for " + amountKm + "km.");
	}
	
	public static void numberRentedCars() throws ClassNotFoundException, SQLException {
		MySQL.connect();
		int amount = 0;

		// Create an SQL statement to select the row with the specified ID
		String sql = "SELECT * FROM `rent` WHERE 1";
		PreparedStatement stmt = con.prepareStatement(sql);

		// Execute the SQL statement and retrieve the result set
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			amount++;
		}

		// Close the result set, statement, and connection
		rs.close();
		stmt.close();

		System.out.println("Currently " + amount + " cars are rented.");
		MySQL.disconnect();
	}
}
