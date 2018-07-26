package com.wind.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.web.dao.TicketDao;
import com.wind.web.dto.BDto;
import com.wind.web.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	private TicketDao dao;
	
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket(Model model) {
		System.out.println("/buy_ticket");
		return "buy_ticket";
	}

	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
		System.out.println("/buy_ticket_card");
		System.out.println("/ticketDto ID" + ticketDto);
		System.out.println("/ticketDto Amount" + ticketDto);
		dao.buyTicket(ticketDto);
		
		model.addAttribute("content_view", ticketDto);
		return "buy_ticket_card";
	}
}
