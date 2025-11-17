package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant beneficiaire) {
		int don = getArgent() / 10;
		parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		beneficiaire.recevoirArgent(don);
		perdreArgent(don);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = 2 * honneur;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			honneur++;
			gagnerArgent(adversaire.perdre());
		} else {
			parler("J'ai perdu contre ce Yakuza, mon honneur et ma bourse en ont pris un coup.");
			honneur--;
			int perte = getArgent();
			perdreArgent(perte);
			adversaire.gagner(perte);
		}
	}
}
