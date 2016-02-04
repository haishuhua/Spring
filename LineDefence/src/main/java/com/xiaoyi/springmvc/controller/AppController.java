package com.xiaoyi.springmvc.controller;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.xiaoyi.springmvc.model.Game;
import com.xiaoyi.springmvc.model.Player;
import com.xiaoyi.springmvc.service.GameService;
import com.xiaoyi.springmvc.service.PlayerService;
 
@Controller
@RequestMapping("/")
public class AppController {
 
    
    @Autowired
    GameService gameservice;
     
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    PlayerService playerservice;
     
    @RequestMapping(value = {"/404" }, method = RequestMethod.GET)
    public String NotFoudPage(ModelMap model) {
    	
        return "404";
    }
    
    @RequestMapping(value = {"/","/listGames" }, method = RequestMethod.GET)
    public String listAllScore(ModelMap model) {
    	
        List<Game> games = gameservice.findAllGames();
        int win = gameservice.countWin();
        model.addAttribute("games", games);
        model.addAttribute("win", win);
        return "listGames";
    }
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/newGame" }, method = RequestMethod.GET)
    public String newGame(ModelMap model) {
        Game game = new Game();
        List<Player> players = playerservice.findAllPlayers();
        List<String> playersNames = new ArrayList<String>();
        for (Player temp : players) {
        	playersNames.add(temp.getFirstname() +" "+ temp.getLastname());
        	 
		}
        Collections.sort(playersNames);
        model.addAttribute("playersNames", playersNames);
        model.addAttribute("game", game);
        model.addAttribute("edit", false);
        return "newGame";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @SuppressWarnings("deprecation")
	@RequestMapping(value = { "/newGame" }, method = RequestMethod.POST)
    public String saveGame(HttpServletRequest request,
            HttpServletResponse response,
            ModelMap model) throws ParseException {
    	 Game game = new Game();
    	 String teamA1=request.getParameter("TeamA1");
    	 String teamA2=request.getParameter("TeamA2");
    	 String teamB1=request.getParameter("TeamB1");
    	 String teamB2=request.getParameter("TeamB2");
    	 java.util.Enumeration enu = request.getParameterNames();
    	          while(enu.hasMoreElements()){
    	              String paramName = (String)enu.nextElement();
    	              System.out.println(paramName);
    	          }
    	 DateFormat  formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
    	 String testDate="01/01/1990";
    	 Date playDate  = formatter.parse(testDate);
    	
    	
		try {
			playDate = formatter.parse(request.getParameter("PlayDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
    	 String score=request.getParameter("Score");
    	 game.setTeamA1(teamA1);
    	 game.setTeamA2(teamA2);
    	 game.setTeamB1(teamB1);
    	 game.setTeamB2(teamB2);
    	 game.setPlayDate(playDate);
    	 game.setScore(score);
       
    	 System.out.println(playDate+"   testDate");
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
       
         
        gameservice.saveGame(game);
        model.addAttribute("success","Success registered successfully");
        return "success";
    }
    
 
}