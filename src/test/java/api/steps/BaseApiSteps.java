package api.steps;

import api.models.args.result.Result;
import utils.EnvProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.steps.StatusCodeSteps.checkStatusCode;

public class BaseApiSteps {
    public static Result performAuthorizedRequest(Object requestObject) {
        Response response = RestAssured.given()
                .auth().preemptive().basic(EnvProperties.getApiLogin(), EnvProperties.getApiToken())
                .contentType(ContentType.JSON)
                .body(requestObject)
                .when()
                .post(EnvProperties.getApiEndpoint());
        response.prettyPrint();
        checkStatusCode(response, 200, "Request Status Code");
        return response.as(Result.class);
    }
}
