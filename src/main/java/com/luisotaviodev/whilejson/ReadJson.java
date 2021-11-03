ackage com.luisotaviodev.whilejson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJson {  // nome da classe ReadJSON

	
	@SuppressWarnings("unchecked") //notação que impede o compilador de emitir algumas advertências
    public static void main(String[] args)  // declarando método MAIN
    {
      
        JSONParser jsonParser = new JSONParser(); //Instanciando JSONParser chamado jsonParser
         
        try (FileReader reader = new FileReader("employees.json")) // Tratando exceção com Try e intânciando um FileReader de nome reader que irá ler o arquivo employees.json
        {
            
            Object obj = jsonParser.parse(reader); // Instânciando um objeto de nome obj que irá chamar o reader criado acima
 
            JSONArray employeeList = (JSONArray) obj; // Objtendo objetos do JSONArray
            System.out.println(employeeList); // Imprimindo o JSONArray employeeList
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );// percorrendo a JSONList com o forEach
 
        } catch (FileNotFoundException e) { //tratandode erro FileNotFoundExcepetion
            e.printStackTrace(); //Rasteando o erro
        } catch (IOException e) { // Tratando erro IOExcepection
            e.printStackTrace(); // Rastreando o erro
        } catch (ParseException e) { // Tratamento de erro ParseExcepetion
            e.printStackTrace(); // Rastrando o erro
        }
    }
 
    private static void parseEmployeeObject(JSONObject employee)  // Criando Método parseEmployeeObject (com parâmetros JSONObject employee)
    {
        
        JSONObject employeeObject = (JSONObject) employee.get("employee"); // Obtendo Lista de employee
         
        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");    // Obtendo lista de employee pelo primeiro nome
        System.out.println(firstName); // Imprimindo Primeiro nome
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");   // Obtendo lista de employee pelo último nome
        System.out.println(lastName); // imprimindo último nome
        
       
        String email = (String) employeeObject.get("email");     // obtendo email
        System.out.println(email);  // Imprimindo email
    }
}
