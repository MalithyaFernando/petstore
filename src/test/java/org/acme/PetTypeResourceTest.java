package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetTypeResourceTest {

//	View pet types: Successful
	@Test
    public void testPettype() {
        given()
          .when().get("/v1/pettypes")
          .then()
             .statusCode(200);
    }
	
//	View pet type by id : Successful
//	@Test
//	public void testSearchPettypeById() {
//		given()
//        .when().get("/v1/pettypes/id/1")
//        .then()
//           .statusCode(404);
//	}
	
//	View pet type by id : Unsuccessful (When passed id is a negative)
	@Test
	public void testSearchPettypeByIdNegative() {
		given()
        .when().get("/v1/pettypes/id/-1")
        .then()
           .statusCode(404);
	}
	
//	View pet by type : Successful
//	@Test
//	public void testSearchPettypeByType() {
//		given()
//        .when().get("/v1/pettypes/type/Cat")
//        .then()
//           .statusCode(200);
//	}

//	Delete pet: Successful
//	@Test
//	public void testDeletePettype() {
//		given()
//        .when().delete("/v1/pettypes/1")
//        .then()
//           .statusCode(200);
//	}
}