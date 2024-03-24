package metier;

public class Produit {
	private String idProduit;
	private String nomProduit ;
	private String descriptionProduit ;
	private String prixProduit ;
	private String quantiteProduit ;
	public Produit(String idProduit, String nomProduit, String descriptionProduit, String prixProduit, String quantiteProduit) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.descriptionProduit = descriptionProduit;
		this.prixProduit = prixProduit;
		this.quantiteProduit = quantiteProduit;
	}
	public Produit(String nomProduit, String descriptionProduit, String prixProduit, String quantiteProduit) {
		super();
		this.nomProduit = nomProduit;
		this.descriptionProduit = descriptionProduit;
		this.prixProduit = prixProduit;
		this.quantiteProduit = quantiteProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescriptionProduit() {
		return descriptionProduit;
	}
	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}
	public String getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(String prixProduit) {
		this.prixProduit = prixProduit;
	}
	public String getQuantiteProduit() {
		return quantiteProduit;
	}
	public void setQuantiteProduit(String quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}
	public String getIdProduit() {
		return idProduit;
	}
	

}
