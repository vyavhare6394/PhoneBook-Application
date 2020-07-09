package com.ankush.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankush.entity.ContactEntity;
import com.ankush.model.Contact;
import com.ankush.repository.ContactRepository;
import com.ankush.service.ContactServiceI;

@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepository repo;
	
	
	@Override
	public boolean storeContact(ContactEntity contact) {
		
		
				ContactEntity save = repo.save(contact);
				
		return save.getId()!=null;
	}

	
	
	@Override
	public List<Contact> getAllContact() {

List<Contact> contact=new ArrayList<>();	


						List<ContactEntity> findAll = repo.findAll();

						findAll.forEach(entity ->{
							
							Contact cn=new Contact();
							
							BeanUtils.copyProperties(entity, cn);
							
							contact.add(cn);
							
						});
						
		
		return contact;
	}



	@Override
	public void deleteContact(Integer id) {
		
				repo.deleteById(id);
		
		
	}



	@Override
	public Contact getContact(Integer id) {
		
				
					Optional<ContactEntity> findById = repo.findById(id);
					
					if(findById.isPresent())
					{
						ContactEntity entity=findById.get();
						
						Contact contact=new Contact();
						
						BeanUtils.copyProperties(entity, contact);
						
						return contact;
						
						
					}
		
		return null;
	}



	@Override
	public boolean updateContact(ContactEntity c) {
		
		
					ContactEntity save = repo.save(c);
		
		return save.getId()!=null;
	}

}
