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

@Path("/v1/pettypes")
@Produces("application/json")
public class PetTypeResource {
	
	List<PetType> pettypes = new ArrayList<PetType>();
	
	public PetTypeResource() {
		PetType pettype1 = new PetType();
		pettype1.setPetTypeId(1);
		pettype1.setPetType("Dog");

		PetType pettype2 = new PetType();
		pettype2.setPetTypeId(2);
		pettype2.setPetType("Cat");

		PetType pettype3 = new PetType();
		pettype3.setPetTypeId(3);
		pettype3.setPetType("Bird");

		pettypes.add(pettype1);
		pettypes.add(pettype2);
		pettypes.add(pettype3);
	}

//	Add a pet type
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "PetType Added successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))) })
 
	@POST
	public Response addPet(@RequestBody (required = true) PetType pt) {
		pettypes.add(pt);
		return Response.ok(pt).build();
	}
	
//	View all the pet types
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))) })
	
	@GET
	public Response getPets() {		
		return Response.ok(pettypes).build();
	}

//	View one pet type by id
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet Type for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
			@APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })
	
	@GET
	@Path("{pettypeId}")
	public Response getPettype(@PathParam("pettypeId") int pettypeId) {
		if (pettypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (PetType pt : pettypes) {
				if (pt.getPetTypeId() == pettypeId) {
					
					pt.setPetTypeId(pt.getPetTypeId());
					pt.setPetType(pt.getPetType());
					
					return Response.ok(pt).build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
//	View one pet type by type
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet Type for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
			@APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })
	
	@GET
	@Path("{petType}")
	public Response getPettype(@PathParam("petType") String petType) {
		
		for (PetType pt : pettypes) {
			if (pt.getPetType() == petType) {
				
				pt.setPetTypeId(pt.getPetTypeId());
				pt.setPetType(pt.getPetType());
				
				return Response.ok(pt).build();
			}
        }
		
		return Response.status(Status.NOT_FOUND).build();
	}
	
//	Update a pet type
	@APIResponses(value = {
	        @APIResponse(responseCode = "200", description = "Pet Type Updated successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
			@APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })
	
	@PUT
	@Path("{pettypeId}")
	public Response updatePettype(@PathParam("pettypeId") int pettypeId,  @RequestBody PetType pettypeUpdate) {
		if (pettypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (PetType pt : pettypes) {
				if (pt.getPetTypeId() == pettypeId) {
					
					pettypes.remove(pt);
					pettypes.add(pettypeUpdate);
					
					return Response.ok(pt).build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
//	Delete a pet type
	@APIResponses(value = {
	        @APIResponse(responseCode = "200", description = "Pet Type Deleted successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
			@APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })
	
	@DELETE
	@Path("{pettypeId}")
	public Response deletePettype(@PathParam("pettypeId") int pettypeId) {
		if (pettypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			for (PetType pt : pettypes) {
				if (pt.getPetTypeId() == pettypeId) {
					
					pettypes.remove(pt);
					
					return Response.noContent().build();
				}
	        }
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
