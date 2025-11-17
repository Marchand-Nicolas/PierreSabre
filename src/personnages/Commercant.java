package personnages;

public class Commercant extends Humain {
	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}

	public int seFaireExtorquer() {
		int argentExtorque = getArgent();
		perdreArgent(argentExtorque);
		parler("Le monde est vraiment trop injuste!");
		return argentExtorque;
	}

	public void recevoirArgent(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous! Je te remercie généreux donateur!");
	}

}
