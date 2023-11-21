package A23.C6.TP3.SeviceREST.TBNH.serviceREST.util;

import A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele.Client;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

;

public class LectureFichierJSON {
    public List<Client> lireFichierJSON() {

        List<Client> listeClients = new ArrayList<>();

        JSONParser jsonP = new JSONParser();
        try {
            ClassLoader classLoader = LectureFichierJSON.class.getClassLoader();
            File file = new File(classLoader.getResource("clients.json").getFile());

            JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(file));

            JSONArray clientsArray = (JSONArray) jsonObject.get("clients");

            for (Object clientObj : clientsArray) {
                JSONObject clientJson = (JSONObject) clientObj;

                String nom = (String) clientJson.get("nom");
                String adresse = (String) clientJson.get("adresse");

                Client client = new Client(nom, adresse);
                listeClients.add(client);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listeClients;
    }
}
