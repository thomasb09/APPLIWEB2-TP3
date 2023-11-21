package A23.C6.TP3.ClientLogistique.tbnh.A23.C6.TP3.ClientLogistique.tbnh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application extends javafx.application.Application {

	private static final String BASE_URL = "http://172.20.45.21:8080/a23.form.9.war-0.0.1-SNAPSHOT/";
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CLient Logistique");


		RestTemplate restTemplate = new RestTemplate();

		List<Client> listClient = restTemplate.getForObject(BASE_URL + "listClients", List.class);
//		List<Client> listClient = Arrays.asList(new Client("nom1", "adresse1"), new Client("nom2", "adresse2"));
		System.out.println("Retrieved list: " + listClient);
		ObservableList<Client> items = FXCollections.observableArrayList(listClient);
		ObservableList<Client> itemSelected = FXCollections.observableArrayList();

		ListView<Client> listView1 = new ListView<>(items);
		ListView<Client> listView2 = new ListView<>(itemSelected);

		Button addButton = new Button("Ajouter ->");
		Button removeButton = new Button("<- Retirer");

		addButton.setOnAction(event -> {
			Client selectedItem = listView1.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				items.remove(selectedItem);
				itemSelected.add(selectedItem);
			}
		});

		removeButton.setOnAction(event -> {
			Client selectedItem = listView2.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				itemSelected.remove(selectedItem);
				items.add(selectedItem);
			}
		});

		ListView<Client> listView = new ListView<>(itemSelected);

		Button button = new Button("Claculer le chemin du jour");

		button.setOnAction(event -> {
			postClientDuJOur(listView);
		});

		HBox hbox = new HBox(listView1, addButton, removeButton, listView2);
		hbox.setSpacing(10);

		VBox vbox = new VBox(hbox, button);
		vbox.setPadding(new Insets(10));

		Scene scene = new Scene(vbox, 650, 200);

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	private void postClientDuJOur(ListView<Client> listView) {
		List<Client> selectedItem = listView.getSelectionModel().getSelectedItems();

		if (selectedItem != null) {
			System.out.println("Méthode appelée avec l'objet : " + selectedItem);
			ResponseEntity<String> postResponse = restTemplate.postForEntity(BASE_URL + "/personne", selectedItem, String.class);
			System.out.println("Post Response: " + postResponse.getBody());
		} else {
			System.out.println("Aucun objet sélectionné");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
