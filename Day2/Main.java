import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        try{
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            Game game1 = new Game();
            Game game2 = new Game();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                game1.play(tokens[1], tokens[0]);
                game2.playWithStrategy(tokens[1], tokens[0]);
            }

            System.out.println("Part 1: " + game1.getTournamentScore());
            System.out.println("Part 2: " + game2.getTournamentScore()); 
            sc.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}