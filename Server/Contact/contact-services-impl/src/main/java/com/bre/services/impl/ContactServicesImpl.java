package com.bre.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bre.services.IContactServices;
import com.bre.services.lib.Contact;
import com.bre.services.lib.SearchContact;

public class ContactServicesImpl implements IContactServices {

	private static Map<UUID,Contact> contactMemory = new HashMap<>();

	static {
		Contact con1 = new Contact();
		con1.setFirstName("ShacharImpl");
		con1.setLastName("Kabi");
		con1.setId(UUID.fromString("62bc5ee9-2b5a-4ecd-a22d-e2afd59f4ec9"));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1983);
		con1.setBirthDate(cal);
		contactMemory.put(con1.getId(), con1);
	}

	@Override
	public void createContact(Contact contact) {
		contactMemory.put(contact.getId(), contact);
	}

	@Override
	public List<Contact> searchContact(SearchContact searcContact) {
		System.out.println("Search for contact");
		List<Contact> returnList = new ArrayList<>();
		if(contactMemory.containsKey(searcContact.getId())) {
			Contact con1 = contactMemory.get(searcContact.getId());
			returnList.add(con1);
		}
		return returnList;
	}

}
