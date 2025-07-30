package payloads;

import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Address_Nest;
import pojo.GeoLocation_Nest;
import pojo.Name_Nest;
import pojo.Product;
import pojo.User_Nest;


public class Payload {
	
	
	private static final Faker faker=new Faker();  // we Can Generate Random Data by Using Faker class and it contains methods
	private static final String categories[]= {"electronics", "furniture", "clothing", "books", "beauty"};
	
	private static final Random random=new Random();
	
		
	//Product =1   ,**** This are the Method, to generate random Data using Faker Class  and Assign it to POJO Class 
	public static Product productPayload()   // Here ReturnType of "METHOD" 'Product' is from 'pojo' class 'Constructor'
	{
		String name=faker.commerce().productName();                   // it will generate ProductName randomly like 'Electronic,Clothes,Mobiles etc.
		double price=Double.parseDouble(faker.commerce().price());    // It Return 'String' but we have Parse to DOUBLE
		String description=faker.lorem().sentence();                  // 'Lorem' will Generate DESCRIPTION' 
	//	String imageUrl="https://i.pravatar.cc/100";                 // ** We Can also HARDCODE like this
		String imageUrl=faker.internet().image();                   // ----> We can Generate  image randomly by using this Method   
		String category=categories[random.nextInt(categories.length)];   // instead of, categories[0] or categories[random.nextInt(4)] , we went this Step
		// String category=categories[0];
		
/*		
  ***** Here  We Created OBJECT  for ProductClass which is present in  PojoPackage  ,  so that Values will Assign to CONSTRUCTOR in ProductClass
  
    Product p =new Product(name, price, description, imageUrl, category);
	return p;              // ----->Instead of Writing this  we goes with next Step.
		
*/
		
		return new Product(name, price, description, imageUrl, category);  // we goes to  write like this
	}
	
	//User =2   
	
	public  static User_Nest userPayload()
	{
		// name
		String firstname =  faker.name().firstName();
		String lastname = faker.name().lastName();
		
		Name_Nest  name = new Name_Nest(firstname,lastname);
		
		// Location   latitude , longitute
		String latitude = faker.address().latitude();
		String longitute=faker.address().longitude();
		
		GeoLocation_Nest   location = new  GeoLocation_Nest(latitude,longitute);
		
		
		// Address 
		       String city = faker.address().city();
		 String street = faker.address().streetName();
	int number=random.nextInt(100);
	String zipcode=faker.address().zipCode();
	 
	Address_Nest address = new Address_Nest (city,street,number,zipcode);
	
	// User
	
	String email=faker.internet().emailAddress();
	String username =faker.name().name();
	String password =faker.internet().password();
	String  phone =faker.phoneNumber().cellPhone();
	
	
	User_Nest user = new User_Nest(email,username,password,name,address,phone);
	
	return user;
			
		
	}
	
	
	
	
	
	
	//Cart
	//Login


}
