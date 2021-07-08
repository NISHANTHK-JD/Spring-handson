package com.cts.spring_learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cts.Country;
import com.cts.spring_learn.service.CountryService;
import com.cts.spring_learn.service.exception.CountryNotFoundException;

@RequestMapping("/countries")
@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/country",method = RequestMethod.GET)
	public Country getCountryIndia()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country india = (Country) context.getBean("in");
		LOGGER.info("End");
		return india;
	}
	
	@GetMapping
	public List<Country> getAllCountries()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		LOGGER.info("End");
		return countryList;
	}
	
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException{
		LOGGER.info("Start");
		LOGGER.info("End");
		return countryService.findCountryById(code);
	}
	
	@PostMapping
	public Country addCountry(@RequestBody Country country)
	{
		LOGGER.info("inside add country");
		countryService.addCountry(country);
		return country;
	}
	
	/*@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country)
	{
		// Create validator factory

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean

		Set<ConstraintViolation<Country>> violations = validator.validate(country);

		List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String

		for (ConstraintViolation<Country> violation : violations) {

		errors.add(violation.getMessage());

		}

		// Throw exception so that the user of this web service receives appropriate error message

		if (violations.size() > 0) {

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

		}
	}*/
	
}
