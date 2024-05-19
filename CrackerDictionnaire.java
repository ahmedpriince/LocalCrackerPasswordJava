import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CrackerDictionnaire extends Cracker {
    
   
    public String crackerHashedPassword(StringBuilder password, int initalLength) {
        // Implémentation  méthode  hachage l'algorithme du dictionnaire
        System.out.println("Hashing password using dictionary algorithm...");


        String returnedPassword;
        long debut = System.currentTimeMillis();

        returnedPassword = parDictionnaire(password, false);

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/(1000);

        System.out.println("temps ecoule : "+tempsEcoule+"s");

        return returnedPassword;
    }

    public String parDictionnaire(StringBuilder password, boolean isSimple){
        try {
            File file = new File("../dictionnaires/dico.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                if(MdService.mdCompare(password, line, isSimple)){
                    // mot de passe trouvé
                    bufferedReader.close();
                    return line;
                }     
            }

            fileReader.close();    
            return null;
            

            
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("something is going wrong");
        }
        return "";
    }




    
}
