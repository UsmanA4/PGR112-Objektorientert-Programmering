package Tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {

    private final String DEFAULT_FILE ="examtasks/src/Tasks/bok.txt";


    public ArrayList<Book>readFromFile(String fileName){
        return  readFromFile(DEFAULT_FILE);
    }

    public ArrayList<Book>readFromFile(){
        ArrayList<Book>result = new ArrayList<>();
        try {
            FileReader fr = new FileReader(DEFAULT_FILE);
            Scanner fileInput = new Scanner(fr);
            while (fileInput.hasNextLine()){
                String isbn = fileInput.nextLine();
                String title = fileInput.nextLine();
                String author = fileInput.nextLine();
                String p = fileInput.nextLine();
                int pages =Integer.parseInt(p);
                String gen = fileInput.nextLine();
                Genre genre = Genre.valueOf(gen);

                fileInput.nextLine(); /**skips the delimiter*/

                Book b1 = new Book(isbn,title,author,pages,genre);
                b1.setIsbn(isbn);
                b1.setTitle(title);
                b1.setAuthor(author);
                b1.setNumberOfPages(pages);
                b1.setGenre(genre);

                result.add(b1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
