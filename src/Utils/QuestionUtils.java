package Utils;

import Model.*;

import java.util.Random;

public class QuestionUtils {
    public QuestionUtils(){

    }
    Random random = new Random();
    int randomNumber = 0;
    public int getRandomQuestionIndex(int upperBound, int[] alreadyUsedQuestionsArray){
        boolean isNumberAlreadyUsed = false;
        int i;
        do{
            randomNumber = random.nextInt(upperBound);
            for(i=0; i<3; i++){
                isNumberAlreadyUsed = false;
                if(randomNumber == alreadyUsedQuestionsArray[i]){
                    isNumberAlreadyUsed = true;
                    break;
                }
            }
        }while(isNumberAlreadyUsed);
        return randomNumber;
    }

}
