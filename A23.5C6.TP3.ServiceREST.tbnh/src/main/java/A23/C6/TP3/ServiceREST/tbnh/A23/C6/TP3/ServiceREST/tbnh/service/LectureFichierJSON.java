package A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.service;
        ;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectureFichierJSON {
    public static void main(String args[]) {

        JSONParser jsonP = new JSONParser();
        try {

            ClassLoader classLoader = LectureFichierJSON.class.getClassLoader();
            File file = new File(classLoader.getResource("person.json").getFile());

            JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader(file));

            String name = (String) jsonO.get("name");
            String age = (String) jsonO.get("age");
            String address = (String) jsonO.get("address");
            System.out.println("Name :"+ name);
            System.out.println("Age: "+ age);
            System.out.println("Address: "+ address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
