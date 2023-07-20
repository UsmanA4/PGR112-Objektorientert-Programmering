package again;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EquipmentReader {
    private final String DEFAULT_FILE = "examtasks/src/again/equipment.txt";

    public HashMap<Integer,Equipment>readFromFile(String fileName){
        return readFromFile(fileName);
    }
    public HashMap<Integer,Equipment>readFromFile(){
      HashMap<Integer,Equipment>result = new HashMap<>();
      try {
          FileReader fr = new FileReader(DEFAULT_FILE);
          Scanner fileInput= new Scanner(fr);
          while (fileInput.hasNextLine()){
              String input = fileInput.nextLine();
              switch (input){
                  case "Ball"->{
                      String i = fileInput.nextLine();
                      int id = Integer.parseInt(i);
                      String loc = fileInput.nextLine();
                      String r = fileInput.nextLine();
                      boolean rep = Boolean.parseBoolean(r);
                      String ballType = fileInput.nextLine();
                      String hAir = fileInput.nextLine();
                      boolean nAir = Boolean.parseBoolean(hAir);

                      Ball b = Ball.chooseAppropiateBall(id , ballType);
                      b.setLocation(loc);
                      b.setReplace(rep);
                      b.setAir(nAir);

                      result.put(id,b);
                  }
                  case "TableTennisRacket"->{
                      String i = fileInput.nextLine();
                      int id = Integer.parseInt(i);
                      String l = fileInput.nextLine();
                      String r = fileInput.nextLine();
                      boolean rep = Boolean.parseBoolean(r);
                      String f = fileInput.nextLine();
                      boolean face = Boolean.parseBoolean(f);

                      TableTennisRacket ttr = new TableTennisRacket(id);
                      ttr.setLocation(l);
                      ttr.setReplace(rep);
                      ttr.setNewFace(face);
                      result.put(id,ttr);
                  }
              }
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      return result;
    }
}
