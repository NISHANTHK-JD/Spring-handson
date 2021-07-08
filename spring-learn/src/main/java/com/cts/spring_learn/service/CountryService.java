package com.cts.spring_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cts.Country;
import com.cts.spring_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
	
	
	
	public Country findCountryById(String id) throws CountryNotFoundException
	{
		for(Country country: countryList) 
		{
			if(country.getCode().equalsIgnoreCase(id))
			{
				return country;
			}
		}
		throw new CountryNotFoundException("Country with " + id + " not found!!!");

	}
	public void addCountry(Country country)
	{
		countryList.add(country);
	}
}
