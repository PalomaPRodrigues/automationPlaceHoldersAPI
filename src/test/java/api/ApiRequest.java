package api;

import static io.restassured.RestAssured.given;

public class ApiRequest extends ApiUtils implements ApiVerbos {
    @Override
    public void GET() {
        response = given()
                .request().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .get(uri);
        super.log("GET");
    }

    @Override
    public void POST() {
        response = given()
                .request().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body.toString())
                .post(uri);

        super.log("POST");
    }

    @Override
    public void PUT() {
        response = given()
                .request().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body.toString())
                .put(uri);

        super.log("PUT");

    }

    @Override
    public void PATCH() {
        response = given()
                .request().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body.toString())
                .patch(uri);

        super.log("PATCH");
    }

    @Override
    public void DELETE() {
        response = given()
                .request().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .delete(uri);

        super.log("DELETE");

    }
}
