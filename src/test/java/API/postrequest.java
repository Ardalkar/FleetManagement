package API;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class postrequest {

	public static void main(String[] args) throws IOException {
		
		
	String body=	readdata.generateStringFromResource("C:\\MyTrainingProjectGithub\\batch50-main\\batch50-main\\FleetManagemnet\\FleetManagemnet\\src\\test\\resources\\APItestData\\createEmployee.json");
	
	//post
		Response postrequest = RestAssured.given().headers("content-type","application/json").body(body)
		.when().post("https://api.restful-api.dev/objects").then().extract().response();
		System.out.println("my response code is "+postrequest.statusCode());
		System.out.println("my response code is "+postrequest.body().asString());//why asString()? we get output in restAssured format so to convert into a readable format we use asString()
		
		
		
		String runtimeIDfrompostrequest = postrequest.jsonPath().getString("id");
		System.out.println("runtime id value" +runtimeIDfrompostrequest);
		
	//get	
		Response getrequest = RestAssured.given().headers("content-type","application/json")
		.when().get("https://api.restful-api.dev/objects/ff808181932badb60194898f4a0a5917").then().extract().response();
		System.out.println("my response code is "+getrequest.statusCode());
		System.out.println("my response code is "+getrequest.body().asString());

	//put request
		Response putrequest = RestAssured.given().headers("content-type","application/json").body("{\n"
			    + "   \"name\": \"MacBook Pro KOMAL\",\n"
			    
			    + "}")
			    .when().put("https://api.restful-api.dev/objects/"+runtimeIDfrompostrequest).then().extract().response();
			  System.out.println("my put response code is " + putrequest.statusCode());
			  
			  System.out.println("my put response body is " + putrequest.body().asString());
			  
			  
			  
			  Response getrequestafterput = RestAssured.given().headers("content-type","application/json")
						.when().get("https://api.restful-api.dev/objects/"+ runtimeIDfrompostrequest).then().extract().response();

					System.out.println("response code is " + getrequestafterput.statusCode());
				   System.out.println("response body is " + getrequestafterput.body().asString());
		//patch

				   Response putrequest = RestAssured.given().headers("content-type","application/json").body("{\n"
						    + "   \"name\": \"MacBook Pro KOMAL\",\n"
						    + "   \"data\": {\n"
						    + "      \"year\": 2024,\n"
						    + "      \"price\": 18493456.99,\n"
						    + "      \"CPU model\": \"Intel Core i9\",\n"
						    + "      \"Hard disk size\": \"1 TB\"\n"
						    + "   }\n"
						    + "}")
						    .when().put("https://api.restful-api.dev/objects/"+runtimeIDfrompostrequest).then().extract().response();
						  System.out.println("my put response code is " + putrequest.statusCode());
						  
						  System.out.println("my put response body is " + putrequest.body().asString());
						  
						  
						  
						  Response getrequestafterput = RestAssured.given().headers("content-type","application/json")
									.when().get("https://api.restful-api.dev/objects/"+ runtimeIDfrompostrequest).then().extract().response();

								System.out.println("response code is " + getrequestafterput.statusCode());
							   System.out.println("response body is " + getrequestafterput.body().asString());

	
	
	}
}
