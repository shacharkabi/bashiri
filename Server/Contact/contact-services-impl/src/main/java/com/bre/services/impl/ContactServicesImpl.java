package com.bre.services.impl;

import java.util.List;

import com.bre.services.IContactServices;
import com.bre.services.lib.Contact;
import com.bre.services.lib.SearchContact;

public class ContactServicesImpl implements IContactServices {

	@Override
	public void createContact(Contact contact) {
		System.out.println("Contact created");
	}

	@Override
	public List<Contact> searchContact(SearchContact searcContact) {
		System.out.println("Search for contact");
		return null;
	}

}
