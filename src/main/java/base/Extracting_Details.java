package base;

import java.util.List;

import io.restassured.response.Response;
import objects.All_User_Data;
import objects.DeleteRequestObjects;
import objects.GetRequestObjects;
import objects.PostRequestObjects;

public class Extracting_Details {

	public void setId_username_password(Response resp) {

		List<Integer> l = resp.jsonPath().getList("id");

		All_User_Data.setId(l.get(0));
		All_User_Data.setLast_id(l.get(l.size() - 1));
		All_User_Data.setUsername(resp.jsonPath().getList("userName").get(0).toString());
		All_User_Data.setPassword(resp.jsonPath().getList("password").get(0).toString());
	}

	public void set_Title(Response resp) {

		All_User_Data.setTitle(resp.jsonPath().getString("title"));
	}

	public void getRequestDetails(Response resp) {

		GetRequestObjects.setId(resp.jsonPath().getInt("id"));
		GetRequestObjects.setUsername(resp.jsonPath().getString("userName"));
		GetRequestObjects.setPassword(resp.jsonPath().getString("password"));
	}

	public void PostRequestDetails(Response resp) {

		PostRequestObjects.setId(resp.jsonPath().getInt("id"));
		PostRequestObjects.setUsername(resp.jsonPath().getString("userName"));
		PostRequestObjects.setPassword(resp.jsonPath().getString("password"));
	}

	public void post_updateIdDataType(Response resp) {

		PostRequestObjects.setTitle(resp.jsonPath().getString("title"));
	}

	public void delete_updateIdDataType(Response resp) {

		DeleteRequestObjects.setTitle(resp.jsonPath().getString("title"));
		DeleteRequestObjects.setError_id(resp.jsonPath().getList("errors.id").get(0).toString());
	}

}
