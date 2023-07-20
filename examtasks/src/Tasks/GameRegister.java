package Tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class GameRegister {
    private ArrayList<Game>gameList= new ArrayList<>();
    private final String DEFAULT_FILE = "examtasks/src/Tasks/game.txt";

    public GameRegister(){
        GameReader gr = new GameReader();
        gameList=gr.readFromFile();
    }
    public void runProgram(){
        showMenu();
        Scanner inputs = new Scanner(System.in);
        String input = inputs.nextLine();
        while (!input.equalsIgnoreCase("7")){

            switch (input){
                case "0"->{
                    addGame();
                }
                case "1"->{
                    displayAllGames();
                }
                case "2"->{
                    searchById();
                }
                case "3"->{
                    searchByTitle();
                }
                case "4"->{
                    searchByRelease();
                }
                case "5"->{
                    searchByGenre();
                }
                case "6"->{
                    modifyGame();
                }
                default -> {
                    System.out.println("I don't know what your trying to do..");
                    showMenu();
                }

            }
            input= inputs.nextLine();
        }
    }
    public void showMenu(){
        ArrayList<String>menu = new ArrayList<>();
        menu.add("Add a game");
        menu.add("Display all games");
        menu.add("Search game by id");
        menu.add("Search game by title");
        menu.add("Search game by releaseYear");
        menu.add("Search game by genre");
        menu.add("Modify game by id");
        menu.add("Exit");

        for (int i = 0; i < menu.size() ; i++) {
            System.out.println(i+" ->"+menu.get(i));
        }
    }
    public void addGame(){
        Path myPath = Paths.get(DEFAULT_FILE);
        Scanner inputs = new Scanner(System.in);
        try {
            System.out.println("Add a title:");
            String t = inputs.next();
            t+= inputs.nextLine();
            System.out.println("Add a releaseYear:");
            String n = inputs.nextLine();
            int year = Integer.parseInt(n);
            System.out.println("Add a genre:");
            String gen = inputs.nextLine();
            GGenre genre = GGenre.valueOf(gen.toUpperCase());

            Game g = new Game(t,year,genre);
            g.setId(gameList.size()+1);
            g.setTitle(t);
            g.setReleaseYear(year);
            g.setGenre(genre);

            String addIt = new String(Files.readAllBytes(myPath));
            addIt=addIt.concat("\n"+g.getId()+"\n"+g.getTitle()+"\n"+g.getReleaseYear()+"\n"+g.getGenre()+"\n---");

            Files.writeString(myPath, addIt, StandardOpenOption.CREATE);
            System.out.println("Game added to file!");
            showMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Game>displayAllGames(){
        ArrayList<Game>result = new ArrayList<>();
        for (Game g:gameList) {
            System.out.println(g.getId() +"\n" + g.getTitle()+"\n"+g.getReleaseYear()+"\n"+g.getGenre()+"\n---");
            result.add(g);
        }
        showMenu();
        return result;
    }
    public ArrayList<Game>searchById(){
        ArrayList<Game>result = new ArrayList<>();
        System.out.println("Search game by id:");
        Scanner input = new Scanner(System.in);
        String i = input.nextLine();
        int id = Integer.parseInt(i);
        for (Game si:gameList) {
            if (si.getId()==id) {
                System.out.println(si.getId() + "\n" + si.getTitle() + "\n" + si.getReleaseYear() + "\n" + si.getGenre() + "\n---");
                result.add(si);
            }
        }
        showMenu();
        return result;
    }
    public ArrayList<Game>searchByTitle(){
        ArrayList<Game>result = new ArrayList<>();
        System.out.println("Search game by title:");
        Scanner inputs = new Scanner(System.in);
        String t = inputs.next();
        t+= inputs.nextLine();

        for (Game st:gameList) {
            if (st.getTitle().equalsIgnoreCase(t)) {
                System.out.println(st.getId() + "\n" + st.getTitle() + "\n" + st.getReleaseYear() + "\n" + st.getGenre() + "\n---");
                result.add(st);
            }
        }
        showMenu();
        return result;
    }
    public ArrayList<Game>searchByRelease(){
        ArrayList<Game>result = new ArrayList<>();
        System.out.println("Search game by year:");
        Scanner input = new Scanner(System.in);
        String y = input.nextLine();
        int year =Integer.parseInt(y);
        for (Game sy:gameList) {
            if (sy.getReleaseYear()==year) {
                System.out.println(sy.getId() + "\n" + sy.getTitle() + "\n" + sy.getReleaseYear() + "\n" + sy.getGenre() + "\n---");
                result.add(sy);
            }
        }
        showMenu();
        return result;
    }
    public ArrayList<Game>searchByGenre(){
        ArrayList<Game>result = new ArrayList<>();
        System.out.println("Search game by genre:");
        Scanner input = new Scanner(System.in);
        String gen = input.nextLine();
        GGenre genre = GGenre.valueOf(gen.toUpperCase());
        for (Game sg:gameList) {
            if (sg.getGenre().equals(genre)) {
                System.out.println(sg.getId() + "\n" + sg.getTitle() + "\n" + sg.getReleaseYear() + "\n" + sg.getGenre() + "\n---");
                result.add(sg);
            }
        }
        showMenu();
        return result;
    }
    public void modifyGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("Modify game by id:");
        String i = input.nextLine();
        int id = Integer.parseInt(i);
        for (Game mod:gameList) {
            if (mod.getId()==id){
                System.out.println("Set a new title:");
                String t = input.next();
                t+= input.nextLine();
                System.out.println("Set a new releaseYear:");
                String y = input.nextLine();
                int year =Integer.parseInt(y);
                System.out.println("Set a new genre:");
                String g = input.nextLine();
                GGenre gen = GGenre.valueOf(g.toUpperCase());

                mod.setTitle(t);
                mod.setReleaseYear(year);
                mod.setGenre(gen);
                System.out.println("Game modified!");
                showMenu();
            }
        }
    }
}
