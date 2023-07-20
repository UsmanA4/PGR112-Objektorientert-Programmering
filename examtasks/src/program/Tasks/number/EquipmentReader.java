package program.Tasks.number;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EquipmentReader {
    final public String DEFAULT_FILE = "examtasks/src/equipment.txt";

    public HashMap<Integer,Equipment>  readFromFile(){
        return readFromFile(DEFAULT_FILE);
    }
    public HashMap<Integer,Equipment> readFromFile(String fileName) {
        HashMap<Integer, Equipment> result = new HashMap<>();
        try {
            Scanner fileInput = new Scanner(new File(fileName));

            while (fileInput.hasNextLine()) {
                String type = fileInput.nextLine();
                switch (type) {
                    case "Ball" -> {
                        String sId = fileInput.nextLine(); /*leser 5 linje*/
                        int iId = Integer.parseInt(sId);

                        String location = fileInput.nextLine(); /*leser 4, 3 igjen*/

                        String replacement = fileInput.nextLine();
                        boolean replace = Boolean.parseBoolean(replacement);

                         String ballType = fileInput.nextLine();

                        String sAir = fileInput.nextLine();
                        boolean bAir = Boolean.parseBoolean(sAir);


                        Ball b1 = Ball.chooseAppropriateBall(iId, ballType);
                        b1.setLocation(location);
                        b1.setReplace(replace);
                        b1.setHasAir(bAir);

                        result.put(iId, b1);

                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


}
