package testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.Product;
import routes.Routes;

public class PRACTICAL extends BaseClass {
	
	
/*	
	@Test(priority=1)
	public void Test_getAllProducts ()
	{
		
given()

.when()
.get(Routes.GET_ALL_PRODUCTS)

.then()
.statusCode(200)
.statusLine("HTTP/1.1 200 OK")
//.log().body()
//.extract().response().body();
//.log().all();
.log().status()
.log().headers();

}	
	
	@Test(priority=2)
public void TestGetProductById()
{
	int prodId =configReader.getIntProperty("productId");
	
	given()
	.pathParam("id",prodId)
	
	.when()
	.get(Routes.GET_PRODUCT_BY_ID)
	
	.then()
	.statusCode(200)
	.log().status()
	.log().all()
	.log().ifError();
}
	
	
@Test(priority=3)	
public void Testgetlimt()
{
  given()
	.pathParam("limit",4)
	
	.when()
	.get(Routes.GET_PRODUCTS_WITH_LIMIT)
	
	.then()
	.log().body();
	
	
	
}
	

@Test(priority=4)
public void getlimit()
{
	given()
	.queryParam("limit", 2)
	
	.when()
	.get(Routes.GET_ALL_PRODUCTS)
	
	.then()
	.statusCode(200)
	.log().body();
}
	*/

@Test(enabled=false)
public void TestSoretedAsc()
{
	Response res =given()
	.pathParam("order", "asc")
	
	.when()
	.get(Routes.GET_PRODUCTS_SORTED)
	
	
	.then()
	.statusCode(200)
	//.log().body()
	.extract().response();
	
	
	String body=res.getBody().asString();
	
	long responseTime = res.getTime();
	System.out.println("time is-->"+responseTime);
	Assert.assertTrue(responseTime < 2000, "Response time is too high");

	
	System.out.println("Body is ---->"+body);
	
	
}


@Test()
public void TestCreateProduct()
{
	Product prod =Payload.productPayload();
	
	
	given()
	.contentType(ContentType.JSON)
	.body(prod)
	
	.when()
	.post(Routes.CREATE_PRODUCT)
	
	.then()
	.statusCode(200)
	.log().all();
	
}







	

}











