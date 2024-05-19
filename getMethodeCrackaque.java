import java.util.Scanner;

public class getMethodeCrackaque {
    private String password;
    public getMethodeCrackaque(String password){
        this.password = password;
    }



    public String getMethodeCrackaque(Scanner in){
        boolean bon = false;
        String methodeDeCraquage=null;
        while (!bon) {
            System.out.println("bruteforce -----> Pour la methode brute force");
            System.out.println("dictionary -----> Pour la methode dictionnaire");
            System.out.print("Fais ton choix : ");
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("regardez bien votre hortographe?\nbruteforce ou dictionary");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
