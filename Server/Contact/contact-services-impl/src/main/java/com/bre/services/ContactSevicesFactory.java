package com.bre.services;

import com.bre.services.impl.ContactServicesImpl;

public class ContactSevicesFactory {
	
	public static IContactServices getService() {
		return new ContactServicesImpl();
	}

}
