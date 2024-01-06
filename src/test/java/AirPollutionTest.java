import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class AirPollutionTest {
    @Test
    public static void Test_Given_Location_AirPollution_Forecast_O3_ValuesIsNotNull() {
        given().queryParam("lat", "59.332848").queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().body("list[0].components.o3", Matchers.notNullValue());
    }

    @Test
    public static void Test_Wrong_APIKEY_Returns_code_401() {
        given().queryParam("lat", "59.332848").queryParam("lon", "18.053135").queryParam("appid", "wrongapi").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusCode(401);
    }

    @Test
    public static void Test_Wrong_APIKEY_Returns_message_Invalid() {
        given().queryParam("lat", "59.332848").queryParam("lon", "18.053135").queryParam("appid", "wrongapi").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusLine("HTTP/1.1 401 Unauthorized");
    }

    @Test
    public static void Test_Right_APIKEY_Returns_code_200() {
        given().queryParam("lat", "59.332848").queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusCode(200);
    }

    @Test
    public static void Test_Wrong_latitude_Returns_code_400() {
        given().queryParam("lat", "wrong").queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusCode(400);
    }

    @Test
    public static void Test_Wrong_longitude_Returns_code_400() {
        given().queryParam("lat", "59.332848").queryParam(" lon", "wrong").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusCode(400);
    }

    @Test
    public static void Test_Without_query_param_latitude_returns_statuscode_400() {
        given().queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusCode(400);
    }

    @Test
    public static void Test_Without_query_param_latitude_returns_statusmessage_Bad_request() {
        given().queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusLine("HTTP/1.1 400 Bad Request");
    }

    @Test
    public static void Test_Without_query_param_longitude_returns_statusmessage_Bad_request() {
        given().queryParam("lat", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/air_pollution/forecast").then().statusLine("HTTP/1.1 400 Bad Request");
    }
    @Test
    public static void Test_Wrong_API_Returns_code_404() {
        given().queryParam("lat", "59.332848").queryParam("lon", "18.053135").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5").then().statusCode(404);
    }
}

