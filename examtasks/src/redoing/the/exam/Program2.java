package redoing.the.exam;

import java.util.HashMap;

public class Program2 {

    public final String DEFAULT_FILE= "examtasks/src/equipment.txt";
    private HashMap<Integer,Equipment2> equipmentMap2;

    public Program2(){
        equipmentReader2 read = new equipmentReader2();
        equipmentMap2 = read.readFromFile();
    }

    public HashMap<Integer,Equipment2> ballsNeedingMoreAir(){
        HashMap<Integer,Equipment2>result = new HashMap<>();
        for (Integer key:equipmentMap2.keySet()) {
            Equipment2 current = equipmentMap2.get(key);
            if (current instanceof Ball2){
                Ball2 currentBall = (Ball2) current;

                if (!currentBall.isHasAir()){
                    result.put(key,currentBall);
                    System.out.println(key +"\n"+currentBall.getType() +"\n"+currentBall.getLocation());
                }
            }
        }
        return result;
    }




















    /**
       private final String DEFAULT_FILE = "examtasks/src/equipment.txt";
       private HashMap<Integer,Equipment2> equipmentMap2;   /* husk for each

        public Program2(){
            equipmentReader2 reader2 = new equipmentReader2();
            equipmentMap2 = reader2.readFromFile();
        }

       public HashMap<Integer,Equipment2> printBallsNeedingMoreAir(){
           HashMap<Integer,Equipment2> result = new HashMap<>();
           for (Integer key:equipmentMap2.keySet()) {
               Equipment2 currentEquipment = equipmentMap2.get(key);
               if (currentEquipment instanceof Ball2) {
                   Ball2 current = (Ball2)  currentEquipment;
                   if (!current.isHasAir()){ /*if not false
                       result.put(key,current);
                       System.out.println(key+"\n"+current.getLocation() +"\n"+current.getType()+ "\n"+current.isReplace() +"\n"+current.isHasAir());
                   }
               }
           }
           return result;
       }

       public HashMap<Integer,Equipment2> printEquipmentNeedingToBeReplaced2(){
           HashMap<Integer,Equipment2> result =new HashMap<>();
           for (Integer key:equipmentMap2.keySet()) {
               Equipment2 currentEquipment = equipmentMap2.get(key);
               if (currentEquipment instanceof Ball2){
                   Ball2 current = (Ball2) currentEquipment;
                   if (current.isReplace()){
                       result.put(key,current);
                       System.out.println(key+"\n"+current.getType() +"\n" + current.isReplace()+"\n"+current.isHasAir());
                   }

               }
               if (currentEquipment instanceof TableTennisRacket2){
                   TableTennisRacket2 currentTTR = (TableTennisRacket2) currentEquipment;
                   if (!currentTTR.isReplace()){
                       result.put(key,currentTTR);
                       System.out.println(key+"\n"+currentTTR.getLocation() +"\n"+currentTTR.isReplace()+"\n"+currentTTR.isNewFace());
                   }
               }
           }
           return result;
       }






       /**

    public HashMap<Integer,Equipment2>  printEquipmentNeedingToBeReplaced2() {
        HashMap<Integer, Equipment2> result = new HashMap<>();
        for (Integer key : equipmentMap2.keySet()) {
            Equipment2 currentEquipment = equipmentMap2.get(key);
            if (currentEquipment instanceof Ball2) {
                Ball2 current = (Ball2) currentEquipment;
                if (!current.isReplace()) {
                    result.put(key, current);
                    System.out.println("" + key + "\n" + current.getType() + "\n"+current.isHasAir()+ "\n" + current.getLocation()+"\n"+current.isReplace());
                }
            }
            if (currentEquipment instanceof TableTennisRacket2){
                TableTennisRacket2 currentTTR = (TableTennisRacket2) currentEquipment;
                if (!currentTTR.isReplace() ){
                    result.put(key,currentTTR);
                    System.out.println(""+key +  "\n"+currentTTR.getLocation() + "\n"+"\n"+currentTTR.isReplace() +"\n"+currentTTR.isNewFace());
                }
            }
        }
        return result;
    }
       public HashMap<Integer,Equipment2> printTableTennisRacketsNeedingNewPad2(){
           HashMap<Integer,Equipment2> result = new HashMap<>();
           for (Integer key : equipmentMap2.keySet()) {
               Equipment2 currentEquipment = equipmentMap2.get(key);
               if (currentEquipment instanceof  TableTennisRacket2){
                   TableTennisRacket2 current = (TableTennisRacket2) currentEquipment;
                   if (!current.isNewFace()){
                       result.put(key,current);
                       System.out.println(key +"\n"+current.getLocation() +"\n"+current.isNewFace() +"\n"+current.isReplace());
                   }
               }
           }
           return result;
       } */
}


