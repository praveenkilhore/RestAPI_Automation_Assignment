package base;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

	public RequestSpecification httpRequest;
	public String username = "Praveen";
	public String password = "test";
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Users";
		httpRequest = RestAssured.given();
	}

	public int get_StatusCode(Response response) {

		return (response.getStatusCode());
	}
	
	public void assert_StatusCode(Response response) {

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is valid");
	}

	@SuppressWarnings("unchecked")
	public void add_Data_to_JSONObject(int id) {

		httpRequest.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("userName", username);
		json.put("password", password);

		httpRequest.body(json.toJSONString());
	}
	
	@SuppressWarnings("unchecked")
	public void add_stringType_Id_to_JSONObject(String id) {

		httpRequest.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("userName", username);
		json.put("password", password);

		httpRequest.body(json.toJSONString());
	}

}
