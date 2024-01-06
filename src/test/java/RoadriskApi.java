import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RoadriskApi {
    @Test
    public static void Test_Road_Risk_Api_With_correct_api_id() {
        String requestBody = "                   \n" +
                "\n" +
                "{ \n" +
                "  \"track\": [\n" +
                "    {\n" +
                "      \"lat\": 30.680439786468128,\n" +
                "      \"lon\": -88.81896972656251,\n" +
                "      \"dt\": 1602702000\n" +
                "    },\n" +
                "    {\n" +
                "      \"lat\": 30.56699087315334,\n" +
                "      \"lon\": -89.44519042968751,\n" +
                "      \"dt\": 1602702000\n" +
                "    }\n" +
                "  ]\n" +
                "}\n" +
                "                   \n" +
                "\n" +
                "                ";
        given().header("Content-type", "application/json")
                .and()
                .body(requestBody).queryParam("appid", "6bc320bf5e254f95a68cee6d3ee0a864").post("https://api.openweathermap.org/data/2.5/roadrisk").then().body("message", Matchers.contains("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
        ;
    }

}
