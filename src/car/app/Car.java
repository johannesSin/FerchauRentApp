package car.app;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Car {
	public static void insertCar(int id, String carBrand, int km, int available) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("INSERT INTO `car`(`id`, `carBrand`, `km`, `available`) VALUES ('" + id + "','" + carBrand + "','"
				+ km + "','" + available + "')");
		MySQL.disconnect();

	}

	public static void deleteCar(int id) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("DELETE FROM `car` WHERE id = " + id + "");
		MySQL.disconnect();
	}

	// the id is necessary to update a car, each car with this id will updated to
	// new dates
	public static void updateCar(int id, String carBrand, int km, int available) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("UPDATE `car` SET `id`='" + id + "',`carBrand`='" + carBrand + "',`km`='" + km + "',`available`='"
				+ available + "' WHERE id = " + id + "");
		MySQL.disconnect();
	}

}
