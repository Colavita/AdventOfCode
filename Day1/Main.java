import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("inputs.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Elf> ListOfElfs = new ArrayList<Elf>();
            
            while(myReader.hasNextLine())
            {
                Elf elf = new Elf();
                while (myReader.hasNextLine())
                {
                    String data = myReader.nextLine();
                    if(data.equals("") )
                    {
                        ListOfElfs.add(elf);
                        break;
                    }
                    elf.numberOfCalories += Integer.parseInt(data);
                }
            }
            
            myReader.close();
            
            System.out.println("Part 1: " + getTotalCalories(ListOfElfs, 1) + " calories");
            System.out.println("Part 2: " + getTotalCalories(ListOfElfs, 3) + " calories");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static Integer getTotalCalories(ArrayList<Elf> listOfElfs, int numberOfElfs) {
        listOfElfs.sort((Elf e1, Elf e2) -> e2.numberOfCalories - e1.numberOfCalories);

        int sum = 0;
        for (int i = 0; i < numberOfElfs; i++) {
            sum += listOfElfs.get(i).numberOfCalories;
        }
        return sum;
    }
}   
