package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	int niveauTraitrise = 0;
	private static final Random RANDOM = new Random();

	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traitrise est: " + niveauTraitrise + ". Chut!");
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise >= 3) {
			parler("Mince je ne peux plus ranconner personne sinon un samouraï risque de me démasquer !");
			return;
		}
		int argentRanconner = commercant.getArgent() / 5;
		commercant.perdreArgent(argentRanconner);
		gagnerArgent(argentRanconner);
		niveauTraitrise++;
		parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Donne moi " + argentRanconner
				+ " sous ou gare à toi!");
		commercant.parler("Tout de suite grand " + getNom());
	}

	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne! Snif.");
			return;
		}
		int indiceHumain = RANDOM.nextInt(nbConnaissance);
		Humain ami = memoire[indiceHumain];
		String nomAmi = ami.getNom();
		parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
		int don = getArgent() / 20;
		parler("Bonjour l'ami! Je voudrais vous aider en vous donnant " + don + " sous.");
		ami.gagnerArgent(don);
		perdreArgent(don);
		ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
		if (niveauTraitrise > 0)
			niveauTraitrise--;
	}
}
