package com.paf.electricgrid.billingmenagment;

public class billingmenagment {

public int billig_id;
	public int mc_id;
	public int user_acc_id;
	public float monthly_unit_usage;
	public int total_bill;
	public int billing_status;

	public int getBillig_id() {
		return billig_id;
	}

	public void setBillig_id(int billig_id) {
		this.billig_id = billig_id;
	}

	public int getMc_id() {
		return mc_id;
	}

	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}

	public int getUser_acc_id() {
		return user_acc_id;
	}

	public void setUser_acc_id(int user_acc_id) {
		this.user_acc_id = user_acc_id;
	}

	public float getMonthly_unit_usage() {
		return monthly_unit_usage;
	}

	public void setMonthly_unit_usage(float monthly_unit_usage) {
		this.monthly_unit_usage = monthly_unit_usage;
	}

	public int getTotal_bill() {
		return total_bill;
	}

	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}

	public int getBilling_status() {
		return billing_status;
	}

	public void setBilling_status(int billing_status) {
		this.billing_status = billing_status;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Meterconnection{" +
				"billig_id=" + billig_id +
				", mc_id=" + mc_id +
				", user_acc_id=" + user_acc_id +
				", monthly_unit_usage=" + monthly_unit_usage +
				", total_bill=" + total_bill +
				", billing_status=" + billing_status +
				'}';
	}
	
}
