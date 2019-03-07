
/**
 * I N F x 1 2 0
 *
 * D�crivez votre classe LaboBoucles3 ici.
 * 
 * @author (votre nom) 
 * @version (une date)
 *
 * (votre code permanent)
 * (votre adresse de courriel)
 */

public class LaboBoucles3 {
    public static final String ENTRE_NBR = ("Entrez un nombre : ");
    public static final String ERREUR = ("Erreur, le nombre doit etre entre 1 et 12 inclus.");

    public static void main (String[] args){
        int choix;
        int multi;
        int i;
        int j = 0;

        System.out.print(ENTRE_NBR);
        choix = Clavier.lireInt();

        while (choix <= 2 || choix >= 12){
            System.out.println(ERREUR);
            System.out.print(ENTRE_NBR);
            choix = Clavier.lireInt();
        }
        
        for(i = 0; i <= choix; i++ ) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        for(j = 0; j <= choix; j++){
            if (j == 0){
                System.out.print(" ");
            }else {
                System.out.print(j + " ");
            }
            for (int m = 0; m <= choix; m++) {
                multi = m * j;
                if (multi != 0) {
                    System.out.print(multi + " ");
                }
            }
            System.out.print("\n");
        }

    }

} // LaboBoucles3
