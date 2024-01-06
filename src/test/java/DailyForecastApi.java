import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DailyForecastApi {
    @Test
    public static void Test_Daily_forecast_with_right_Api_key() {
        given().queryParam("lat", "28.644800").queryParam("lon", "77.216721").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/forecast/daily").then().statusCode(200);
    }

    @Test
    public static void Test_Daily_forecast_reponse_is_not_error_with_right_Api_key() {
        given().queryParam("lat", "28.644800").queryParam("lon", "77.216721").queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").get("https://api.openweathermap.org/data/2.5/forecast/daily").then().body("message", Matchers.not("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
    }
}
