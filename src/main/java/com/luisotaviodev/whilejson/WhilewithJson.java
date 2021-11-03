package com.luisotaviodev.whilejson;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ch.qos.logback.core.pattern.parser.Parser;

public class WhilewithJson {

public static void main(String[] args)  throws FileNotFoundException, IOException, ParseException {
	

	JSONParser jsonzinho = new JSONParser();
	
    FileReader obj = new FileReader("./src/main/java/teste2.json");
    
    JSONObject json = (JSONObject) jsonzinho.parse(obj);
    
    
   String nome = (String) json.get("Nome");
   String sobrenome = (String) json.get("Sobrenome");
   String idade = (String) json.get("Idade");
   
   
   System.out.println("Nome:" + nome);
   System.out.println("Sobrenome:" + sobrenome);
   System.out.println("Idade:" + idade);
   
   
   
   JSONArray hobbies = (JSONArray) json.get("Hobbies");
   Iterator i = hobbies.iterator();

   System.out.println("Hobbies");
   while (i.hasNext()) {
	   
	   System.out.println("   " + i.next());
   }
   
  // Adicionando JSONObject Passo 3 da atividade proposta
   
  
    json.put("nome", "Luis Otávio");
   json.put("Sobrenome","Batista" );
   json.put("idade", "30");
   
   System.out.println(json);
   
   System.out.println("Nome:" + nome);
}


}