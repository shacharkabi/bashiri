package com.bre.mapper;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import io.swagger.model.Contact;

public class ContactMapper {
	
	public  static com.bre.services.lib.Contact map(Contact contact){
		com.bre.services.lib.Contact mappedContact = new com.bre.services.lib.Contact();
		mappedContact.setId(contact.getId());
		mappedContact.setFirstName(contact.getFirstName());
		mappedContact.setLastName(contact.getLastName());
		mappedContact.setBirthDate(stringToCalendar(contact.getBirthDate()));
		return mappedContact;
	}
	
	public static Contact  map(com.bre.services.lib.Contact contact){
		Contact mappedContact = new Contact();
		mappedContact.setId(contact.getId());
		mappedContact.setFirstName(contact.getFirstName());
		mappedContact.setLastName(contact.getLastName());
		mappedContact.setBirthDate(calendarToString(contact.getBirthDate()));
		return mappedContact;
	}
	
	public static List<Contact>  map(List<com.bre.services.lib.Contact> contactList){
		List<Contact> mappedList = new ArrayList<Contact>();
		for(com.bre.services.lib.Contact con:contactList) {
			mappedList.add(map(con));
		}
		return mappedList;
	}
	
	private static Calendar stringToCalendar(String date) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date d = null;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(d);
        return cal;
	}
	
	private static String calendarToString(Calendar cal) {
		Date date = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		String str;
        str = format.format(date);
        return str;
	}

}
