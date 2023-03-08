package car.app;

public class User {

	public static void insertUser(int uid, String name, int age) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("INSERT INTO `user`(`uid`, `Name`, `Age`) VALUES ('" + uid + "','" + name + "','" + age + "')");
		MySQL.disconnect();

	}

	// the id is necessary to update a user, each user with this id will deleted
	public static void deleteUser(int uid) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("DELETE FROM `user` WHERE uid = " + uid + "");
		MySQL.disconnect();
	}

	// the id is necessary to update a user, each user with this id will updated to
	// new dates
	public static void updateUser(int uid, String name, int age) throws ClassNotFoundException {
		MySQL.connect();
		MySQL.update("UPDATE `user` SET `uid`='" + uid + "',`Name`='" + name + "',`Age`='" + age + "' WHERE uid = "
				+ uid + "");
		MySQL.disconnect();
	}

}
