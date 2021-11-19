package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {
	
	List<Pet> pets = new ArrayList<Pet>();

	public PetResource() {
		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(3);
		pet1.setPetName("Boola");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(4);
		pet2.setPetName("Sudda");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(2);
		pet3.setPetName("Peththappu");
		pet3.setPetType("Bird");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet3);
	}
	
//	Add a pet
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet Added successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
    
	@POST
	public Response addPet(@RequestBody (required = true) Pet pet) {
		pets.add(pet);
		return Response.ok(pet).build();
	}
	
//	View all the pets
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	
	@GET
	public Response getPets() {		
		return Response.ok(pets).build();
	}

//	View one pet by id
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	
	@GET
	@Path("{petId}")
	public Response getPetbyId(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (Pet pet : pets) {
				if (pet.getPetId() == petId) {
					
					pet.setPetId(pet.getPetId());
					pet.setPetAge(pet.getPetAge());
					pet.setPetName(pet.getPetName());
					pet.setPetType(pet.getPetType());
					
					return Response.ok(pet).build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
//	View one pet by name
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	
	@GET
	@Path("{petName}")
	public Response getPetbyName(@PathParam("petName") String petName) {
		
		for (Pet pet : pets) {
			if (pet.getPetName() == petName) {
				
				pet.setPetId(pet.getPetId());
				pet.setPetAge(pet.getPetAge());
				pet.setPetName(pet.getPetName());
				pet.setPetType(pet.getPetType());
				
				return Response.ok(pet).build();
			}
        }
		
		return Response.status(Status.NOT_FOUND).build();
	}
	
//	View one pet by type
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	
	@GET
	@Path("{petType}")
	public Response getPetbyType(@PathParam("petType") String petType) {
		
		for (Pet pet : pets) {
			if (pet.getPetType() == petType) {
				
				pet.setPetId(pet.getPetId());
				pet.setPetAge(pet.getPetAge());
				pet.setPetName(pet.getPetName());
				pet.setPetType(pet.getPetType());
				
				return Response.ok(pet).build();
			}
        }
		
		return Response.status(Status.NOT_FOUND).build();
	}
	
//	Update a pet
	@APIResponses(value = {
	        @APIResponse(responseCode = "200", description = "Pet Updated successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	
	@PUT
	@Path("{petId}")
	public Response updatePet(@PathParam("petId") int petId, @RequestBody Pet petUpdate) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (Pet pet : pets) {
				if (pet.getPetId() == petId) {
					
					pets.remove(pet);
			    	pets.add(petUpdate);
					
					return Response.ok(pet).build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
//	Delete a pet
	@APIResponses(value = {
	        @APIResponse(responseCode = "200", description = "Pet Deleted successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	
	@DELETE
	@Path("{petId}")
	public Response deletePet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (Pet pet : pets) {
				if (pet.getPetId() == petId) {
					
					pets.remove(pet);
					
					return Response.noContent().build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
