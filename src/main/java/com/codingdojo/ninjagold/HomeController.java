package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	int gold = 0;
	ArrayList activity = new ArrayList();
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("gold", gold);
		return "index.jsp";
	}
	
	@PostMapping("process_money")
	public String process(HttpSession session, @RequestParam("building") String place, RedirectAttributes redirecAttributes) {
		Random rand = new Random();
		if(place.equals("farm")) {
			int goldAmount = rand.nextInt(11) + 10;
			gold+=goldAmount;
			session.setAttribute("gold", gold);
			activity.add("Earned " + goldAmount + " golds from the " + place + "!");
			session.setAttribute("activity", activity);
		}
		
		if(place.equals("cave")) {
			int goldAmount = rand.nextInt(6) + 5;
			gold+=goldAmount;
			session.setAttribute("gold", gold);
			activity.add("Earned " + goldAmount + " golds from the " + place + "!");
			session.setAttribute("activity", activity);
		}
		
		if(place.equals("house")) {
			int goldAmount = rand.nextInt(4) + 2;
			gold+=goldAmount;
			session.setAttribute("gold", gold);
			activity.add("Earned " + goldAmount + " golds from the " + place + "!");
			session.setAttribute("activity", activity);
		}
		
		if(place.equals("casino")) {
			int goldAmount = rand.nextInt(101) + (-50);
			gold+=goldAmount;
			session.setAttribute("gold", gold);
			if(goldAmount < 0) {
				activity.add("Lost " + goldAmount*-1 + " golds from the " + place + "!");
				session.setAttribute("activity", activity);
			} else {
				activity.add("Earned " + goldAmount + " golds from the " + place + "!");
				session.setAttribute("activity", activity);
			}
		}
		
		return "redirect:/";
	}
	
	
@PostMapping("clear")
	public String clearGold(HttpSession session, RedirectAttributes redirecAttributes) {
		gold = 0;
		activity.clear();
		return "redirect:/";
}
	
	
	
}
