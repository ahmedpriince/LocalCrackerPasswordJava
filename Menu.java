import java.util.Scanner;

public class Menu {
    public Menu(){
        bienvenue();
    }


    public void demarrer(Scanner in){
        // on gère les entrée du gars

        // Scanner in = new Scanner(System.in);
        int choice=0;

        // on récupère son choix
        choice = in.nextInt();
        in.nextLine();

        System.out.print("Veuillez saisir votre mot de passe : ");
        String password = in.nextLine();

        switch (choice) {
            
                case 1:
                // il faut appeler le module crackerHashedModule
                CrackerHashedModule crackerHashedModule = new CrackerHashedModule(password);
                crackerHashedModule.attaque(in);
                break;   

        
            default:
                System.out.println("y'a qu'un choix a faire !!!!"+choice);
                break;
        }

        // in.close();


    }


    public void bienvenue(){
        System.out.println("Bienvenu dans notre programme de crackage de mot de passe !");
        System.out.println("1 -----> Pour lancer le processus ");
        System.out.print("Saisir votre choix : ");
    }
}
