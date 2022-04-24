package com.paf.electricgrid.meter_connection;

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


@Path("/meter_connections")

public class Meter_connectionResource {
	
	Meter_connectionRepository mc1 = new Meter_connectionRepository();
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Meter_connection> getAllMeterconnections() {
		return mc1.getAllMeterconnections();
    }
	
	
	@POST
	@Path("/meterconnection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Meter_connection createMeterconnection(Meter_connection mc) {
		return mc1. createMeterconnection(mc);
	}
	
	@GET
	@Path("/meterconnection/{mc_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMeterconnection(@PathParam("mc_id") String mc_id) {
		Meter_connection res = new Meter_connection();
	res = mc1.getmeterconnectionid(Integer.parseInt(mc_id));
	Gson test = new Gson();
	String jsonObject = test.toJson(res);
	return jsonObject;
	}
	
	@DELETE
	@Path("/deleteMeterconnection/{mc_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMeterconnection(@PathParam("mc_id") int mc_id) {
		return mc1.deleteMeterconnection(mc_id);
	}
	
	
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	public String updateMeterconnection(Meter_connection mc) 
	{ 
		return mc1.updateMeterconnection(mc);
	}
	
	
	@GET
	@Path("/read")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
	return mc1.readMeterConnections();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Meter_connection> getAllMeterconnection(){
		return mc1.getAllMeterconnections();
	}

}