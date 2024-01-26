package Features;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Score {

    private static String scoreFilePath = "./scoreFileFolder/playerScore.txt";
    private static File scoreFile = new File(scoreFilePath);
    private static String[] scoreList = new String[10];

    public static void createScoreFile(){
        try{
            if(scoreFile.createNewFile()){
                System.out.println("File created: " + scoreFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveScore(){
        try {
            FileWriter writeScore = new FileWriter(scoreFilePath);
            for(String score : scoreList){
                writeScore.write(score + System.lineSeparator());
            }
            writeScore.close();
            System.out.println("Score Saved");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void sortScore(int score){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy|HH:mm:ss");
        String name = myDateObj.format(myFormatObj);
        System.out.println(name);
        try {
            Scanner sc = new Scanner(scoreFile);
            for (int i = 0;sc.hasNextLine(); i++){
                scoreList[i] = sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(int i = 0; i < 10; i++){
            if(scoreList[i] == null || scoreList[i].equals("") || scoreList[i].equals("null")){
                scoreList[i] = (name + " " + score);
                break;
            }else {
                String[] aux = scoreList[i].split(" ");
                if(score >= Integer.parseInt(aux[1])) {
                    scoreList[i] = (name + " " + score);
                    name = aux[0];
                    score = Integer.parseInt(aux[1]);
                }
            }
        }
    }

    public static void printScore(JTextArea textArea) {
        try {
            Scanner sc = new Scanner(scoreFile);
            textArea.append("Name  ->  Score\n");
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                textArea.append(data + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}