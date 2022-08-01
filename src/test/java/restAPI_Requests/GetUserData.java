package restAPI_Requests;

import java.util.Random;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import base.Extracting_Details;
import io.restassured.response.Response;
import objects.All_User_Data;
import objects.DeleteRequestObjects;
import objects.GetRequestObjects;
import objects.PostRequestObjects;

public class GetUserData extends Base {
	
	private final Extracting_Details details;
	private final String title_to_check = "One or more validation errors occurred.";
	private final String error_id = "The value '1a' is not valid.";
	
	public GetUserData() {
		details = new Extracting_Details();
	}

	@Test(priority = 0)
	public void getAllUserData() throws ParseException {

		Response response = httpRequest.get();

		details.setId_username_password(response);

		assert_StatusCode(response);
	}

	@Test(dependsOnMethods = { "getAllUserData" })
	public void getUserById() {

		Response resp = httpRequest.pathParam("id", All_User_Data.getId()).get("/{id}");
		details.getRequestDetails(resp);

		assert_StatusCode(resp);
		Assert.assertEquals(1, GetRequestObjects.getId(), "Id is not same");
		Assert.assertEquals("User 1", GetRequestObjects.getUsername(), "Username doesnot match");
		Assert.assertEquals("Password1", GetRequestObjects.getPassword(), "Password doenot match");
	}

	@Test(dependsOnMethods = { "getAllUserData" })
	public void getUserById_AddingRandom() {

		Random random = new Random();
		int n = random.nextInt(11-1) + 1;
		int id = All_User_Data.getLast_id() + n;

		Response resp = httpRequest.pathParam("id", id).get("/{id}");
		details.set_Title(resp);

		Assert.assertEquals(get_StatusCode(resp), 404, "Status code doesnot match");
		Assert.assertEquals("Not Found", All_User_Data.getTitle(), "Title is not matched");
	}

	@Test
	public void post_AddUser() {

		int id = 0;

		add_Data_to_JSONObject(id);
		Response resp = httpRequest.post();

		details.PostRequestDetails(resp);

		assert_StatusCode(resp);
		Assert.assertEquals(id, PostRequestObjects.getId());
		Assert.assertEquals(username, PostRequestObjects.getUsername());
		Assert.assertEquals(password, PostRequestObjects.getPassword());
	}

	@Test
	public void post_changeId_DataType() {

		String id = "test";

		add_stringType_Id_to_JSONObject(id);

		Response resp = httpRequest.post();

		details.post_updateIdDataType(resp);

		Assert.assertEquals(get_StatusCode(resp), 400, "Status code doesnot match");
		Assert.assertEquals(title_to_check, PostRequestObjects.getTitle(), "Title is not matched");

	}

	@Test(dependsOnMethods = { "getAllUserData" })
	public void delete_User() {

		int id = All_User_Data.getId();

		Response resp = httpRequest.pathParam("id", id).delete("/{id}");

		assert_StatusCode(resp);
		Assert.assertEquals("0", resp.getHeader("content-length"));
	}

	@Test(dependsOnMethods = { "getAllUserData" })
	public void delete_User_Id_DataType_to_String() {

		String id = Integer.toString(All_User_Data.getId()) + "a";

		Response resp = httpRequest.pathParam("id", id).delete("/{id}");
		details.delete_updateIdDataType(resp);

		Assert.assertEquals(get_StatusCode(resp), 400, "Status code doesnot match");
		Assert.assertEquals(title_to_check, DeleteRequestObjects.getTitle(), "Title doesnot match");
		Assert.assertEquals(error_id, DeleteRequestObjects.getError_id(), "Error id doesnot match");
	}
}
