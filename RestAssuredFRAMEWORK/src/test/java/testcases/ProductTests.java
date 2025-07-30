package testcases;

import org.testng.annotations.Test;

import routes.Routes;
import pojo.Product;
import routes.Routes;
import utils.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import payloads.Payload;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;   // ***** for given() we have to import
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import io.restassured.response.Response;

public class ProductTests extends BaseClass {
	
	

	
                   //  1) Test to retrieve all products
    @Test(enabled=true)
	public void testGetAllProducts()
	{
		Response response =given()
		
		.when()
		.get(Routes.GET_ALL_PRODUCTS)
		
		.then()
		.extract().response();
		
	      // StatusCode Validation
		Assert.assertEquals(response.statusCode(), 200);
		
		
		// 2)------> 2. Response Body Content Validation
		
		           String title = response.jsonPath().getString("title");
		           System.out.println("titles are---->"+title);
	//	Assert.assertEquals(title, "EXPECTED Title");
		
		// If it's a list:
		
		List<Object> titles=response.jsonPath().getList("title");
		Assert.assertTrue(titles.contains("Mens Cotton Jacket"));
		
		// 3. Header Validation
		String contentType = response.getHeader("Content-Type");
		System.out.println("contentType are ----->"+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		
		// 4. Time 
		long times=response.getTime();
		System.out.println("Times are----->"+ times);
		Assert.assertTrue(times<2000, "time is too High");
		
		
		// 5 Field Count / Size Validation
		int productCount = response.jsonPath().getList("id").size();
		Assert.assertEquals(productCount, 20);
		
		// 6 NOtNull Validation
		String token = response.jsonPath().getString("token");
		Assert.assertNotNull(token);
		
		// 7 Error Message Validation (Negative Scenarios)
		
	//	String errorMsg = response.jsonPath().getString("error");
	//	Assert.assertEquals(errorMsg, "Invalid Credentials");
		
		
	// 8 Null Validation
	//	Assert.assertNull(response.jsonPath().getString("category"));
		
		
		
		
	}
	


   //  2) Test to retrieve a single product by ID     ------------------------------------------------------->
    @Test(enabled=false)
    public void testGetSingleProductById()
    {
    	int productId=configReader.getIntProperty("productId");
    	
    	given()
    	.pathParam("id", productId)
    	
    	.when()
    	.get(Routes.GET_PRODUCT_BY_ID) // ----> PathParam Will continue with this 'GET' Method
    	
    	.then()
    	.statusCode(200)
    	.log().body();
    }
    
    
  //3) Test to retrive a limited number of products----------------------------------------------------------------->
    
/*here URL will be like this "https://fakestoreapi.com/products?limit=3" i,e  QueryParam present
 * --> why we used 'PathParam' in given() instead of 'QueryParam' , Because  we given Full Url in 'Routes' Class i,e baseUrl + '/products?limit={limit}'
 * --> so that the reason we used it has 'PathParam' instead of 'QueryParam'
 * 
 * --> if in routesClass if we provide endPoint like this '/products'  instead of  '/products?limit={limit}'
 * --> then we have to go with like this   "queryParam("limit", 5)   and it will Attach at backside of get() method of when() 
 * 
 * 
 *     
 */
    
  //3) Test to retrive a limited number of products -------------------------------------------------------->
  	@Test(enabled=false)
  	public void testGetLimitedProducts()   //****** See video at 23 :00
  	{
  		given()
  			.pathParam("limit",4)
  		//	.queryParam("limit", 5)          --------> This will attach  backside of get() method of when()  so we Consider it as 'PathParam' instead of 'QueryParam'
  				
  		.when()
  			.get(Routes.GET_PRODUCTS_WITH_LIMIT)
  		.then()
  			.statusCode(200)
  			.log().body()
  			.body("size()",equalTo(4));
  	}
  	
  //*******3 )  We Can also Write LIMIT Method inBelow way also  By using ' PathPARAM & QueryPARAM----------------------------	
 
  	
  	@Test(enabled=false)
  	public void testGetLimitedProducts1()   //****** See video at 23 :00
  	{
  		given()
  			//.pathParam("limit",3)
  			.queryParam("limit", 3)     //     --------> This will attach  backside of get() method of when()  so we Consider it as 'PathParam' instead of 'QueryParam'
  				
  		.when()
  			.get(Routes.GET_ALL_PRODUCTS)
  		.then()
  			.statusCode(200)
  			.log().body()
  			.body("size()",equalTo(3));
  	}
  	
  	
//----------------------------------------------------------------------------------------------  	
  	
  	//https://fakestoreapi.com/products?limit=3&sort=desc"      , https://api.example.com/users?sort=asc
  	
  	
  //4) Test to retreive products sorted in descending order
  	@Test(enabled=false)
  	public void testGetSortedProducts()
  	{
  		Response response=given()
  			.pathParam("order", "desc")
  		.when()
  			.get(Routes.GET_PRODUCTS_SORTED)
  		.then()
  			.statusCode(200)
  			.extract().response();
  		
  		List<Integer> productIds=response.jsonPath().getList("id", Integer.class);
  		 assertThat(isSortedDesceding(productIds), is(true));
  		 
  		 System.out.println(productIds);      // to Print Asc And Dsc we used this sop
  	}
  	
  	
  	
  //---------------------------------------------------------------- 
  	
  	
  	//5 ) This AI Generated 
  	@Test(enabled=false)
  	public void testGetSortedProducts1()
  	{
  		Response response = given()
  				.pathParam("order", "asc")
  		  		.when()
  		  			.get(Routes.GET_PRODUCTS_SORTED)
  		  		.then()
  	  			.statusCode(200)
  	  			.extract().response();
  		
  		System.out.println("--->"+response.getBody().asString());

BaseClass.verifyIdsAreInAscendingOrder(response);
  	}
  	
  	
  	//5) Test to retreive products sorted in Ascending order
  		@Test(enabled=false)
  		public void testGetSortedProductsAsc()
  		{
  			Response response=given()
  				.pathParam("order", "asc")
  			.when()
  				.get(Routes.GET_PRODUCTS_SORTED)
  			.then()
  			  //   .log().body()
  				.statusCode(200)
  				.extract().response();
  			
  			
  			
  			
  			List<Integer> productIds=response.jsonPath().getList("id", Integer.class);
  			 assertThat(isSortedAsceding(productIds), is(true));
  			 
  			 
  			 System.out.println(productIds);     
  		}
  		
  		
 //------------------------------------------------- 		
  		
  	//6) Test to get all product categories
  			@Test(enabled=false)
  			public void testGetAllCategories()
  			{
  				given()
  					
  				.when()
  					.get(Routes.GET_ALL_CATEGORIES)
  				.then()
  					.statusCode(200)
  					.body("size()",greaterThan(0));
  					
  			}
  		
  		//7) Test to get products by category
  			
  			@Test(enabled=false)
  			public void testGetProductsByCategory()
  			{
  				given()
  				//	.pathParam("category", "electronics")
  				.pathParam("category","electronics")
  					
  					
  				.when()
  					.get(Routes.GET_PRODUCTS_BY_CATEGORY)
  				.then()
  					.statusCode(200)
  					.body("size()",greaterThan(0))
  					.body("category", everyItem(notNullValue()))
  					.body("category", everyItem(equalTo("electronics")))
  					.log().body();
  					
  			}
  			
  			
  			
  			
  		//8) Test to add a new product
  			@Test(enabled=false)
  			public void testAddNewProduct()
  			{
  				// ***** Creating Object for 'ProductPoJoClass' Using 'PayLoadMethod', 
  				Product newProduct=Payload.productPayload(); // ***** This Is in POJO Formate to Convert POJO to JSon is a Serilization.
  				
  				
  				int productId=given()
  					.contentType(ContentType.JSON) // ***** Converting POJO to JSon is Serilization by Using 'ContentType'
  					.body(newProduct)
  					
  				.when()
  					.post(Routes.CREATE_PRODUCT)
  				.then()
  					.log().body()
  					.statusCode(200)
  					.body("id", notNullValue())
  					.body("title", equalTo(newProduct.getTitle()))
  					.extract().jsonPath().getInt("id"); //Extracting Id from response body
  				
  				System.out.println("ids is--->"+productId);
  				
  			}	
  			
  			
  		//9) Test to update an existing product
  			@Test(enabled=false)
  			public void testUpdateProduct()
  			{
  				int productId=configReader.getIntProperty("productId");
  				
  				Product updatedPayload=Payload.productPayload();
  				
  				given()
  					.contentType(ContentType.JSON)  // ***** Converting POJO to JSon is Serilization by Using 'ContentType'
  					.body(updatedPayload)
  					.pathParam("id", productId)
  					
  				.when()
  					.put(Routes.UPDATE_PRODUCT)
  				.then()
  					.log().body()
  					.statusCode(200)
  					.body("title", equalTo(updatedPayload.getTitle()));
  					
  			}
  			
  			
  		//10) test to delete a product
  			@Test(enabled=false)
  			public void testDeleteProduct()
  			{
  				int productId=configReader.getIntProperty("productId");
  				
  				given()
  					.pathParam("id",productId)
  				.when()
  					.delete(Routes.DELETE_PRODUCT)
  				.then()
  					.statusCode(200);
  			}	
  			
  			
  			
  			
  			
  			
	
}



















