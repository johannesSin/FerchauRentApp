package car.app;

import java.sql.SQLException;

public class Main {
	// user DB - testing variables
	private static int uid = 5;
	private static String name = "Lama";
	private static int age = 8;

	// car DB - testing variables
	private static int id = 9;
	private static String carBrand = "fiatPro";
	private static int km = 5000;
	private static int available = 0;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//User.insertUser(uid, name, age);
		//User.deleteUser(uid);
		//User.updateUser(uid, name, age);

		// Car.insertCar(id, carBrand, km, available);
		// Car.deleteCar(id);
		// Car.updateCar(id, carBrand, km, available);

		//MySQL.showTable("user");
		// MySQL.showTable("car");
		
		//the user rent a car if it's available
		//MySQL.carAvailable(id);
		
		
		//RentCar.rent(uid,id);
		
		//lMySQL.amountKm(id);
		//MySQL.numberRentedCars();
	}

}
