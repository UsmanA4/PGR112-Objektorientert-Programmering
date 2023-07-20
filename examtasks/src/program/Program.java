package program;

import program.Tasks.number.Ball;
import program.Tasks.number.Equipment;
import program.Tasks.number.EquipmentReader;
import program.Tasks.number.TableTennisRacket;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    private final String DEFAULT_FILE ="examtasks/src/equipment.txt";
    HashMap<Integer,Equipment>equipmentMap = new HashMap<>();

    public Program(){
        EquipmentReader read = new EquipmentReader();
        equipmentMap = read.readFromFile();
    }




    public HashMap<Integer, Equipment> getEquipmentMap() {
        return equipmentMap;
    }



    public HashMap<Integer,Equipment>printBallsNeedingMoreAir(){
        HashMap<Integer,Equipment> result = new HashMap<>();

        for (Integer key: equipmentMap.keySet()) {
            Equipment currentElement = equipmentMap.get(key);
            if (currentElement instanceof Ball){ /*hvis elementet er en ball bruker instanceof */
                Ball current = (Ball) currentElement;
                if (!current.isHasAir()){
                    result.put(key,current);
                    System.out.println("" + key +"" +current.getLocation() +" - " + current.getType() );
                }
            }
        }
        return result;
    }
    public HashMap<Integer,Equipment> printEquipmentNeedingToBeReplaced(){
        HashMap<Integer,Equipment> result = new HashMap<>();
        for (Integer key:equipmentMap.keySet()) {
           Equipment currentEquipment = equipmentMap.get(key);
           if (currentEquipment instanceof Equipment){
               Equipment current = currentEquipment;
               if (!current.isReplace()){
                   result.put(key,current);
                   System.out.println("" + key +"" +current.getLocation() +" - " + current.getEquipId() );
               }
           }
        }
        return result;
    }
    public HashMap<Integer,Equipment> printTableTennisRacketsNeedingNewPad(){
        HashMap<Integer,Equipment> result = new HashMap<>();
        for (Integer key: equipmentMap.keySet()) {
            Equipment currentEquipment = equipmentMap.get(key);
            if (currentEquipment instanceof TableTennisRacket){ /*hvis utstyret er av table tennis typen*/
                TableTennisRacket current = (TableTennisRacket) currentEquipment; /**sjekk ut*/
                if ( !current.isNewFace()){ /*hvis den trenger et nytt bellegg*/
                    result.put(key,current);
                    System.out.println("" + key +"" +current.getEquipId() +"--" + current);

                }
            }
        }
        return result;
    }
}
