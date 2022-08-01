package objects;

public class PostRequestObjects {
	
	private static int id;
	private static String username;
	private static String password;
	private static String title;
	
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		PostRequestObjects.title = title;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		PostRequestObjects.id = id;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		PostRequestObjects.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		PostRequestObjects.password = password;
	}
	

}
