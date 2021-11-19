package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetResourceTest {

//	View pets: Successful
	@Test
    public void testPetEndpoint() {
        given()
          .when().get("/v1/pets")
          .then()
             .statusCode(200);
    }
	
//	View pet by id : Successful
//	@Test
//	public void testSearchPetById() {
//		given()
//        .when().get("/v1/pets/id/3")
//        .then()
//           .statusCode(200);
//	}
	
//	View pet by id : Unsuccessful (When passed id is a negative)
	@Test
	public void testSearchPetByIdNegative() {
		given()
        .when().get("/v1/pets/id/-10")
        .then()
           .statusCode(404);
	}
	
//	View pet by name : Successful
//	@Test
//	public void testSearchPetByName() {
//		given()
//        .when().get("/v1/pets/name/Sudda")
//        .then()
//           .statusCode(200);
//	}
	
//	View pet by type : Successful
//	@Test
//	public void testSearchPetByType() {
//		given()
//        .when().get("/v1/pets/type/Dog")
//        .then()
//           .statusCode(200);
//	}

//	Delete pet: Successful
//	@Test
//	public void testDeletePet() {
//		given()
//        .when().delete("/v1/pets/1")
//        .then()
//           .statusCode(500);
//	}
}