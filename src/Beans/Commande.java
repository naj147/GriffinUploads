package Beans;

public class Commande {
	private String Date;
	private String Montant;
	private String ModePaiement;
	private String StatusPaiement;
	private String ModeLivraison;
	private String StatusLivraison;
public Commande(String date, String montant, String modePaiement, String statusPaiement, String modeLivraison,
		String statusLivraison) {
	super();
	Date = date;
	Montant = montant;
	ModePaiement = modePaiement;
	StatusPaiement = statusPaiement;
	ModeLivraison = modeLivraison;
	StatusLivraison = statusLivraison;
}

public String getDate() {
	return Date;
}

public void setDate(String Date) {
	this.Date = Date;
}

public String getMontant() {
	return Montant;
}

public void setMontant(String Montant) {
	this.Montant = Montant;
}

public String getMode_paiement() {
	return ModePaiement;
}

public void setMode_paiement(String ModePaiement) {
	this.ModePaiement = ModePaiement;
}

public String getStatus_paiement() {
	return StatusPaiement;
}

public void setStatus_paiement(String StatusPaiement) {
	this.StatusPaiement = StatusPaiement;
}

public String getMode_livraison() {
	return ModeLivraison;
}

public void setMode_livraison(String ModeLivraison) {
	this.ModeLivraison = ModeLivraison;
}

public String getStatus_livraison() {
	return StatusLivraison;
}

public void setStatus_livraison(String StatusLivraison) {
	this.StatusLivraison = StatusLivraison;
}




}
