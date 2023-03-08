package car.app;

import java.sql.Connection;
import java.sql.SQLException;

public class RentCar {

	public static void rent(int uid, int id) throws ClassNotFoundException, SQLException {
		if (MySQL.carAvailable(id)) {

			System.out.println("Car available - implementation for rent missing.");

			//join on new table where all rented cars with user a joined
			//the status of the car in table car need to be updated => not available

		} else {
			System.out.println("Car not available, renting not possible!");
		}
	}
	
	//
	public static void carRentReturn(int uid) {
		//function to give the car back - the table rent need to delete the row with rent status
		//care table needs to get updated to set back the status of the car as available and also increase the amount of km
		
	}
	
	public static void getRentInfo(int uid) {
		//function to give information which car is currently rented by a specific user by its id
	}
}
