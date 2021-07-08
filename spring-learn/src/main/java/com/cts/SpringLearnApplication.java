package com.cts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@SpringBootApplication
public class SpringLearnApplication{

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws ParseException{
		SpringApplication.run(SpringLearnApplication.class, args);
	    //displayDate();
		displayCountry();
		//displayCountries();
	}
	public static void displayDate() throws ParseException
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("02/07/2021");
		LOGGER.debug("Formated date "+date);
		System.out.println(date);
		LOGGER.info("END");
		
	}
	
	public static void displayCountry()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
	}
	
	public static void displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Object countryList = context.getBean("countryList");
        LOGGER.debug("Country : {}", countryList.toString());
	}

}
