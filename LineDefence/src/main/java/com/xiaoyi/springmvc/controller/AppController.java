package com.xiaoyi.springmvc.controller;
 
import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoyi.springmvc.model.Game;
import com.xiaoyi.springmvc.service.GameService;
 
@Controller
@RequestMapping("/")
public class AppController {
 
    
    @Autowired
    GameService gameservice;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
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
        model.addAttribute("game", game);
        model.addAttribute("edit", false);
        return "newGame";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/newGame" }, method = RequestMethod.POST)
    public String saveGame(@Valid Game game, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "newGame";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
       
         
        gameservice.saveGame(game);
 
        model.addAttribute("success","success registered successfully");
        return "success";
    }
    
 
}