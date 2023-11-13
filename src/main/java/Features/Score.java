package Features;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score {
    //Modificar aq caso o diretorio ou o tipo do arquivo mude
    private String scoreFilePath = "playerScore.txt";
    private File scoreFile = new File(scoreFilePath);
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

    public void saveScore(String name, int score){
        try {
            FileWriter writeScore = new FileWriter(scoreFilePath);
            writeScore.write(name + " " + score);
            writeScore.close();
            //Adicionar função para salvar apenas 10 Scores
            System.out.println("Score Saved");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
