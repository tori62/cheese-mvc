package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "cheese")  // makes this /cheese for everything
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    //request form at /cheese
    @RequestMapping(value="" , method = RequestMethod.GET)
    // modifies index method by adding parameter.  Model is a "type" that needs to be imported from spring.
    public String index(Model model) {
        // pass information to the view.  pass a attribute called title  = My Cheeses is the value
        //pass information to the template name = cheeses and value is array list cheeses
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value= "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }
    @RequestMapping(value= "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese cheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.put(cheeseName, cheeseDescription);
        // redirect to /cheese
        return "redirect:";

    }
    @RequestMapping (value= "remove", method = RequestMethod.GET)
        public String showRemoveForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses.keySet());
        return "cheese/remove";
    }

    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String processRemoveForm(@RequestParam ArrayList<String> cheeses) {
        for (String aCheese : cheeses) {
            cheeses.remove(aCheese);
        }
            return "redirect:";
    }

    // use part of the URL to pass info
    @RequestMapping (value = "edit/{cheeseId}")
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        // static methods do not need an instence
        Cheese c = CheeseData.getById(cheeseId);
        model.addAttribute("cheese", c);
        return "edit";

    }

    @RequestMapping (value="edit", method=RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description) {

    }

}

