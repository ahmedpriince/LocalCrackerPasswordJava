public class CrackerBruteForce extends Cracker {
    

    
    public String crackerHashedPassword(StringBuilder password, int initalLength) {
        // Implémentation de la méthode de hachage de mot de passe avec BruteForce
        System.out.println("Hashing password using bruteforce algorithm...");
        
        String returnedPassword;

        char[] passwordToGenerate = new char[initalLength];

        long debut = System.currentTimeMillis();
        
        returnedPassword = forceBrute(password, passwordToGenerate, 0, initalLength, false);
        
        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/1000;
        System.out.println("temps ecoule : "+tempsEcoule+"s");
        
        return returnedPassword;
    }

    
    public String forceBrute(StringBuilder passWord, char[] chaine, int position, int longueur, boolean isSimple){
        
        if(position == longueur-1){
            
            for (int i = 97; i < 97+26; i++) {
                chaine[position] = toChar(i);
                String combinaision = new String(chaine);
                // 
                if(MdService.mdCompare(passWord, combinaision, isSimple)){
                    return combinaision;
                }
            }
            return null;

        }else{
            
            for (int i = 97; i < 123; i++) {
                chaine[position] = toChar(i);
                if(forceBrute(passWord, chaine, position +1,longueur, isSimple) != null){
                    
                    return new String(chaine);
                }
            }

            return null;
        }


        
    }

    
    public char toChar(int codeAsci){
        char lettre = (char)codeAsci;
        return lettre;
    }


}