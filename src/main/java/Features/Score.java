package Features;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score {

    private String scoreFilePath = "playerScore.txt";
    private File scoreFile = new File(scoreFilePath);
    private String[] scoreList = new String[10];

    public void createScoreFile(){
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

    public void saveScore(){
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

    public void sortScore(String name, int score){
        try {
            Scanner sc = new Scanner(scoreFile);
            for (int i = 0; i < 10 || sc.hasNextLine(); i++){
                scoreList[i] = sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(int i = 0; i < 10; i++){
            if(scoreList[i] == null || scoreList[i].equals("")){
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

    public void printScore(){
        try {
            Scanner sc = new Scanner(scoreFile);
            System.out.println("Name  ->  Score");
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}