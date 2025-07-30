package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.Product;
import routes.Routes;

public class ProductDataDrivenTest extends BaseClass {
	
	
/* --> 3 Things we have create for DDT
 * a) --> Create TestData in Json ,csv Formate and palce in testdata folder
 * b)--> Create DataProviderMethod in utilityPackage
 * c)--> And configuring DataProviderMethod in TestCases 	
 */
	
	
	// 1) ----> Here we Have to Use 'dataProvider as Parameter' for TC, this parameter we have Specifie the DATAPROVIDER Method NAME Which present in utilsPackage.
	//2---> And also we have to specifie  Path of DataProviderClass Which present in Package. 
	//3---> If dataProviderClass is present in same class means no need to specifie the path because it is in SameClass i,e dataProviderClass=utils.DataProviders.class
	
	@Test(dataProvider="jsonDataProvider", dataProviderClass=utils.DataProviders.class)
	public void testAddNewProduct(Map<String,String> data)
	{
		
		String title=data.get("title");
		double price=Double.parseDouble(data.get("price"));
		String category=data.get("category");
		String description=data.get("description");
		String image=data.get("image");
		
		//String title, double price, String description, String image, String category
		Product newProduct=new Product(title,price,description,image,category);
		
		
		int productId=given()
			.contentType(ContentType.JSON)
			.body(newProduct)
			
		.when()
			.post(Routes.CREATE_PRODUCT)
		.then()
			.log().body()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", equalTo(newProduct.getTitle()))
			.extract().jsonPath().getInt("id"); //Extracting Id from response body
		
		System.out.println("Product ID======> "+ productId);
		
		//Delete product
		given()
			.pathParam("id",productId)
		.when()
			.delete(Routes.DELETE_PRODUCT)
		.then()
			.statusCode(200);
		
		System.out.println("Deleted Product ID======> "+ productId);
	}

//AI 	
	
	
	
	
		
}
	
	


