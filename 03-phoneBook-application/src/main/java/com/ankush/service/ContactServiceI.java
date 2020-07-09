package com.ankush.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ankush.entity.ContactEntity;
import com.ankush.model.Contact;

@Service
public interface ContactServiceI {
	
	public boolean storeContact(ContactEntity contact);
	
	public List<Contact> getAllContact();
	
	public void deleteContact(Integer id);
	
	public Contact getContact(Integer id);
	
	public boolean updateContact(ContactEntity c);
	

}
