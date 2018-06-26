package com.bre.services;

import java.util.List;

import com.bre.services.lib.Contact;
import com.bre.services.lib.SearchContact;

public interface IContactServices {
	
	void createContact(Contact contact);
	
	List<Contact> searchContact(SearchContact searcContact);

}
