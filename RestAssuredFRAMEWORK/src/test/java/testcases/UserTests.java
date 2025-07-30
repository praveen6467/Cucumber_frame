package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import payloads.Payload;
import pojo.User_Nest;
import routes.Routes;
import static org.hamcrest.Matchers.*;

public class UserTests  extends BaseClass {
	
	//1) Fetch all the users
	
	@Test(enabled=false)
	public void testGetAllUsers()
	{
		given()
		.when()
			.get(Routes.GET_ALL_USERS)
		.then()
			.statusCode(200)
			.log().body()
			.contentType(ContentType.JSON)
			.body("size()",greaterThan(0));
		
	}
	
	
	//6) Test to create a new user
	
		@Test
		public void testCreateUser()
		{
			User_Nest newUser = Payload.userPayload();     // Here 'PayLoad' is class it contains  'userPayload' Method  and return  pojo class i,e "User_Nest" 
					
			int id=given()
				.contentType(ContentType.JSON)
				.body(newUser)
			.when()
				.post(Routes.CREATE_USER)
			.then() 
				.log().body()
				.statusCode(200)
				.body("id", notNullValue())
				.extract().jsonPath().getInt("id");
			
			System.out.println("Generated UserID=====:"+ id);

		}
		
		
		//7) Test to update user
		
		@Test
		public void testUpdateUser()
		{
			int userId=configReader.getIntProperty("userId");
			
			User_Nest updateUser=Payload.userPayload();
					
			given()
				.contentType(ContentType.JSON)
				.pathParam("id", userId)
				.body(updateUser)
			.when()
				.put(Routes.UPDATE_USER)      // put ic vvimp
			.then() 
				.log().body()
				.statusCode(200)
				.body("username",equalTo(updateUser.getUsername()));       // ******** Except 'Id' we can Validate any thing in the body 
					
		}
		
		
		//8) delete user
		
		@Test
		void testDeleteUser()
		{

			int userId=configReader.getIntProperty("userId");
			
			given()
				.pathParam("id", userId)
			.when()
				.delete(Routes.DELETE_USER)
			.then()
				.statusCode(200);
			}
		

}














