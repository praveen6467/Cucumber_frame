package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import routes.Routes;

public class SchemaTests  extends BaseClass{
	
	@Test
	public void testProductSchema ()
	{
int productId=configReader.getIntProperty("productId");
    	
    	given()
    	.pathParam("id", productId)
    	
    	.when()
    	.get(Routes.GET_PRODUCT_BY_ID)
    	
    	.then() 
    	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("productSchema.json"));
    //	.log().body();
    	
    	/****** When Ever we Performed SchemaValidation  in 'then()' Method we need NOT Mention Any Thing Except Schema only
    	 *  Here 'JsonSchemaValidator' is a Class , 'matchesJsonSchemaInClassPath' is Method . 
    	 *  --> In parathesis we have specifie 'jsonSchemaFileName' that is CaseSensitive 
    	 *  ---> As we Know that  we Cannot Validate Each Field From Response Instead of that we Used 'SCHEMAVALIDATION'
    	 */
    	
	}

}
