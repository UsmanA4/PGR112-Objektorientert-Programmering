package again;

import java.util.HashMap;

public class Program {
    private HashMap<Integer,Equipment>equipmentMap;

    public Program(){
        EquipmentReader er = new EquipmentReader();
        equipmentMap= new HashMap<>();
        equipmentMap=er.readFromFile();
    }

    public HashMap<Integer,Equipment>printBallsNeedingMoreAir(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer key:equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof  Ball){
                Ball currentBall = (Ball) currentEquipment;
                if (currentBall.isAir()){
                    result.put(key,currentBall);
                    System.out.println(currentBall.getId()+"\n"+currentBall.getLocation()+"\n"+currentBall.isAir());
                }
            }
        }
        return result;
    }

    public HashMap<Integer,Equipment>printEquipmentNeedingToBeReplaced(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer key:equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof Ball){
                Ball currentBall = (Ball) currentEquipment;
                if (currentBall.isReplace()){
                    result.put(key,currentBall);
                    System.out.println(currentBall.getId()+"\n"+currentBall.getLocation() + "\n"+currentBall.isReplace());
                }
            }
            if (currentEquipment instanceof TableTennisRacket){
                TableTennisRacket currentTTR = (TableTennisRacket) currentEquipment;
                if (currentTTR.isReplace()){
                    result.put(key,currentTTR);
                    System.out.println(currentTTR.getId()+"\n"+currentTTR.getLocation()+ "\n" + currentTTR.isReplace()  );
                }
            }
        }
        return result;
    }
    public HashMap<Integer,Equipment>printTableTennisRacketsNeedingNewPad(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer key:equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof TableTennisRacket){

                TableTennisRacket ttr = (TableTennisRacket) currentEquipment;
                if (currentEquipment instanceof TableTennisRacket){
                    TableTennisRacket currentTTR = (TableTennisRacket) currentEquipment;
                    if (currentTTR.isNewFace()){
                        result.put(key,currentTTR);
                        System.out.println(currentTTR.getId()+"\n"+currentTTR.getLocation()+"\n"+currentTTR.isNewFace());
                    }
                }

            }
        }
        return result;
    }
}
