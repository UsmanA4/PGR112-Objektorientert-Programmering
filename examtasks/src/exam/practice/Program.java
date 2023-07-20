package exam.practice;

import java.util.HashMap;

public class Program {
    private HashMap<Integer,Equipment>equipmentMap= new HashMap<>();

    public Program(){
        EquipmentReader er = new EquipmentReader();
        equipmentMap=er.readFromFile();
    }

    public HashMap<Integer,Equipment>printBallsNeedingMoreAir(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer key: equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof Ball){
                Ball currentBall = (Ball) currentEquipment;
                if (currentBall.isAir()){
                    result.put(key,currentBall);
                    System.out.println(currentBall.getId()+"\n"+currentBall.getLocation()+"\n"+currentBall.isReplace()+"\n"+currentBall.isAir());
                }
            }
        }
        return result;
    }
    public HashMap<Integer,Equipment>printEquipmentNeedingToBeReplaced(){
         HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer k: equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(k);
            if (currentEquipment instanceof Ball){
             Ball currentBall = (Ball) currentEquipment;
             if (currentBall.isReplace()){
                 result.put(k,currentBall);
                 System.out.println(currentBall.getId()+"\n"+currentBall.getLocation()+"\n"+currentBall.isAir()+"\n"+currentBall.isReplace());
             }
            }
            if (currentEquipment instanceof TableTennisRacket){
                TableTennisRacket currentTTR = (TableTennisRacket) currentEquipment;

                if (currentTTR.isReplace()){
                    result.put(k,currentTTR);
                    System.out.println(currentTTR.getId()+"\n"+currentTTR.getLocation()+"\n"+currentTTR.isNewFace()+"\n"+currentTTR.isReplace());
                }
            }
        }
        return result;
    }
    public HashMap<Integer,Equipment>printTableTennisRacketsNeedingNewPad(){
        HashMap<Integer,Equipment>result = new HashMap<>();
        for (Integer key: equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof TableTennisRacket){
                TableTennisRacket currentTTR = (TableTennisRacket) currentEquipment;
                if (currentTTR.isNewFace()){
                    result.put(key,currentTTR);
                    System.out.println(currentTTR.getId()+"\n"+currentTTR.getLocation()+"\n"+currentTTR.isReplace()+"\n"+currentTTR.isNewFace());
                }
            }
        }
        return result;
    }
}
