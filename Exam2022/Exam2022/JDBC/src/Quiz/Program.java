package Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private final String url="jdbc:mysql://localhost:3306/quizdb";
    private final String user = "root";
    private final String password="ss15343255123";
    private final String myDriver = "com.mysql.cj.jdbc.Driver";

    private final int sum=0;
    private int scoreCounter=0;
    public String u;


    public void continueMenu(){
        ArrayList<String> menu= new ArrayList<>();
        menu.add("A:Continue with the next question");
        menu.add("B:Show options");
        menu.add("C:Exit ");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }
    public void moreOptionsMenu(){
        ArrayList<String> menu= new ArrayList<>();
        menu.add("A:List all scores for a user (please enter the user name):");
        menu.add("B:List all score records >= 3 for Games");
        menu.add("C:Continue with another round");
        menu.add("D:Exit");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

    public void showTopic(){
        ArrayList<String> menu= new ArrayList<>();
        menu.add("A:Football(Multiple Choices)");
        menu.add("B:Games(Binary Quiz)");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }



    public void quiz(){
        Scanner input = new Scanner(System.in);
        System.out.println("Sign up a new user:");
        u= input.nextLine();
        System.out.println("Choose a topic");
        showTopic();
        String t = input.nextLine();
        switch (t){
            case "A"->{
                multipleQuiz();
            }
            case "B"->{
                binaryQuiz();
            }
        }
    }

    public void multipleQuiz(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From multichoicequiz WHERE id =1 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question") +"\nA:"+rs.getString("answerA") + "\nB:"+rs.getString("answerB") + "\nC:"+rs.getString("answerC")+
                        "\nD:"+rs.getString("answerD"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equals("D")) {
                    correctAnswer(a);
                    continueMenu();
                    String c= input.nextLine();

                    switch (c) {
                        case "A"->{
                            fq2();
                        }
                        case "B"->{
                            moreOptionsMenu();
                            String o = input.nextLine();
                            switch (o){
                                case "A" ->{
                                    showUserScoreTable();

                                }
                                case "B"->{
                                    listScoreLargerThan3();
                                }
                                case "C"->{
                                    fq2();
                                }
                                default -> {
                                    System.out.println("Good bye, looking forward to see you again!");
                                    break;
                                }
                            }
                        }
                        default -> {
                            System.out.println("Good bye");
                            System.out.println("Your total score is: "+(scoreCounter-1));
                            addTotalScores(scoreCounter-1,"Football");
                            System.out.println("Your scores:");
                            showScoreTable();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your total score is: "+(scoreCounter));
                    break;
                }


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fq2(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From multichoicequiz WHERE id =2 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question") +"\nA:"+rs.getString("answerA") + "\nB:"+rs.getString("answerB") + "\nC:"+rs.getString("answerC")+
                        "\nD:"+rs.getString("answerD"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();

                if (a.equals("B")) {
                    correctAnswer(a);
                    continueMenu();
                    String c= input.nextLine();

                    switch (c) {
                        case "A"->{
                            fq3();
                        }
                        case "B"->{
                            moreOptionsMenu();
                            String o = input.nextLine();
                            switch (o){
                                case "A"->{
                                    showUserScoreTable();
                                }
                                case "B"->{
                                    listScoreLargerThan3();
                                }
                                case "C"->{
                                    fq3();
                                }
                                case "D"->{
                                    System.out.println("Good bye, looking forward to see you again!");
                                    break;
                                }
                            }

                        }
                        default -> {
                            System.out.println("Good bye");
                            System.out.println("Your total score is: "+(scoreCounter-1));
                            addTotalScores(scoreCounter-1,"Football");
                            System.out.println("Your scores:");
                            showScoreTable();
                            break;
                        }
                    }
                }
                else {

                    System.out.println("WRONG! \nYour total score is: "+(scoreCounter-2));
                }


            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fq3(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From multichoicequiz WHERE id =3 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question") +"\nA:"+rs.getString("answerA") + "\nB:"+rs.getString("answerB") + "\nC:"+rs.getString("answerC")+
                        "\nD:"+rs.getString("answerD"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equals("A")) {
                    correctAnswer(a);
                    continueMenu();
                    String c= input.nextLine();

                    switch (c) {
                        case "A"->{
                            fq4();
                        }
                        case "B"->{
                            moreOptionsMenu();
                            String o = input.nextLine();
                            switch (o){
                                case "A"->{
                                    showUserScoreTable();
                                }
                                case "B"->{
                                    listScoreLargerThan3();
                                }
                                case "C"->{
                                    fq4();
                                }
                                case "D"->{
                                    System.out.println("Good bye, looking forward to see you again!");
                                    break;
                                }
                            }
                        }
                        default -> {
                            System.out.println("Good bye");
                            System.out.println("Your total score is: "+(scoreCounter-1 ) );
                            addTotalScores(scoreCounter-1,"Football");
                            System.out.println("Your scores:");
                            showScoreTable();

                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your total score is: "+(scoreCounter-2));
                }

            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fq4(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From multichoicequiz WHERE id =4 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question") +"\nA:"+rs.getString("answerA") + "\nB:"+rs.getString("answerB") + "\nC:"+rs.getString("answerC")+
                        "\nD:"+rs.getString("answerD"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equals("D")) {
                    System.out.println("Congrats ! You have accomplished this quiz: Your score is 4 out of 4 ");
                    addTotalScores(4,"Football");
                    break;
                }
                else {
                    System.out.println("Wrong!");
                    System.out.println("Your total score is: "+(scoreCounter-2));
                    addTotalScores(scoreCounter-2,"Football");
                    quiz();
                }

            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void binaryQuiz(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From binaryquiz WHERE id =1 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equalsIgnoreCase("Yes")) {
                    correctAnswerB(a);
                    continueMenu();
                    String c= input.nextLine();
                    switch (c) {
                        case "A"->{
                            bq2();
                        }
                        case "B"->{
                            moreOptionsMenu();
                            String o = input.nextLine();
                            switch (o){
                                case "A"->{
                                    showUserScoreTable();
                                }
                                case "B"->{
                                    listScoreLargerThan3();
                                }
                                case "C"->{
                                    bq2();
                                }
                                case "D"->{
                                    System.out.println("Thank you for playing! Looking forward to see you again");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Good bye");
                            System.out.println("Your total score is: "+(scoreCounter-1));
                            addTotalScores(scoreCounter-1,"Games");
                            System.out.println("Your scores:");
                            showScoreTable();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your total score is: "+(scoreCounter));
                    addTotalScores(scoreCounter,"Games");
                    System.out.println("Your scores:");
                    showScoreTable();
                    break;
                }


            }


        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bq2(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From binaryquiz WHERE id =2 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equalsIgnoreCase("No")) {
                    correctAnswerB(a);
                    continueMenu();
                    String c= input.nextLine();
                    switch (c) {
                        case "A"->{
                            bq3();
                        }
                        case "B"->{
                            moreOptionsMenu();
                            String o = input.nextLine();
                            switch (o){
                                case "A"->{
                                    showUserScoreTable();
                                }
                                case "B"->{
                                    listScoreLargerThan3();
                                }
                                case "C"->{
                                    bq3();
                                }
                                case "D"->{
                                    System.out.println("good bye ! see you next time");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Good bye");
                            System.out.println("Your total score is: "+(scoreCounter-1));
                            addTotalScores(scoreCounter-1,"Games");
                            System.out.println("Your scores:");
                            showScoreTable();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your total score is: "+(scoreCounter-1));
                    addTotalScores(scoreCounter-1,"Games");
                    System.out.println("Your scores:");
                    showScoreTable();
                    break;
                }


            }


        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bq3(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select *  From binaryquiz WHERE id =3 ";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                System.out.println(rs.getString("question"));

                System.out.println("Your answer:");
                Scanner input = new Scanner(System.in);
                String a = input.nextLine();
                if (a.equalsIgnoreCase("Yes")) {
                    System.out.println("Congrats! You have a 3 out of 3 score!" );
                    addTotalScores(3,"Games");
                    break;
                }
                else {
                    System.out.println("Wrong!");
                    System.out.println("Your total score is: "+(scoreCounter-1));
                    addTotalScores(scoreCounter-1,"Games");
                    break;
                }


            }


        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addTotalScores(int sum ,String topic){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String qry = "INSERT INTO scoretable(user,score,topic)"+ " Values (?,?,?);";
            PreparedStatement stmt = con.prepareStatement(qry);
            stmt.setString(1,u);
            stmt.setInt(2,sum);
            stmt.setString(3,topic);

            stmt.execute();
            con.close();


        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String correctAnswer(String answer){

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select * from multichoicequiz where correctAnswer=?" ;
            PreparedStatement stmt = con.prepareStatement(q);
            stmt.setString(1,answer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                if (answer.equalsIgnoreCase(rs.getString("correctAnswer"))){
                    scoreCounter++;
                }
            }
            System.out.println("Total score is:"+(scoreCounter-1));

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public String correctAnswerB(String answer){

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "Select * from binaryquiz where correctAnswer=?" ;
            PreparedStatement stmt = con.prepareStatement(q);
            stmt.setString(1,answer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                if (answer.equalsIgnoreCase(rs.getString("correctAnswer"))){
                    scoreCounter++;
                }
                /** System.out.println("Correct answer");
                 System.out.println("Your Wrong!"); */
            }
            System.out.println("Total score is:"+(scoreCounter-1));

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public void createMultipleChoiceQuestions(){  /**this method was used for adding the questions to the table*/
        try {

            Class.forName(myDriver);
            Scanner input = new Scanner(System.in);
            System.out.println("Add an id:");
            String i = input.next();
            int id = Integer.parseInt(i);
            System.out.println("Add a question:");
            String q = input.next();
            q+= input.nextLine();
            System.out.println("Add a answerA:");
            String a= input.next();
            a+= input.nextLine();
            System.out.println("Add a answerB");
            String b = input.next();
            b+= input.nextLine();
            System.out.println("Add a answerC");
            String c = input.next();
            c+= input.nextLine();
            System.out.println("Add a answerD");
            String d = input.next();
            d+= input.nextLine();
            System.out.println("Add a correctAnswer");
            String ca = input.nextLine();
            Connection con = DriverManager.getConnection(url,user,password);
            String q1 = "INSERT  INTO multichoicequiz(id,question,answerA,answerB,answerC,answerD, correctAnswer)" +
                    "Values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(q1);
            stmt.setInt(1,id);
            stmt.setString(2,q);
            stmt.setString(3,a);
            stmt.setString(4,b);
            stmt.setString(5,c);
            stmt.setString(6,d);
            stmt.setString(7,ca);

            stmt.execute();
            con.close();

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createBinaryQuestions(){ /**this method creates questions for the binaryQuiz*/
        try {

            Class.forName(myDriver);
            Scanner input = new Scanner(System.in);
            System.out.println("Add an id:");
            String i = input.next();
            int id = Integer.parseInt(i);
            System.out.println("Add a question:");
            String q = input.next();
            q+= input.nextLine();
            System.out.println("Add a correctAnswer:");
            String c = input.nextLine();
            Connection con = DriverManager.getConnection(url,user,password);
            String q1 = "INSERT  INTO binaryquiz(id,question,correctAnswer)" +
                    "Values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(q1);
            stmt.setInt(1,id);
            stmt.setString(2,q);
            stmt.setString(3,c);
            stmt.execute();
            con.close();

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showScoreTable(){
        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url,user,password);
            String q = "SELECT * FROM scoretable";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("user") + " " +rs.getInt("score") + " "+ rs.getString("topic"));
            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showUserScoreTable(){
        try {


            Class.forName(myDriver);
            Scanner input = new Scanner(System.in);
            System.out.println("Search user in the scoretable:");
            String s = input.nextLine();

            Connection con = DriverManager.getConnection(url,user,password);
            String q = "SELECT * FROM scoretable WHERE user=?";
            PreparedStatement stmt = con.prepareStatement(q);
            stmt.setString(1,s);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("user") + " " +rs.getInt("score") + " "+ rs.getString("topic"));
            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void listScoreLargerThan3(){
        try {
            Class.forName(myDriver);

            Connection con = DriverManager.getConnection(url,user,password);
            String q = "SELECT * FROM scoretable WHERE score >=3";
            PreparedStatement stmt = con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("user") + " " +rs.getInt("score") + " "+ rs.getString("topic"));
            }

        } catch (ClassNotFoundException e) {
            e.hashCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
