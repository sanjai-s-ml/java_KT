import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
public class FileReading {
    public static void main(String[] args) {
        try {
//            FileWriter fw=new FileWriter("note.txt"); // to write to file
//            fw.write("Exception handling in Java is a mechanism to handle runtime errors\n");
//            fw.write("It uses try, catch, finally, throw, and throws keywords.\n");
//            fw.write("throw is to throw a user defined exception \n");
//            System.out.println("Written successfully");
//            fw.close();
            File file = new File("note.txt");
            Scanner reader=new Scanner(file);
            System.out.println("Reading from file");
            while(reader.hasNextLine()){
                String data=reader.nextLine();
                System.out.println(data);
               // System.out.println();
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("From FileNotFound Exception "+e.getMessage());

        }catch(IOException e){
            System.out.println("From IOException "+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("From Exception "+e.getMessage());
        }
    }
}
