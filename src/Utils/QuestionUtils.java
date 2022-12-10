package Utils;

import Model.GeneralKnowledge;
import Model.Math;
import Model.Geography;

import java.util.Random;

public class QuestionUtils {
    public QuestionUtils(){

    }
    Random random = new Random();
    int randomNumber = 0;
    public int getRandomQuestionIndex(int upperBound){
        randomNumber = random.nextInt(upperBound);
        return randomNumber;
    }
    public int isAnswerCorrect(int categoryNumber, int randomNumber, String userAnswer){
        int result = 0;
        if(categoryNumber == 1){
            GeneralKnowledge generalKnowledgeCategory = new GeneralKnowledge();
            if(userAnswer.equals(generalKnowledgeCategory.answerArray[randomNumber])){
                result = 1;
            }
            else{
                result = 0;
            }
        }
        else if(categoryNumber == 2){
            Math mathCategory = new Math();
            if(userAnswer.equals(mathCategory.answerArray[randomNumber])){
                result = 1;
            }
            else{
                result = 0;
            }
        }
        else if(categoryNumber == 3){
            Geography geographyCategory = new Geography();
            if(userAnswer.equals(geographyCategory.answerArray[randomNumber])){
                result = 1;
            }
            else{
                result = 0;
            }
        }
        return result;
    }
}
