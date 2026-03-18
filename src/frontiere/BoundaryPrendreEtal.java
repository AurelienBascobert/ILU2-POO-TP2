package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
    private final ControlPrendreEtal controlPrendreEtal;

    public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
        this.controlPrendreEtal = controlChercherEtal;
    }

    public void prendreEtal(String nomVendeur) {
        if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
            System.out.println("Je suis desolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
        } else {
            System.out.println("Bonjour " + nomVendeur + " ,je vais regarder si je peux vous trouver un étal.");
            if (!controlPrendreEtal.resteEtals()) {
                System.out.println("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas deja occupé.");
            } else {
                installerVendeur(nomVendeur);
                System.out.println("C'est parfait, il me este un étal pour vous !");
                System.out.println("Il me faudrait quelque renseignement :");
                String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
                int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
                int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
                if (numEtal != -1) {
                    System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numEtal + 1);
                }
            }
        }

    }

    private void installerVendeur(String nomVendeur) {
        //TODO a completer
    }
}
