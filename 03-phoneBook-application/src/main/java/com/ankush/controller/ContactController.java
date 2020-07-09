package com.ankush.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ankush.entity.ContactEntity;
import com.ankush.model.Contact;
import com.ankush.service.ContactServiceI;

@Controller

public class ContactController {
	
	@Autowired
	private ContactServiceI service;
	
	
	
	@GetMapping(value= {"/","/contactForm"})
	public String loadForm(Model theModel)
	{
		Contact contact=new Contact();
		
		theModel.addAttribute("contact", contact);
		
		
		return "contact";
	}
	
	@PostMapping("/contactSubmit")
	public String sbmtButton(@Valid @ModelAttribute("contact") ContactEntity contact,BindingResult result,RedirectAttributes ra)
	{			
		String msg="";
		
		
		if(result.hasErrors())
		{
			
			return"contact";
		}
		else
		{
				boolean saveIs = service.storeContact(contact);		
				
			
						if(saveIs)
						{
							msg="Successfully save....!";
						}
						else
						{
							msg="Not Save...!";
						}
		ra.addFlashAttribute("msg",msg);
						
		
		
		return"redirect:/getContactForm";
		}
		
	}
	//double posting problem solve
	@GetMapping("/getContactForm")
	public String removeduplicate(Model theModel)
	{
			
		Contact contact=new Contact();
		
		theModel.addAttribute("contact", contact);
		
		return"contact";
	}
	
	
	@GetMapping("/viewContactDetails")
	public String viewContact(Model theModel)
	{
		
					List<Contact> allContact = service.getAllContact();
		
					theModel.addAttribute("co", allContact);
		
		return "view-contact";
	}
	
	
	@GetMapping("/delete")
	public String delteContact(@RequestParam("customerId") int theId)
	{
		
							service.deleteContact(theId);
		
		
		return "redirect:/viewContactDetails";
	}
	
	
	
						@GetMapping("/editContact")
					public String editContact(@RequestParam("customerId")Integer id,Model theModel)
					{
							Contact contact = service.getContact(id);
							
							theModel.addAttribute("contact", contact);
							
						
						return "contact";
					}
	
	
	
	
	  @PostMapping("/update") public String updateContact(@ModelAttribute
	  ContactEntity c,Model theModel) {
	  
	  boolean updateContact = service.updateContact(c);
	  
	  if(updateContact) {
	  
	  return "viewContactDetails";
	  
	  }
	  
	  return null; }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
