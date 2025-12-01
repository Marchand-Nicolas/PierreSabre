package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	private static final int NB_CONNAISSANCES_MAX = 30;
	protected Humain[] memoire = new Humain[NB_CONNAISSANCES_MAX];

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") : " + texte);
	}

	public void boire() {
		parler("Mmmm un bon verre de " + boisson + " Gloups !");
	}

	public void acheter(String bien, int prix) {
		if (prix < argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir un " + bien + " à " + prix + " sous.");
			argent -= prix;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un" + bien + " à "
					+ prix + " sous.");
		}
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	private void oublier() {
		if (nbConnaissance == 0)
			return;
		for (int i = 1; i < nbConnaissance; i++) {
			memoire[i - 1] = memoire[i];
		}
		nbConnaissance--;
	}

	private void memoriser(Humain autreHumain) {
		if (nbConnaissance == NB_CONNAISSANCES_MAX)
			oublier();
		memoire[nbConnaissance] = autreHumain;
		nbConnaissance++;
	}

	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	public void listerConnaissances() {
		StringBuilder b = new StringBuilder();
		b.append("Je connais beaucoup de monde dont:");
		for (int i = 0; i < nbConnaissance; i++) {
			b.append(" ");
			b.append(memoire[i].getNom());
			if (i < nbConnaissance - 1)
				b.append(",");
		}
		parler(b.toString());
	}
}
