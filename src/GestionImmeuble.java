/*
    INF1120-10
    Nom: Ingrid Blemur
    Code permanent: BLEI08547903
 */

public class GestionImmeuble {
    //message de presentation
    public static final String MESSAGE_PRESENT = "Ce programme permet de faire la gestion d'un immeuble de 4 logements.\n" +
            "Il tient a jour le montant des loyers, les depenses associees aux\n" +
            "logements, et permet de calculer les revenus ou les pertes genere(e)s \n" +
            "par chacun des logements.\n";

    //message a afficher pour que l'utilisateur appuie sur la touche Entree
    public static final String MESSAGE_CONTINUER = "Appuyez sur <ENTREE> pour continuer...";

    //les options du menu principal
    public static final String MESSAGE_MENU = "(L) Modifier le montant d'un loyer \n" +
            "(D) Entrer des depenses pour un logement \n" +
            "(N) Debuter une nouvelle annee \n" +
            "(A) Afficher les revenus ou les pertes \n" +
            "(M) Passer au mois suivant \n" +
            "(Q) Quitter \n" +
            "\n" +
            "Entrez votre choix : ";

    //message a afficher dans l'option 'N' lorsque le bail est termine
    public static final String MESSAGE_FIN_BAIL = "L'annee du bail est terminee! Selectionnez l'option 'N' pour \n" +
            "debuter une nouvelle annee.";

    //message a afficher lorsque l'utilisateur doit selectionner un logement
    public static final String MESSAGE_LOGEMENT = "Entrez le numero du logement : ";

    //message a afficher dans l'option 'L' pour modifier le loyer
    public static final String MESSAGE_LOYER = "Entrez le montant du loyer pour le logement ";

    //message a afficher dans l'option 'D' pour ajouter un montant de depense
    public static final String MESSAGE_DEPENSE = "Ajouter une depense : ";

    //message d'erreur lorsqu'un choix du menu principal est invalide
    public static final String ERREUR_CHOIX = "Erreur, choix invalide ! recommencez...\n" +
            "Entrez votre choix : ";

    //message d'erreur lorsqu'un choix de logement est invalide
    public static final String ERREUR_LOG = "Erreur, entrez un numero entre 1 et 4 ! recommencez... \n" +
            "Entrez le numero du logement : ";

    //message d'erreur lorsque le montant de loyer entre n'est pas valide
    public static final String ERREUR_LOYER = "Erreur, le montant doit etre superieur a 0 ! recommencez... \n" +
            "Entrez le montant du loyer pour le logement ";

    //message d'erreur pour l'option 'M' lorsqu'il manque un montant de loyer
    public static final String ERREUR_ZERO = "Pour utiliser cette option, les montants de tous les loyers \n" +
            "doivent etre superieurs a zero.";

    //titre de l'affichage principal
    public static final String AFFICHAGE_MENU = "STATISTIQUES DES LOGEMENTS";

    //titre de l'affichage de l'etat des revenus
    public static final String AFFICHAGE_ETAT = "****************\n" +
                                                "ETAT DES REVENUS\n" +
                                                "****************\n";

    //duree du bail
    public static final int BAIL = 12;


