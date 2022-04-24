package com.paf.electricgrid.meter_connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;  
import java.sql.*;

public class Meter_connectionRepository {
	
	//A common method to connect to the DB
	public Connection getconnection() {
	
	Connection con = null;
	//Provide the correct details: DBServer/DBName, username, password
	String url = "Jdbc:mysql://localhost:3306/";
	String username = "root";
	String password = "";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		
	}catch (Exception e) {
		System.out.println(e);
	}
	
	System.out.println("success");
	return con;

}
	
	List<Meter_connection> meter_connections;
	
	public Meter_connectionRepository() {
		
		
		String url = "Jdbc:mysql://localhost:3306/electric_grid";
		String username = "root";
		String password = "";
		Connection con = getconnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		meter_connections = new ArrayList<>();
		
		Meter_connection mc = Meter_connection();
		
		mc.setMc_id(1);
		mc.setMc_type("industrial");
		mc.setMc_phase_type("three-phase");
		mc.setMc_capacity(5000);
		mc.setMc_monthly_unit_usage(78);
		mc.setMc_validity_status("active");
		mc.setMc_power_distribution_status("on");
		mc.setUser_acc_id(7896547);
		mc.setBilling_id(8903456);
		meter_connections.add(mc);
	}
	
	public List<Meter_connection> getAllMeterconnections(){
		
		return meter_connections;
	}
	
	public Meter_connection createProject(Meter_connection mc) {
		String output = "";
		
		// create a prepared statement
		String insertSql = "INSERT INTO `meter_connection`(`mc_id`, `mc_type`, `mc_phase_type`, `mc_capacity`, `mc_monthly_unit_usage`, `mc_validity_status`, `mc_power_distribution_status`, `user_acc_id`, `billing_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		Connection con = getconnection();
		try {
			
			PreparedStatement st = con.prepareStatement(insertSql);
			
			// binding values
			st.setInt(1, mc.mc_id);
			st.setString(2, mc.mc_type);
			st.setString(3, mc.mc_phase_type);
			st.setFloat(4, mc.mc_capacity);
			st.setFloat(5, mc.mc_monthly_unit_usage);
			st.setString(6, mc.mc_validity_status);
			st.setString(7, mc.mc_power_distribution_status);
			st.setInt(8, mc.user_acc_id);
			st.setInt(9, mc.billing_id);
			
			// execute the statement
			st.executeUpdate();
			con.close();
			
			output = "success";
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		meter_connections.add(mc);
		System.out.println(meter_connections);
		
		return (mc);
	}

	
	
	public String readMeterConnections() {
		String output = "";
		
		try {
			//connect to database
			Connection con = getconnection();
			
			if (con == null)
			{return "Error while connecting to the database for reading."; }
			
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Meter Connection Id</th><th>Mc Type</th><th>Mc Phase Type</th><th>Mc Capacity</th><th></th><th>Mc Monthly Units Usage</th><th>Mc Validity Status</th><th>Mc Power Distribution Status</th><th>User Acc Id</th><th>Billing Id</th>" +
			"<th>Update</th><th>Remove</th></tr>";
			String query = "SELECT * FROM `meter_connections`";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next())
			{
				String mc_id = Integer.toString(rs.getInt("mc_id"));
				String mc_type = rs.getString("`mc_type");
				String mc_phase_type = rs.getString("mc_phase_type`");
				String mc_capacity = Float.toString(rs.getFloat("mc_capacity"));
				String mc_monthly_unit_usage = Float.toString(rs.getFloat("mc_monthly_unit_usage"));
				String mc_validity_status = rs.getString("mc_validity_status");
				String mc_power_distribution_status = rs.getString("mc_power_distribution_status");
				String user_acc_id = Integer.toString(rs.getInt("user_acc_id"));
				String billing_id = Integer.toString(rs.getInt("billing_id"));
				
				// Add into the html table
				output += "<tr><td>" + mc_id + "</td>";
				output += "<td>" + mc_type + "</td>";
				output += "<td>" + mc_phase_type + "</td>";
				output += "<td>" + mc_capacity + "</td>";
				output += "<td>" + mc_monthly_unit_usage + "</td>";
				output += "<td>" + mc_validity_status + "</td>";
				output += "<td>" + mc_power_distribution_status + "</td>";
				output += "<td>" + user_acc_id + "</td>";
				output += "<td>" + billing_id + "</td>";
				
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
				+ "<td><form method='post' action='items.jsp'>"
				+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				+ "<input name='itemID' type='hidden' value='" +mc_id  + "'>" + "</form></td></tr>";
			}
			
			//close the db connection
			con.close();
			
			
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e){
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
	public Meter_connection getmeterconnectionid(int mc_id) {
		String getsql = "SELECT * FROM `meter_connection` WHERE `mc_id` = '"+mc_id+"' ";
		 Meter_connection pr = new  Meter_connection();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet mc = st.executeQuery(getsql);
			
			while(mc.next()) {
				
				pr.setMc_id(mc.getInt(1));
				pr.setMc_type(mc.getString(2));
				pr.setMc_phase_type(mc.getString(3));
				pr.setMc_capacity(mc.getFloat(7));
				pr.setMc_monthly_unit_usage(mc.getFloat(7));
				pr.setMc_validity_status(mc.getString(6));
				pr.setMc_power_distribution_status(mc.getString(4));
				pr.setUser_acc_id(mc.getInt(9));
				pr.setBilling_id(mc.getInt(10));
				
			}
			
			//con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	
	public String deleteMeterconnection(int mc_id) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String deleteMeterconnection = "DELETE FROM meter_connection WHERE mc_id = '"+mc_id+"'";
			PreparedStatement ps = con.prepareStatement(deleteMeterconnection);
			ps.execute();
			
			output = "Delete Successful";
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
		
	public String updateMeterconnection(Meter_connection meter_connection) {
		String output = "";
		
		try {
			Connection con = getconnection();
			
			String updateMeterconnection  = "UPDATE `meter_connection` SET `mc_id`='"+meter_connection.getMc_id()+"',mc_type='"+meter_connection.getMc_type()+"',mc_phase_type='"+meter_connection.getMc_phase_type()+"',mc_capacity='"+meter_connection.getMc_capacity()+"',mc_monthly_unit_usage='"+meter_connection.getMc_monthly_unit_usage()+"',mc_validity_status='"+meter_connection.getMc_validity_status()+"',mc_power_distribution_status='"+meter_connection.getMc_power_distribution_status()+"',user_acc_id='"+meter_connection.getUser_acc_id()+"',billing_id='"+meter_connection.getBilling_id()+"' WHERE mc_id='"+meter_connection.getMc_id()+"'";
			PreparedStatement st = con.prepareStatement(updateMeterconnection);

			st.executeUpdate();
			output = "Updated Successful";
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return output;

	}
}

