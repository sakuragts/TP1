public class ExercisesString {
    /**
     * Extrait et retourne la sous-chaine de la chaine donnee qui se trouve
     * entre la premiere occurrence du caractere debut dans chaine et la premiere
     * occurrence du caractere fin qui se trouve apres le caractere debut dans
     * chaine. Si debut ou fin (apres debut) n'existe pas dans la chaine, retourne
     * null.
     *
     * @param chaine la chaine de laquelle on veut extraire la sous-chaine a
     *               retourner.
     * @param debut le caractere debut de la sous-chaine (non compris dans la
     *              sous-chaine retournee).
     * @param fin le caratere fin de la sous-chaine (non compris dans la
     *              sous-chaine retournee).
     * @return la sous-chaine de chaine entre debut et fin ou null si debut et fin
     *         n'existe pas.
     */
    public static String extraireSousChaine(String chaine, char debut, char fin) {

        //TODO

        return null;  //pour compilation
    }

    /**
     * Cette methode retourne une chaine de caracteres indiquant la "sorte" de
     * la chaine donnee en parametre.
     * - Si tous les caracteres de chaine sont des chiffres, elle retourne la
     *   chaine "numerique".
     * - Si tous les caracteres de chaine sont des lettres (maj. ou min.), elle
     *   retourne la chaine "alphabetique".
     * - Si chaine ne contient que des lettres et des chiffres (et au moins une
     *   lettre et au moins un chiffre), elle retourne la chaine "alphanumerique".
     * - Si chaine est vide, elle retourne la chaine "vide".
     * - Si chaine est null, elle retourne la chaine "nulle".
     *
     * @param chaine la chaine dont on veut retourner la sorte.
     * @return la sorte de la chaine donnee en parametre.
     */
    public static String sorte(String chaine) {
        boolean estNumerique = false;
        boolean estAlphabetique = false;

        char car;

        if (chaine != null){
            if(!chaine.isEmpty()){
                for (int i = 0; i < chaine.length(); i++){
                    car = chaine.charAt(i);
                    if(car >= '0' && car <= '9' ){
                        estNumerique = true;
                    }else{
                        estAlphabetique = true;
                    }
                }
                if(estNumerique && estAlphabetique){
                    chaine = "alphanumerique";
                }else if(estNumerique){
                    chaine = "numerique";
                }else{
                    chaine = "alphabetique";
                }
            }else {
                chaine = "vide";
            }
        }else{
            chaine = "nulle";
        }



        return chaine; //pour compilation
    }

    /**
     * Retourne la chaine cryptee de la chaine a crypter donnee en parametre,
     * selon les regles suivantes :
     * 1. Chacune de lettres min. ('a' a 'z') de chaineACrypter doit etre
     *    remplacee par le caractere a codeCryptage positions APRES cette lettre
     *    minuscule (en suivant l'ordre Unicode). Par exemple, si codeCryptage
     *    est 2, la lettre est 'a' sera remplacee par 'c'.
     *
     * 2. Chacune de lettres maj. ('A' a 'Z') de chaineACrypter doit etre
     *    remplacee par le caractere a codeCryptage positions AVANT cette lettre
     *    minuscule (en suivant l'ordre Unicode). Par exemple, si codeCryptage
     *    est 5, la lettre est 'm' sera remplacee par 'h'.
     *
     * 3. Chacun des chiffres ('0' a '9') de chaineACrypter doit etre remplace
     *    par (7 modulo codeCryptage) positions APRES ce chiffre (en suivant
     *    l'ordre des Unicode). Par exemple, le codeCryptage est 4, le caractere
     *    '1' sera remplace par '4' (7 modulo 4 = 3).
     *
     * 4. Tous les autres caracteres de chaineACrypter demeurent inchanges.
     *
     * NOTE : Pour cet exercice, on suppose que le codeCryptage donne est un
     *        entier > 0 ET que chaineACrypter n'est pas null, n'est pas vide
     *        et peut effectivement etre cryptee selon les regles donnees.
     *
     * @param chaineACrypter la chaine qu'on veut crypter.
     * @param codeCryptage le code pour crypter la chaine.
     * @return la chaine cryptee.
     */
    public static String crypter (String chaineACrypter, int codeCryptage) {
        char car;
        char newCar;
        int charLength = chaineACrypter.length();

        for(int i = 0; i < charLength; i++){
           car = chaineACrypter.charAt(i);
           if(car >= 'a' && car <= 'z'){
               newCar = (char)(car + codeCryptage);
               if (i == 0) {
                   chaineACrypter = newCar + chaineACrypter.substring(i+1);
               }else{
                   chaineACrypter = chaineACrypter.substring(0, i) + newCar + chaineACrypter.substring(i+1);
               }
           }else if(car >= 'A' && car <= 'Z'){
               newCar = (char)(car - codeCryptage);
               if (i == 0) {
                   chaineACrypter = newCar + chaineACrypter.substring(i+1);
               }else{
                   chaineACrypter = chaineACrypter.substring(0, i) + newCar + chaineACrypter.substring(i+1);
               }
           }else if(car >= '0' && car <= '9'){
                newCar = (char)(car + 7 % codeCryptage);
               if (i == 0) {
                   chaineACrypter = newCar + chaineACrypter.substring(i+1);
               }else{
                   chaineACrypter = chaineACrypter.substring(0, i) + newCar + chaineACrypter.substring(i+1);
               }
           }
        }


        return chaineACrypter;
    }
    public static String decrypter (String chaineADecripter, int codeCryptage){
        char car;
        char newCar;

        for(int i = 0; i < chaineADecripter.length(); i++){
            car = chaineADecripter.charAt(i);
            if(car >= 'a' && car <= 'z'){
                newCar = (char)(car - codeCryptage);
                if (i == 0) {
                    chaineADecripter = newCar + chaineADecripter.substring(i+1);
                }else{
                    chaineADecripter = chaineADecripter.substring(0, i) + newCar + chaineADecripter.substring(i+1);
                }
            }else if(car >= 'A' && car <= 'Z'){
                newCar = (char)(car + codeCryptage);
                if (i == 0) {
                    chaineADecripter = newCar + chaineADecripter.substring(i+1);
                }else{
                    chaineADecripter = chaineADecripter.substring(0, i) + newCar + chaineADecripter.substring(i+1);
                }
            }else{
                newCar = (char)(car - 7 % codeCryptage);
                if (i == 0) {
                    chaineADecripter = newCar + chaineADecripter.substring(i+1);
                }else{
                    chaineADecripter = chaineADecripter.substring(0, i) + newCar + chaineADecripter.substring(i+1);
                }
            }
        }
        return chaineADecripter;
    }

    public static void main (String[] args){
        System.out.println(crypter("urgence911", 2));
        System.out.println(decrypter("wtigpeg:22", 2));
    }

}
