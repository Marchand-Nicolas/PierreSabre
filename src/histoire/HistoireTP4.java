package histoire;

import personnages.Commercant;
import personnages.Humain;
import personnages.Yakuza;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("kombucha", 12);
		prof.boire();
		prof.acheter("jeu", 2);
		prof.acheter("kimono", 50);
		Commercant marco = new Commercant("Marco", 30);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoirArgent(15);
		marco.boire();
		Yakuza yaku = new Yakuza("Yaku", "Whisky", 30, "Warsong");
		yaku.direBonjour();
		yaku.extorquer(marco);
	}
}
