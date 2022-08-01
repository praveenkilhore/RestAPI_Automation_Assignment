package objects;

public class GetRequestObjects{
	
	private static int id;
	private static String username;
	private static String password;
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		GetRequestObjects.id = id;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		GetRequestObjects.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		GetRequestObjects.password = password;
	}
	

}
