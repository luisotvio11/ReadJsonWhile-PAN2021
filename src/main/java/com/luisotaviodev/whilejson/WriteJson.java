package com.luisotaviodev.whilejson;



import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class WriteJson
{
    @SuppressWarnings("unchecked") // notação que impede o compilador de emitir algumas advertências
    public static void main( String[] args ) // nome da classe ReadJSON
    {
    	// Primeiro Employee
    	JSONObject employeeDetails = new JSONObject(); // Instanciando um JSONObject de nome employeeDetails
		employeeDetails.put("firstName:", "Antonio"); // Adicionando a chave FirstName e o valor Antonio com o método put
		employeeDetails.put("lastName", "Cezar"); // Adicionando a chave LastName e o valor Cezar com o método put
		employeeDetails.put("email", "antoniocezar@email.com"); // Adicionando a chave email e o valor antoniocezar@email.com
		
		JSONObject employeeObject = new JSONObject(); // Instanciando um JSONObject de nome employeeObject
		employeeObject.put("employee", employeeDetails); //adicionando o JSONObject employeedDetails1 ao JSONObject employeeObject
         
        //Second Employee
		
        JSONObject employeeDetails2 = new JSONObject();//Instanciando um JSONObject de nome employeeDetails2
        employeeDetails2.put("firstName", "Carlos"); // Adicionando a chave FirstName e o valor Carlos com o método put
        employeeDetails2.put("lastName", "Jose");// Adicionando a chave FirstName e o valor Carlos com o método put
        employeeDetails2.put("email", "carlosjose@email.com");// Adicionando a chave email e o valor Carlos com o método put
         
        JSONObject employeeObject2 = new JSONObject(); // Instanciando um JSONOBject de nome employeeObject2
        employeeObject2.put("employee", employeeDetails2);// adicionando o JSONObject employeedDetails2 ao JSONObject employeeObject
         
        // Adicionando Employees na lista
        JSONArray employeeList = new JSONArray(); // Instanciando um JSONArray de nome employeeList
        employeeList.add(employeeObject);  // adicionando o JSONObject employeeObject no JSONArray com o método add.
        employeeList.add(employeeObject2); // adicionando o JSONObject employeeObject2 no JSONArray com o método add.
         
        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) { // Instanciando um FileWriter de nome file para criar um arquivo de nome employess.json. O try está fazendo o tratamento da exceção
        	
            
            file.write(employeeList.toJSONString()); // Convertendo o JSONArray de nome employeeList em um JSONString
            file.flush();  // o Método flush libera o fluxo de saída e força a gravação de quais bytes de saída em buffer
 
        } catch (IOException e) { // tratando exceção 
            e.printStackTrace(); // método printStackTrace usado para rastrear o erro
        }
    }
}