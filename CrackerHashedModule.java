import java.util.Scanner;

public class CrackerHashedModule {
    private String password;
    public CrackerHashedModule(String password){
        this.password = password;
    }

    public void attaque(Scanner in){
        String returnedPassword;

        int nbreLettre = 0;

        // Scanner in = new Scanner(System.in);
        String methode = getMethodeCrackaque(in);
        System.out.println("un mot de passe hashe pas de probleme choisi ta methode ");

        System.out.print("renseigne le nombre de caractere pour faciliter le crack");
        nbreLettre = in.nextInt();
        in.nextLine();
        System.out.println("C'est partie");


        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        returnedPassword = cracker.crackerHashedPassword(new StringBuilder(this.password), nbreLettre);
        if(returnedPassword == null){
            System.out.println("echec nous n'avons pas reussi");
        }else{
            System.out.println("mot de passe cracke. le mot de passe est : "+returnedPassword);
        }
        
        
        // in.close();
    }


    public String getMethodeCrackaque(Scanner in){
        boolean bon = false;
        String methodeDeCraquage=null;
        while (!bon) {
            System.out.println("bruteforce -----> Pour la methode brute force");
            System.out.println("dictionary -----> Pour la methode dictionnaire");
    
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("sérieux!\nveuillez ecrire 'bruteforce' ou 'dictionary'");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
