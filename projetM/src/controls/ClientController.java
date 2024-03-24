package controls;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.CrudClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.Client;


public class ClientController implements Initializable{
	@FXML
    private Button btnadd;

    @FXML
    private Button btnclear;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;
	@FXML
    private TableColumn<Client, String> coladd;

    @FXML
    private TableColumn<Client, String> colid;

    @FXML
    private TableColumn<Client, String> colmdp;

    @FXML
    private TableColumn<Client, String> colnom;

    @FXML
    private TableColumn<Client, String> colprenom;

    @FXML
    private TableColumn<Client, String> coltele;

    @FXML
    private TableView<Client> tableclient;

    @FXML
    private TextField txtadresse;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtnum;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtprenom;
    @FXML
    void charge(MouseEvent event) {
    	Client c=tableclient.getSelectionModel().getSelectedItem();
    	txtid.setText(c.getIdClient());
    	txtnom.setText(c.getNomClient());
    	txtprenom.setText(c.getPrenomClient());
    	txtadresse.setText(c.getAddClient());
    	txtnum.setText(c.getTeleClient());
    	txtpass.setText(c.getMdpClient());
    	
    }

    @FXML
    void add(ActionEvent event) {
    	Client c =new Client (txtnom.getText(),txtprenom.getText(),txtpass.getText(),txtadresse.getText(),txtnum.getText());
    	int i=CrudClient.insert(c);
    	if(i!=0) {
        	Alert d= new Alert(AlertType.INFORMATION);
        	d.setTitle("Insertion Client");
        	d.setHeaderText(null);
        	d.setContentText("Insertion effecutée avec succes");
        	d.showAndWait();
        	}
        	else {
        		Alert d= new Alert(AlertType.ERROR);
        		d.setTitle("Insertion Client");
            	d.setHeaderText(null);
            	d.setContentText("Erreur d'insertion client");
            	d.showAndWait();
        	}
    	loadData();

    }

    @FXML
    void clear(ActionEvent event) {
    	txtnom.setText(null);
    	txtprenom.setText(null);
    	txtpass.setText(null);
    	txtadresse.setText(null);
    	txtnum.setText(null);
    	txtid.setText(null);

    }

    @FXML
    void delete(ActionEvent event) {
    	Client c= tableclient.getSelectionModel().getSelectedItem();
    	int i=CrudClient.delete(c);
    	if(i!=0) {
        	Alert d= new Alert(AlertType.INFORMATION);
        	d.setTitle("Suppression Client");
        	d.setHeaderText(null);
        	d.setContentText("Suppression effecutée avec succes");
        	d.showAndWait();
        	}
        	else {
        		Alert d= new Alert(AlertType.ERROR);
        		d.setTitle("Suppression client");
            	d.setHeaderText(null);
            	d.setContentText("Erreur de suppression client");
            	d.showAndWait();
        	}
    	loadData();

    }

    @FXML
    void update(ActionEvent event) {
    	Client c= tableclient.getSelectionModel().getSelectedItem();
    	Alert d=new Alert(AlertType.CONFIRMATION);
    	d.setTitle("confirmation ");
    	d.setHeaderText(null);
    	d.setContentText("Voulez vous mettre a jour cette categorie?");
    	Optional<ButtonType> rep=d.showAndWait();
    	if(rep.get()==ButtonType.OK) {
    	int i=CrudClient.update(c,txtnom.getText(),txtprenom.getText(),txtpass.getText(),txtadresse.getText(),txtnum.getText());
    	if(i!=0) {
        	Alert d1= new Alert(AlertType.INFORMATION);
        	d1.setTitle("Update Client");
        	d1.setHeaderText(null);
        	d1.setContentText("Update effecutée avec succes");
        	d1.showAndWait();
        	}
        	else {
        		Alert d1= new Alert(AlertType.ERROR);
        		d1.setTitle("Insertion Client");
            	d1.setHeaderText(null);
            	d1.setContentText("Erreur d'update client");
            	d1.showAndWait();
        	}}
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
		colid.setCellValueFactory(new PropertyValueFactory<>("idClient"));
		colnom.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
		colprenom.setCellValueFactory(new PropertyValueFactory<>("prenomClient"));
		coltele.setCellValueFactory(new PropertyValueFactory<>("teleClient"));
		colmdp.setCellValueFactory(new PropertyValueFactory<>("mdpClient"));
		coladd.setCellValueFactory(new PropertyValueFactory<>("addClient"));
		tableclient.setItems(CrudClient.getAll());
	}

}
