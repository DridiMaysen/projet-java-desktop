package metier;

public class Client {
	private String idClient;
	private String nomClient;
	private String prenomClient ;
	private String mdpClient;
	private String teleClient;
	private String addClient ;
	public Client(String idClient, String nomClient, String prenomClient, String mdpClient, String teleClient,
			String addClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.mdpClient = mdpClient;
		this.teleClient = teleClient;
		this.addClient = addClient;
	}
	
	public Client(String nomClient, String prenomClient, String mdpClient, String teleClient, String addClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.mdpClient = mdpClient;
		this.teleClient = teleClient;
		this.addClient = addClient;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getMdpClient() {
		return mdpClient;
	}
	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}
	public String getTeleClient() {
		return teleClient;
	}
	public void setTeleClient(String teleClient) {
		this.teleClient = teleClient;
	}
	public String getAddClient() {
		return addClient;
	}
	public void setAddClient(String addClient) {
		this.addClient = addClient;
	}
	public String getIdClient() {
		return idClient;
	}
	
	

}
