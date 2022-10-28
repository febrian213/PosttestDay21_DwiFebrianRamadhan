package com.juaracoding;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
public class TestCRUD {
    @Test
    public void testPost() {
        //
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp 6 2022");
        request.put("category", "API");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp 6 2022");
        request.put("category", "API");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://mern-backend-8881.herokuapp.com/products/62e20e16f0e24546b900e04e")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp 6 2022");
        request.put("category", "API");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/62e20e16f0e24546b900e04e")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDelete() {

        when()
                .delete("https://mern-backend-8881.herokuapp.com/products/62e20e16f0e24546b900e04e")
                .then()
                .statusCode(204)
                .log().all();

    }

    @Test
    public void apiKeyAuth() {
        given()
                .queryParam("api_key", "e4c66f5be087d70d2ba00f3c84a067a1")
                .when()
                .get("https://mern-backend-8881.herokuapp.com/products?language=en-US&page=1")
                .then().statusCode(200);
    }
}
