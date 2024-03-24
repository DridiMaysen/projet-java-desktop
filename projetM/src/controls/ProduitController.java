package controls;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.CrudProduit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import metier.Produit;

public class ProduitController implements Initializable {
	@FXML
    private TableColumn<Produit, String> coldes;

    @FXML
    private TableColumn<Produit, String> colid;

    @FXML
    private TableColumn<Produit, String> colnom;

    @FXML
    private TableColumn<Produit, String> colprix;

    @FXML
    private TableColumn<Produit, String> colquant;
    

    @FXML
    private TableView<Produit> tableProduit;

    @FXML
    private TextField txtdes;

    @FXML
    private TextField txtidp;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprix;

    @FXML
    private TextField txtquant;
    @FXML
    void charge(MouseEvent event) {
    	Produit p=tableProduit.getSelectionModel().getSelectedItem();
    	txtidp.setText(p.getIdProduit());
    	txtnom.setText(p.getNomProduit());
    	txtdes.setText(p.getDescriptionProduit());
    	txtprix.setText(p.getPrixProduit());
    	txtquant.setText(p.getQuantiteProduit());

    }

    @FXML
    void add(ActionEvent event) {
    	Produit p= new Produit(txtnom.getText(),txtdes.getText(),txtprix.getText(),txtquant.getText());
    	int i=CrudProduit.insert(p);
    	if(i!=0) {
    	Alert d= new Alert(AlertType.INFORMATION);
    	d.setTitle("Insertion Produit");
    	d.setHeaderText(null);
    	d.setContentText("Insertion effecutée avec succes");
    	d.showAndWait();
    	}
    	else {
    		Alert d= new Alert(AlertType.ERROR);
    		d.setTitle("Insertion Produit");
        	d.setHeaderText(null);
        	d.setContentText("Erreur d'insertion produit");
        	d.showAndWait();
    	} loadData();
    	
    	

    }

    @FXML
    void clear(ActionEvent event) {
    	txtnom.setText(null);
    	txtdes.setText(null);
    	txtprix.setText(null);
    	txtquant.setText(null);

    }

    @FXML
    void delete(ActionEvent event) {
    	Produit p=tableProduit.getSelectionModel().getSelectedItem();
    	int i=CrudProduit.delete(p);
    	if(i!=0) {
    	Alert d= new Alert(AlertType.INFORMATION);
    	d.setTitle("Suppression Produit");
    	d.setHeaderText(null);
    	d.setContentText("Suppression effecutée avec succes");
    	d.showAndWait();
    	}
    	else {
    		Alert d= new Alert(AlertType.ERROR);
    		d.setTitle("Suppression Produit");
        	d.setHeaderText(null);
        	d.setContentText("Erreur de suppression produit");
        	d.showAndWait();
    	}
    	loadData();

    }

    @FXML
    void update(ActionEvent event) {
    	Produit p= tableProduit.getSelectionModel().getSelectedItem();
    	Alert d=new Alert(AlertType.CONFIRMATION);
    	d.setTitle("confirmation ");
    	d.setHeaderText(null);
    	d.setContentText("Voulez vous mettre a jour cette categorie?");
    	Optional<ButtonType> rep=d.showAndWait();
    	if(rep.get()==ButtonType.OK) {
    	int i=CrudProduit.update(p,txtnom.getText(),txtdes.getText(),txtprix.getText(),txtquant.getText());
    	if(i!=0) {
    	Alert d1= new Alert(AlertType.INFORMATION);
    	d1.setTitle("Update Produit");
    	d1.setHeaderText(null);
    	d1.setContentText("Update effecutée avec succes");
    	d1.showAndWait();
    	}
    	else {
    		Alert d1= new Alert(AlertType.ERROR);
    		d1.setTitle("Update Produit");
        	d1.setHeaderText(null);
        	d1.setContentText("Erreur d'update produit");
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
    	loadData();


    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
	}

	private void loadData() {
		// TODO Auto-generated method stub
		colid.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		colnom.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		coldes.setCellValueFactory(new PropertyValueFactory<>("descriptionProduit"));
		colprix.setCellValueFactory(new PropertyValueFactory<>("prixProduit"));
		colquant.setCellValueFactory(new PropertyValueFactory<>("quantiteProduit"));
		tableProduit.setItems(CrudProduit.getAll());
	}

}
