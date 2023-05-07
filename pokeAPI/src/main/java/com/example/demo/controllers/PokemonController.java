package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Pokemon;
import com.example.demo.services.PokemonServices;
import com.example.demo.utils.Utils;

@Controller
public class PokemonController {
    

    @Autowired
    PokemonServices pokemonServices;


//     @RequestMapping("/pokemon/lista/1")
//     public String allPokemons(Model model){


// ArrayList<Pokemon> pokemons = pokemonServices.getFirst10Pokemons();

// String next = Utils.next10(page);
//     model.addAttribute("next","/pokemon/lista/ " +  next);

// model.addAttribute("pokemons", pokemons);

// return "listapokemons";

//     }
    @RequestMapping("/pokemon/lista/{page}")
    public String allPokemons(Model model, @PathVariable("page") String page){

   
    ArrayList<Pokemon> pokemons = pokemonServices.getFirst10Pokemons(page);



String next = Utils.next10(page);


    model.addAttribute("pokemons", pokemons);
    model.addAttribute("next","/pokemon/lista/"+ next);
    return "listapokemons";

    }

//     @RequestMapping("/pokemon/lista/{limit}")
//     public String tenPokemons(Model model, @PathVariable("limit") String page){


// ArrayList<Pokemon> pokemons = pokemonServices.getNextPokemons(page);



// model.addAttribute("pokemons", pokemons);

// return "listapokemons";

//     }




}
