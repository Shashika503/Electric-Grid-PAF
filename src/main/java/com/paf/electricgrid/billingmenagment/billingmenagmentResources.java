package com.electricgrid.billingmenegement;

import com.electricgrid.billingmenegement.Billingmenegement;
import com.electricgrid.billingmenegement.BillingmenegementRepository;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/billing_menegements")

public class BillingmenegementResource {
	
	BillingmenegementRepository bm1 = new BillingmenegementRepository();
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Billingmenegement> getAllBillingmenegements() {
		return bm1.getAllBillingmenagements();
    }
	
	
	@POST
	@Path("billingmenegement")
	@Consumes(MediaType.APPLICATION_JSON)
	public Billingmenegement createBillingmenegement(Billingmenegement bm) {
		return bm1.createBillingmenagement(bm);
	}
	
	@GET
	@Path("billing-menegement/{billing_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBillingmenegement(@PathParam("billing_id") String billing_id) {
		Billingmenegement res = new Billingmenegement();
	res = bm1.getgetbillingmenegementid(Integer.parseInt(billing_id));
	Gson test = new Gson();
	String jsonObject = test.toJson(res);
	return jsonObject;
	}
	
	@DELETE
	@Path("deleteBillingmenegement/{billing_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteBillingmenegement(@PathParam("billing_id") int billing_id) {
		return bm1.deleteBillingmenagement(billing_id);
	}
	
	
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	public String updateBillingmenegement(Billingmenegement bm) 
	{ 
		return bm1.updateBillingmenagement(bm);
	}
	
	
	@GET
	@Path("/read")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
	return bm1.readBillingMenegements();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Billingmenegement> getAllBillingmenegement(){
		return bm1.getAllBillingmenagements();
	}
	
}
