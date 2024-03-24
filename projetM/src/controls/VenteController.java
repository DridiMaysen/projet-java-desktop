package controls;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.CrudVente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import metier.Vente;

public class VenteController implements Initializable {
	@FXML
    private TableColumn<Vente, String> colidc;

    @FXML
    private TableColumn<Vente, String> colidp;

    @FXML
    private TableColumn<Vente, String> colidv;

    @FXML
    private TableColumn<Vente, String> colprix;

    @FXML
    private TableColumn<Vente, String> colquant;

    @FXML
    private TableView<Vente> tablevente;

    @FXML
    private TextField txtidc;

    @FXML
    private TextField txtidp;

    @FXML
    private TextField txtidv;

    @FXML
    private TextField txtprix;

    @FXML
    private TextField txtquant;
    @FXML
    void charge(MouseEvent event) {
    	Vente v=tablevente.getSelectionModel().getSelectedItem();
    	txtidv.setText(v.getIdVente());
    	txtidc.setText(v.getIdClient());
    	txtidp.setText(v.getIdProduit());
    	txtprix.setText(v.getPrixProduit());
    	txtquant.setText(v.getQuantiteProduit());

    }

    @FXML
    void add(ActionEvent event) {
    	Vente v= new Vente(txtidp.getText(),txtidc.getText(),txtprix.getText(),txtquant.getText());
    	int i=CrudVente.insert(v);
    	if(i!=0) {
    	Alert d= new Alert(AlertType.INFORMATION);
    	d.setTitle("Insertion Vente");
    	d.setHeaderText(null);
    	d.setContentText("Insertion effecutée avec succes");
    	d.showAndWait();
    	}
    	else {
    		Alert d= new Alert(AlertType.ERROR);
    		d.setTitle("Insertion Vente");
        	d.setHeaderText(null);
        	d.setContentText("Erreur d'insertion vente");
        	d.showAndWait();
    	}loadDatat();

    }

    @FXML
    void clear(ActionEvent event) {
    	txtidp.setText(null);
    	txtidc.setText(null);
    	txtprix.setText(null);
    	txtquant.setText(null);
    	txtidv.setText(null);

    }

    @FXML
    void delete(ActionEvent event) {
    	Vente v =tablevente.getSelectionModel().getSelectedItem();
    	int i=CrudVente.delete(v);
    	if(i!=0) {
    	Alert d= new Alert(AlertType.INFORMATION);
    	d.setTitle("Suppression Vente");
    	d.setHeaderText(null);
    	d.setContentText("Suppression effecutée avec succes");
    	d.showAndWait();
    	}
    	else {
    		Alert d= new Alert(AlertType.ERROR);
    		d.setTitle("Suppression Vente");
        	d.setHeaderText(null);
        	d.setContentText("Erreur de suppression vente");
        	d.showAndWait();
    	}loadDatat();

    }

    @FXML
    void update(ActionEvent event) {
    	Vente v= tablevente.getSelectionModel().getSelectedItem();
    	Alert d=new Alert(AlertType.CONFIRMATION);
    	d.setTitle("confirmation ");
    	d.setHeaderText(null);
    	d.setContentText("Voulez vous mettre a jour cette categorie?");
    	Optional<ButtonType> rep=d.showAndWait();
    	if(rep.get()==ButtonType.OK) {
    	int i=CrudVente.update(v,txtidc.getText(),txtidp.getText(),txtprix.getText(),txtquant.getText());
    	if(i!=0) {
    	Alert d1= new Alert(AlertType.INFORMATION);
    	d1.setTitle("Update Vente");
    	d1.setHeaderText(null);
    	d1.setContentText("Update effecutée avec succes");
    	d1.showAndWait();
    	}
    	else {
    		Alert d1= new Alert(AlertType.ERROR);
    		d1.setTitle("Update Vente");
        	d1.setHeaderText(null);
        	d1.setContentText("Erreur d' update vente");
        	d1.showAndWait();
    	}
    	}
    	else {
    		Alert d1=new Alert(AlertType.INFORMATION);
    		d1.setTitle("MAJ ");
    		d1.setHeaderText(null);
    		d1.setContentText("MAJ annullée");
    		d1.showAndWait();
    	}
    	loadDatat();
    	


    	

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDatat();
	}

	private void loadDatat() {
		// TODO Auto-generated method stub
		colidc.setCellValueFactory(new PropertyValueFactory<>("idClient"));
		colidp.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		colidv.setCellValueFactory(new PropertyValueFactory<>("idVente"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prixProduit"));
		colquant.setCellValueFactory(new PropertyValueFactory<>("quantiteProduit"));
		tablevente.setItems(CrudVente.getAll());
	}

}
