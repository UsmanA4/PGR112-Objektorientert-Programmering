package Tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<Book>bookList= new ArrayList<>();
    private final String DEFAULT_FILE = "examtasks/src/Tasks/bok.txt";

    public Program(){
        BookRegister bg = new BookRegister();
        bookList=bg.readFromFile();
    }

    public void runProgram(){
        showMenu();
        Scanner inputs = new Scanner(System.in);
        String choice = inputs.nextLine();
        while (!choice.equalsIgnoreCase("7")){
            switch (choice){
                case "0"-> {
                 addBook();
                }
                case "1"->{
                    displayAllBooks();
                }
                case "2"-> {
                    searchByTitle();
                }
                case "3"-> {
                    searchByAuthor();
                }
                case "4"->{
                    searchByPageNumber();
                }
                case "5"->{
                    searchByGenre();
                }
                case "6"->{
                    modifyBook();
                }
            }
            choice= inputs.nextLine();
        }
    }

    public void showMenu (){
        ArrayList<String>menu= new ArrayList<>();
        menu.add("Add a book");
        menu.add("Display all books");
        menu.add("Search book by title");
        menu.add("Search book by author");
        menu.add("Search book by pageNumber");
        menu.add("Search book by genre");
        menu.add("Modify book by title");
        menu.add("Exit");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i+"->"+menu.get(i));
        }
    }
    public void addBook(){
        Path myPath = Paths.get(DEFAULT_FILE);
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Add a isbn:");
            String isbn = input.nextLine();
            System.out.println("Add a title:");
            String t = input.next();
            t+= input.nextLine();
            System.out.println("Add an author:");
            String a = input.next();
            a+= input.nextLine();
            System.out.println("Add a numberOfPages:");
            String p = input.nextLine();
            int page =Integer.parseInt(p);
            System.out.println("Add a genre:");
            String gen = input.nextLine();
            Genre genre = Genre.valueOf(gen.toUpperCase());

            Book b = new Book(isbn,t,a,page,genre);
            b.setIsbn(isbn);
            b.setTitle(t);
            b.setAuthor(a);
            b.setNumberOfPages(page);
            b.setGenre(genre);

            String addIt =  new String(Files.readAllBytes(myPath));
            addIt=addIt.concat("\n"+b.getIsbn()+"\n"+b.getTitle()+"\n"+b.getAuthor()+"\n"+b.getNumberOfPages()+"\n"+b.getGenre()+"\n---");

            Files.writeString(myPath, addIt, StandardOpenOption.CREATE);
            System.out.println("Book added to file!");
            showMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Book>displayAllBooks(){
        ArrayList<Book>result = new ArrayList<>();
        for (Book b:bookList) {
            System.out.println(b.getIsbn()+"\n"+b.getTitle()+"\n"+b.getAuthor()+"\n"+b.getNumberOfPages()+"\n"+b.getGenre()+"\n---");
            result.add(b);
        }
        showMenu();
        return result;
    }
    public ArrayList<Book>searchByTitle(){
        ArrayList<Book>result = new ArrayList<>();
        System.out.println("Search book by title:");
        Scanner input = new Scanner(System.in);
        String t = input.next();
        t+= input.nextLine();
        for (Book st:bookList) {
            if (st.getTitle().equalsIgnoreCase(t)){
                System.out.println(st.getIsbn()+"\n"+st.getTitle()+"\n"+st.getAuthor()+"\n"+st.getNumberOfPages()+"\n"+st.getGenre()+"\n---");
                result.add(st);
            }
        }
        showMenu();
        return result;
    }
    public ArrayList<Book>searchByAuthor(){
        ArrayList<Book>result = new ArrayList<>();
        System.out.println("Search book by author:");
        Scanner input = new Scanner(System.in);
        String a = input.next();
        a+= input.nextLine();
        for (Book sa:bookList) {
           if (sa.getAuthor().equalsIgnoreCase(a)){
               System.out.println(sa.getIsbn()+"\n"+sa.getTitle()+"\n"+sa.getAuthor()+"\n"+sa.getNumberOfPages()+"\n"+sa.getGenre()+"\n---");
               result.add(sa);
           }
        }
        showMenu();
        return result;
    }
    public ArrayList<Book>searchByPageNumber(){
        ArrayList<Book>result = new ArrayList<>();
        System.out.println("Search book by page number:");
        Scanner input = new Scanner(System.in);
        int page = input.nextInt();
        for (Book sp:bookList) {
            if (sp.getNumberOfPages()==page){
                System.out.println(sp.getIsbn()+"\n"+sp.getTitle()+"\n"+sp.getAuthor()+"\n"+sp.getNumberOfPages()+"\n"+sp.getGenre()+"\n---");
                result.add(sp);
            }
        }
        showMenu();
        return result;
    }
    public ArrayList<Book>searchByGenre(){
        ArrayList<Book>result = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Search book by genre:");
        String gen = input.nextLine();
        Genre genre = Genre.valueOf(gen.toUpperCase());
        for (Book sg:bookList) {
            if (sg.getGenre().equals(genre)){
                System.out.println(sg.getIsbn()+"\n"+sg.getTitle()+"\n"+sg.getAuthor()+"\n"+sg.getNumberOfPages()+"\n"+sg.getGenre()+"\n---");
                result.add(sg);
            }
        }
        showMenu();
        return result;
    }
    public void modifyBook(){
        System.out.println("Modify book by title:");
        Scanner input = new Scanner(System.in);
        String t = input.next();
        t+= input.nextLine();
        for (Book mod:bookList) {
            if (mod.getTitle().equalsIgnoreCase(t)){

                System.out.println("Set a new title");
                String tl = input.next();
                tl += input.nextLine();
                System.out.println("Set a new author:");
                String a = input.next();
                a+= input.nextLine();
                System.out.println("Set new number of pages:");
                String p = input.nextLine();
                int pages = Integer.parseInt(p);
                System.out.println("Set a new genre:");
                String g = input.nextLine();
                Genre gen = Genre.valueOf(g.toUpperCase());

                mod.setTitle(tl);
                mod.setAuthor(a);
                mod.setNumberOfPages(pages);
                mod.setGenre(gen);
                System.out.println("Book modified!");
                showMenu();
            }
        }
    }
}
