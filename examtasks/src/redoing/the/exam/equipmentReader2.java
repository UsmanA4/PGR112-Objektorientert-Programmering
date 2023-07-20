package redoing.the.exam;

import program.Tasks.number.Ball;

import java.io.File;
import java.io.FileNotFoundException;


import java.util.HashMap;
import java.util.Scanner;

public class equipmentReader2 {
   public final String DEFAULT_FILE ="examtasks/src/equipment.txt";


   public HashMap<Integer,Equipment2> readFromFile(){
       return readFromFile(DEFAULT_FILE);
   }
   public HashMap<Integer,Equipment2> readFromFile(String fileName) {
       HashMap<Integer, Equipment2> result = new HashMap<>();
       try {
           Scanner fileInput = new Scanner(new File(fileName));
           while (fileInput.hasNextLine()){
               String input = fileInput.nextLine();
               switch (input){
                   case "Ball"->{
                       String sId = fileInput.nextLine();
                       int iId = Integer.parseInt(sId);

                       String location = fileInput.nextLine();


                       String replace = fileInput.nextLine();
                       boolean replacement = Boolean.parseBoolean(replace);

                       String ballType = fileInput.nextLine();


                       String hAir = fileInput.nextLine();
                        boolean bAir = Boolean.parseBoolean(hAir);

                        Ball2 b1 = Ball2.chooseAppropriateBall(iId,ballType);
                        b1.setLocation(location);
                        b1.setHasAir(bAir);
                        b1.setReplace(replacement);
                        result.put(iId,b1);
                   }
                   case "TableTennisRacket"->{
                       String sId = fileInput.nextLine();
                       int iId = Integer.parseInt(sId);

                       String location = fileInput.nextLine();
                       String replace = fileInput.nextLine();
                       boolean replacement = Boolean.parseBoolean(replace);
                       TableTennisRacket2 ttr = new TableTennisRacket2(iId);
                       result.put(iId,ttr);
                   }
               }
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       return result;
   }







/**




    final public String DEFAULT_FILE = "examtasks/src/equipment.txt";

    public  HashMap<Integer,Equipment2> readFromFile(){
        return readFromFile(DEFAULT_FILE);
    }

    public HashMap<Integer ,Equipment2> readFromFile(String fileName){
        HashMap<Integer,Equipment2>result =new HashMap<>();
        try {
            Scanner fileInput = new Scanner(new File(fileName));
            while (fileInput.hasNextLine()){
                String input = fileInput.nextLine();
                switch (input) {
                    case "Ball"->{
                        String sId = fileInput.nextLine();
                        int iId = Integer.parseInt(sId);

                        String location = fileInput.nextLine();

                        String replace = fileInput.nextLine();
                        boolean replaced = Boolean.parseBoolean(replace);

                        String ballType = fileInput.nextLine();

                        String hAir = fileInput.nextLine();
                        boolean bAir = Boolean.parseBoolean(hAir);

                        Ball2 b1 = Ball2.chooseAppropriateBall(iId,ballType);

                        result.put(iId,b1);
                        b1.setHasAir(bAir);
                        b1.setLocation(location);
                        b1.setReplace(replaced);


                    }
                    case "TableTennisRacket"->{
                        String sId = fileInput.nextLine();
                        int iId = Integer.parseInt(sId);

                        String location = fileInput.nextLine();

                        String replacement = fileInput.nextLine();
                        boolean replace = Boolean.parseBoolean(replacement);

                        String newFace = fileInput.nextLine();
                        boolean newFace1 =  Boolean.parseBoolean(newFace);

                        TableTennisRacket2 ttr = new TableTennisRacket2(iId);
                        ttr.setLocation(location);
                        ttr.setReplace(replace);
                        ttr.setNewFace(newFace1);
                        result.put(iId,ttr);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
      public HashMap<Integer,Equipment2> readFromFile(String fileName){
          HashMap<Integer,Equipment2> result = new HashMap<>();
          try {
              Scanner fileInput = new Scanner(new File(fileName));
              while (fileInput.hasNextLine()){
                  String input = fileInput.nextLine();
                  switch (input){
                      case "Ball"->{
                          String sId = fileInput.nextLine();
                          int iId= Integer.parseInt(sId);

                          String location = fileInput.nextLine();

                          String replace = fileInput.nextLine();
                          boolean replacement = Boolean.parseBoolean(replace);
                          String ballType = fileInput.nextLine();
                          String hAir = fileInput.nextLine();
                          boolean bAir = Boolean.parseBoolean(hAir);

                          Ball2 b1 = Ball2.chooseAppropriateBall(iId,ballType);
                          b1.setLocation(location);
                          b1.setReplace(replacement);
                          b1.setHasAir(bAir);

                         result.put(iId,b1);

                      }
                      case "TableTennisRacket"-> {
                          String sId = fileInput.nextLine();
                          int iId = Integer.parseInt(sId);

                          String location = fileInput.nextLine();

                          String replaceIt = fileInput.nextLine();
                          boolean replace = Boolean.parseBoolean(replaceIt);
                          String newFace = fileInput.nextLine();
                          boolean faceNew = Boolean.parseBoolean(newFace);

                          TableTennisRacket2 ttr = new TableTennisRacket2(iId);
                          ttr.setReplace(replace);
                          ttr.setNewFace(faceNew);
                          ttr.setLocation(location);
                          result.put(iId,ttr);
                      }

                  }
              }

          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          return result;
      } */


  }

