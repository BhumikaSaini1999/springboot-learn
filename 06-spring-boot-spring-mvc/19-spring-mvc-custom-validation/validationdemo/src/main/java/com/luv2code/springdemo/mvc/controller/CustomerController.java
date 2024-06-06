package com.luv2code.springdemo.mvc.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springdemo.mvc.entity.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	// pre process every String form data
	// this method called for every web request coming into our controller
	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespaces
	// resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// true means trim empty string to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("Last name: |"+theCustomer.getLastName()+"|");
		System.out.println("Binding results: "+theBindingResult.toString());
		
		if(theBindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}
}