    public static void main(String[] args) {

        //variable pour l'affichage du mois courant
        String mois = "JUILLET";

        //variables pour afficher les totaux de l'option 'A'
        String totalString1;
        String totalString2;
        String totalString3;
        String totalString4;

        int moisInt = 7; //variable pour identifier le mois courant
        int moisCompteur = 1; //variable pour compter combien de mois passe a l'interieur d'un bail
        int annee = 2019; //variable pour afficher et compter les annees
        int logement = 0; //variable pour identifier le logement a modifier le loyer ou ajouter les depenses
        boolean continuer = true; //variable pour entrer et sortir de la boucle principale
        boolean montrerMenu = true; //variable pour montrer ou cacher le menu principal
        char choixMenu = 'F'; //variable qui contient le choix de menu de l'utilisateur

        //variables pour garder et afficher les loyers
        double loyer1 = 0.00;
        double loyer2 = 0.00;
        double loyer3 = 0.00;
        double loyer4 = 0.00;


        double depensesEntree; //variable pour garder le montant entre par l'utilisateur et l'ajouter au total de depenses

        //variables pour garder et afficher les depenses pour chaque logement
        double depenses1 = 0.00;
        double depenses2 = 0.00;
        double depenses3 = 0.00;
        double depenses4 = 0.00;

        //variables pour garder et afficher le total de revenue ou pertes
        double total1;
        double total2;
        double total3;
        double total4;

        //affichage du message de presentation
        System.out.println(MESSAGE_PRESENT);

        //pause pour permettre a l'utilisateur de taper sur la touche 'Entree'
        System.out.println(MESSAGE_CONTINUER);
        Clavier.lireFinLigne();

        //boucle principale pour permettre a l'utilisateur d'utiliser le programme jusqu'a ce qu'ils en ont plus besoin
        while (continuer) {

            //affichage et menu principal
            if (montrerMenu) {
                System.out.println("\n");
                System.out.printf("%1S%15S%5d\n", AFFICHAGE_MENU, mois, annee);
                System.out.printf("%40s | %5s\n", "Montant du loyer", "Depenses");
                System.out.println("---------------------------------------------------\n");
                System.out.printf("%1s%26.2f | %8.2f\n", "Logement  #1 :", loyer1, depenses1);
                System.out.printf("%1s%26.2f | %8.2f\n", "Logement  #2 :", loyer2, depenses2);
                System.out.printf("%1s%26.2f | %8.2f\n", "Logement  #3 :", loyer3, depenses3);
                System.out.printf("%1s%26.2f | %8.2f\n", "Logement  #4 :", loyer4, depenses4);

                System.out.print("\n" + MESSAGE_MENU);

                choixMenu = Clavier.lireCharLn();
                choixMenu = Character.toUpperCase(choixMenu);
            }
            //switch principal pour valider et executer le choix de l'utilisateur
            switch (choixMenu) {
                //option 'L' qui permet de modifier un loyer pour le logement choisi
                case 'L':

                    System.out.print(MESSAGE_LOGEMENT);
                    logement = Clavier.lireInt();

                    montrerMenu = true;
                    switch (logement){
                        case 1:
                            System.out.print(MESSAGE_LOYER + logement + " : ");
                            loyer1 = Clavier.lireDouble();
                            while (loyer1 <= 0){
                                System.out.print(ERREUR_LOYER + logement + " : ");
                                loyer1 = Clavier.lireDouble();
                            }
                            break;
                        case 2:
                            System.out.print(MESSAGE_LOYER + logement + " : ");
                            loyer2 = Clavier.lireDouble();
                            while (loyer2 <= 0){
                                System.out.print(ERREUR_LOYER + logement + " : ");
                                loyer2 = Clavier.lireDouble();
                            }
                            break;
                        case 3:
                            System.out.print(MESSAGE_LOYER + logement + " : ");
                            loyer3 = Clavier.lireDouble();
                            while (loyer3 <= 0){
                                System.out.print(ERREUR_LOYER + logement + " : ");
                                loyer3 = Clavier.lireDouble();
                            }
                            break;
                        case 4:
                            System.out.print(MESSAGE_LOYER + logement + " : ");
                            loyer4 = Clavier.lireDouble();
                            while (loyer4 <= 0){
                                System.out.print(ERREUR_LOYER + logement + " : ");
                                loyer4 = Clavier.lireDouble();
                            }
                            break;
                        default:
                            while (logement < 1 || logement > 4){
                                System.out.println(ERREUR_LOG);
                                logement = Clavier.lireInt();
                                montrerMenu = false;
                            }//fin while

                    }//fin switch
                    break;
                //option 'D' qui permet d'ajouter des depenses pour le logement choisi par l'utilisateur
                case 'D':

                    System.out.print(MESSAGE_LOGEMENT);
                    logement = Clavier.lireInt();

                    montrerMenu = true;
                    switch (logement){
                        case 1:
                            System.out.print(MESSAGE_DEPENSE);
                            depensesEntree = Clavier.lireDouble();
                            while (depensesEntree != 0){
                                depenses1 = depenses1 + depensesEntree;
                                System.out.print(MESSAGE_DEPENSE);
                                depensesEntree = Clavier.lireDouble();
                            }//fin while
                            break;
                        case 2:
                            System.out.print(MESSAGE_DEPENSE);
                            depensesEntree = Clavier.lireDouble();
                            while (depensesEntree != 0){
                                depenses2 = depenses2 + depensesEntree;
                                System.out.print(MESSAGE_DEPENSE);
                                depensesEntree = Clavier.lireDouble();
                            }//fin while
                            break;
                        case 3:
                            System.out.print(MESSAGE_DEPENSE);
                            depensesEntree = Clavier.lireDouble();
                            while (depensesEntree != 0){
                                depenses3 = depenses3 + depensesEntree;
                                System.out.print(MESSAGE_DEPENSE);
                                depensesEntree = Clavier.lireDouble();
                            }//fin while
                            break;
                        case 4:
                            System.out.print(MESSAGE_DEPENSE);
                            depensesEntree = Clavier.lireDouble();
                            while (depensesEntree != 0){
                                depenses4 = depenses4 + depensesEntree;
                                System.out.print(MESSAGE_DEPENSE);
                                depensesEntree = Clavier.lireDouble();
                            }//fin while
                            break;
                        default:
                            while (logement < 1 || logement > 4){
                                System.out.print(ERREUR_LOG);
                                logement = Clavier.lireInt();
                                montrerMenu = false;
                            }//fin while

                    }
                    break;
                //option 'N' qui permet de commencer une nouvelle annee
                case 'N':
                    moisCompteur = 1;
                    moisInt = 7;
                    mois = "JUILLET";
                    break;
                //option 'A' qui calcule et affiche les revenus pour chaque logement
                case 'A':
                    loyer1 = loyer1 * moisCompteur;
                    total1 = loyer1 - depenses1;

                    loyer2 = loyer2 * moisCompteur;
                    total2 = loyer2 - depenses2;

                    loyer3 = loyer3 * moisCompteur;
                    total3 = loyer3 - depenses3;

                    loyer4 = loyer4 * moisCompteur;
                    total4 = loyer4 - depenses4;

                    if (total1 < 0 ){
                        total1 = Math.abs(total1);
                        totalString1 = "Pertes : ";

                    }else{
                        totalString1 = "Revenus : ";
                    }//fin if

                    if (total2 < 0 ){
                        total2 = Math.abs(total2);
                        totalString2 = "Pertes : ";

                    }else{
                        totalString2 = "Revenus : ";
                    }//fin if

                    if (total3 < 0 ){
                        total3 = Math.abs(total3);
                        totalString3 = "Pertes : ";

                    }else{
                        totalString3 = "Revenus : ";
                    }//fin if

                    if (total4 < 0 ){
                        total4 = Math.abs(total4);
                        totalString4 = "Pertes : ";

                    }else{
                        totalString4 = "Revenus : ";
                    }//fin if
                    System.out.println("\n" + AFFICHAGE_ETAT);
                    System.out.printf("%1s%40s\n", "Logement #1", "Logement #2");
                    System.out.printf("%1s%40s\n", "--------------------", "--------------------");
                    System.out.printf("%1s%10.2f%30s%10.2f\n\n\n", totalString1, total1, totalString2, total2);
                    System.out.printf("%1s%40s\n", "Logement #3", "Logement #4");
                    System.out.printf("%1s%40s\n", "--------------------", "--------------------");
                    System.out.printf("%1s%10.2f%30s%10.2f\n\n\n", totalString3, total3, totalString4, total4);
                    System.out.println(MESSAGE_CONTINUER);
                    Clavier.lireFinLigne();
                    break;
                //option 'M' qui fait avancer d'un mois
                case 'M':
                    if (loyer1 == 0 || loyer2 == 0 || loyer3 == 0 || loyer4 == 0) {
                        System.out.println(ERREUR_ZERO);
                        System.out.println(MESSAGE_CONTINUER);
                        Clavier.lireFinLigne();
                    } else {
                        moisInt = moisInt + 1;
                        if (moisCompteur < (BAIL)) {
                            switch (moisInt) {
                                case 1:
                                    mois = "JANVIER";
                                    break;
                                case 2:
                                    mois = "FEVRIER";
                                    break;
                                case 3:
                                    mois = "MARS";
                                    break;
                                case 4:
                                    mois = "AVRIL";
                                    break;
                                case 5:
                                    mois = "MAI";
                                    break;
                                case 6:
                                    mois = "JUIN";
                                    break;
                                case 7:
                                    mois = "JUILLET";
                                    break;
                                case 8:
                                    mois = "AOUT";
                                    break;
                                case 9:
                                    mois = "SEPTEMBRE";
                                    break;
                                case 10:
                                    mois = "OCTOBRE";
                                    break;
                                case 11:
                                    mois = "NOVEMBRE";
                                    break;
                                case 12:
                                    mois = "DECEMBRE";
                                    break;
                                default:
                                    moisInt = 1;
                                    mois = "JANVIER";
                                    annee = annee + 1;
                            }//fin switch
                        } else {
                            System.out.println(MESSAGE_FIN_BAIL);
                            System.out.println(MESSAGE_CONTINUER);
                            Clavier.lireFinLigne();
                        }//fin if
                        moisCompteur = moisCompteur + 1;
                    }//fin if
                    break;
                //option 'Q' qui permet de quitter le programme
                case 'Q':
                    continuer = false;
                    System.out.println("FIN NORMALE DU PROGRAMME");
                    break;
                //erreur et re-saisie si l'utilisateur entre un choix qui n'est pas dans le menu
                default:
                    while(choixMenu != 'L' && choixMenu != 'D' && choixMenu != 'N' && choixMenu != 'A' && choixMenu != 'M' && choixMenu != 'Q') {
                        System.out.print(ERREUR_CHOIX);
                        choixMenu = Clavier.lireCharLn();
                        choixMenu = Character.toUpperCase(choixMenu);
                        montrerMenu = false;
                    }//fin while

            }//fin switch

        }//fin while
    }

}
