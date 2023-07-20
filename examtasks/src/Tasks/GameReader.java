package Tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameReader {
    public final String DEFAULT_FILE= "examtasks/src/Tasks/game.txt";


    public ArrayList<Game>readFromFile(String fileName){
        return readFromFile(DEFAULT_FILE);
    }

    public ArrayList<Game>readFromFile(){
        ArrayList<Game>result = new ArrayList<>();
        try {
            FileReader fr = new FileReader(DEFAULT_FILE);
            Scanner fileInput = new Scanner(fr);
            while (fileInput.hasNextLine()){
                String i = fileInput.nextLine();
                int id = Integer.parseInt(i);
                String title = fileInput.nextLine();
                String y = fileInput.nextLine();
                int year = Integer.parseInt(y);
                String g = fileInput.nextLine();
                GGenre genre = GGenre.valueOf(g);

                fileInput.nextLine(); /**skips the delimiter*/

                Game g1 = new Game(id,title,year,genre);
                g1.setId(id);
                g1.setTitle(title);
                g1.setReleaseYear(year);
                g1.setGenre(genre);

                result.add(g1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
