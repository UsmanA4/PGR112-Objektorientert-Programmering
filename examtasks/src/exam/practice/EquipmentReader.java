package exam.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EquipmentReader {
    private final String DEFAULT_FILE ="examtasks/src/exam/practice/equipment2.txt";

    public HashMap<Integer,Equipment>readFromFile(String fileName){
        return readFromFile(DEFAULT_FILE);
    }
    public HashMap<Integer,Equipment>readFromFile(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        try {
            FileReader fr = new FileReader(DEFAULT_FILE);
            Scanner fileInput = new Scanner(fr);
            while (fileInput.hasNextLine()){
                String input = fileInput.nextLine();
                switch (input){
                    case "Ball"->{
                        String i = fileInput.nextLine();
                        int id =Integer.parseInt(i);
                        String location = fileInput.nextLine();
                        String rep = fileInput.nextLine();
                        boolean replace = Boolean.parseBoolean(rep);
                        String ballType = fileInput.nextLine();
                        String bAir = fileInput.nextLine();
                        boolean nAir = Boolean.parseBoolean(bAir);

                        Ball b = Ball.chooseAppropiateBall(id,ballType);
                        b.setLocation(location);
                        b.setReplace(replace);
                        b.setAir(nAir);
                        result.put(id,b);
                    }
                    case "TableTennisRacket"->{
                        String iId = fileInput.nextLine();
                        int sId = Integer.parseInt(iId);
                        String loc = fileInput.nextLine();
                        String replace = fileInput.nextLine();
                        boolean replacement = Boolean.parseBoolean(replace);
                        String face = fileInput.nextLine();
                        boolean nFace = Boolean.parseBoolean(face);

                        TableTennisRacket ttr = new TableTennisRacket(sId);
                        ttr.setLocation(loc);
                        ttr.setReplace(replacement);
                        ttr.setNewFace(nFace);
                        result.put(sId,ttr);

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
