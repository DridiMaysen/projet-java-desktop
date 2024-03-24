package controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewAdminController {
	@FXML
    private Button btngerem;

    @FXML
    private Button btngererc;

    @FXML
    private Button btngererp;

    @FXML
    private Button btngererv;

    @FXML
    void gereProduit(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/ProduitViews.fxml"));
			Scene scene = new Scene(root);
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void gererClient(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/ClientViews.fxml"));
			Scene scene = new Scene(root);
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void gererMarque(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/MarqueViews.fxml"));
			Scene scene = new Scene(root);
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void gererVente(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/VenteViews.fxml"));
			Scene scene = new Scene(root);
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
