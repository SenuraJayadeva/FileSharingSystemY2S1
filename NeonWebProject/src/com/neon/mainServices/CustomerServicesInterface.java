package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.Customer;

public interface CustomerServicesInterface {

	public ArrayList<Customer> getCustomerList();

	public ArrayList<Customer> getCustomerDetails(String userEmail);

}
