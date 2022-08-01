package objects;

public class All_User_Data {
	
	private static int id;
	private static String username;
	private static String password;
	private static String title;
	private static int last_id;
	
	public static int getLast_id() {
		return last_id;
	}
	public static void setLast_id(int last_id) {
		All_User_Data.last_id = last_id;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		All_User_Data.id = id;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		All_User_Data.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		All_User_Data.password = password;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		All_User_Data.title = title;
	}

	
}
