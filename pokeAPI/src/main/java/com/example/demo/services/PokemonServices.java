package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Pokemon;

@Service
public class PokemonServices {
    
@Autowired
RestTemplate restTemplate;

private final String URL = "https://pokeapi.co/api/v2/pokemon/";
private final int LIMIT = 10;


// public ArrayList<Pokemon> getAllPokemons(){

//     ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
// int inicio = 1;
//     for (int i = 0; i < LIMIT; i++) {
        
//         Pokemon pokemon = restTemplate.getForObject(URL + (inicio+i), Pokemon.class );
//         lista.add(pokemon);
//     }
//     return lista;




// }

public ArrayList<Pokemon> getFirst10Pokemons(String page){
    ArrayList<Pokemon> lista = new ArrayList<Pokemon>();




int inicio = 1;
int diezAnteriores = 0;
int next = 0;

int paginaEntero = Integer.parseInt(page);
next = paginaEntero*10;
if (paginaEntero == 1) {
    
 diezAnteriores = 0;


}if (paginaEntero > 1) {
    diezAnteriores = (paginaEntero-1)*10;
}





for (int i = diezAnteriores; i < next ; i++) {
        
        Pokemon pokemon = restTemplate.getForObject(URL + (inicio+i), Pokemon.class );
        lista.add(pokemon);
    }
    return lista;


}

// public ArrayList<Pokemon> getNextPokemons(String pagina){

//     ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
// int inicio = 1;



// int paginaEntero = Integer.parseInt(pagina);




// int next = (Integer.parseInt(pagina));
// int diezAnteriores;

// if (paginaEntero == 1) {
//     diezAnteriores = 0;
// }else diezAnteriores = (Integer.parseInt(pagina)-1)*10;






// for (int i = diezAnteriores; i < next ; i++) {
        
//         Pokemon pokemon = restTemplate.getForObject(URL + (inicio+i), Pokemon.class );
//         lista.add(pokemon);
//     }
//     return lista;




// }





}
