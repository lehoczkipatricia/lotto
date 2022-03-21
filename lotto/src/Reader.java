import java.io.FileReader;
import java.util.Vector;
import java.util.Scanner;


public class Reader{

    public Reader() {
        
    }

    public Vector<String> readFile() {
        Vector<String> numbers = new Vector<>();
        try { 
            FileReader fRead = new FileReader("szamok.txt");
            Scanner scan = new Scanner(fRead);
            while (scan.hasNext()) {
                String row = scan.nextLine();
                if (row.matches("[1-9:]+")) {
                    numbers.add(row);
                }

            }
            scan.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return numbers;
    }

}