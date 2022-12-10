package Stages;

import Model.*;
import Model.Math;
import Utils.*;

import java.util.Scanner;

public class Game {
    public Game() {
        this.categoryArray[0] = new GeneralKnowledge();
        this.categoryArray[1] = new Math();
        this.categoryArray[2] = new Geography();;
        this.categoryNumber = 0;
        this.questionsUtils = new QuestionUtils();
        this.activeUser = new ActiveUser();
        this.sc = new Scanner(System.in);
        this.gameStageString = "start";
    }

    public int categoryNumber;
    public String basicInput;
    public String gameStageString;
    public String userAnswer;
    public QuestionUtils questionsUtils;
    public ActiveUser activeUser;
    public Category categoryArray[] = new Category[3];
    public Category selectedCategory;
    Scanner sc;

    public void userLoginStage() {
        System.out.println("Ahoj, program mozes kedykolvek ukoncit zadanim slova 'exit' ");
        System.out.println("Zadaj svoje meno : ");
        basicInput = sc.nextLine();
        GeneralUtils.exitCheck(basicInput);
        String activeUserName = basicInput;
        activeUser.setUserName(activeUserName);
        System.out.println("Ahoj, " + activeUser.getUserName() + "! :)");
        for (int i = 0; i < 3; i++) {
            PointsUtils.setHighestScore(activeUser, categoryArray[i]);
        }
    }
    public void categorySelectionStage(){
        do{
            System.out.println("Vyber si kategoriu, v ktorej budes sutazit - General Knowledge (1), Math (2), Geography (3). ----> Zadaj cislo kategorie : ");
            do{
                basicInput = sc.nextLine();
                if(GeneralUtils.isNumeric(basicInput)){
                    categoryNumber = Integer.parseInt(basicInput);
                }
                else{
                    GeneralUtils.exitCheck(basicInput);
                    System.out.println("Pre vyber kategorie musis zadat cislo!");
                }
            }while(!GeneralUtils.isNumeric(basicInput));

            if( (categoryNumber != 1) && (categoryNumber != 2) && (categoryNumber != 3) ){
                System.out.println("Kategoria s tymto cislom neexistuje!");
            }
        } while ( (categoryNumber != 1) && (categoryNumber != 2) && (categoryNumber != 3) );
        if(categoryNumber == 1){
            selectedCategory = new GeneralKnowledge();
        }
        else if(categoryNumber == 2){
            selectedCategory = new Math();
        }
        else{
            selectedCategory = new Geography();
        }
    }
    //        GeneralUtils.selectCategory(categoryNumber, selectedCategory);
    public void gameStage() {
        System.out.println("Vybral si si kategoriu " + selectedCategory.getCategoryName());
        PointsUtils.resetPoints(activeUser);
        for (int i = 0; i < 3; i++) {
            int randomNumber = questionsUtils.getRandomQuestionIndex(5);
            System.out.println(selectedCategory.questionArray[randomNumber]);
            userAnswer = sc.nextLine();
            GeneralUtils.exitCheck(userAnswer);
            activeUser.setActiveUserPoints(activeUser.getActiveUserPoints() + questionsUtils.isAnswerCorrect(categoryNumber, randomNumber, userAnswer));

        }
        if (selectedCategory.getActiveHighestScore() < activeUser.getActiveUserPoints()) {
            System.out.println("Dosiahol si nove najvyssie skore v tejto kategorii! Predosle najvyssie skore : " + selectedCategory.getActiveHighestScore());
            PointsUtils.setHighestScore(activeUser, selectedCategory);
        }
        System.out.println("Ziskal si " + activeUser.getActiveUserPoints() + " z 3 bodov!");
        if (activeUser.getActiveUserPoints() >= 2) {
            System.out.println("Dobra praca " + activeUser.getUserName() + " :)");
        }
        do {
            System.out.println("Ak chces hrat znova, napis 'retry'. ");
            System.out.println("Ak sa chces vyskusat v inej kategorii, napis 'selection'. ");
            System.out.println("Ak sa chces odhlasit, napis 'logout'. ");
            basicInput = sc.nextLine();
            gameStageString = basicInput;
        } while (!(basicInput.equals("retry")) && !(basicInput.equals("selection")) && !(basicInput.equals("logout")) && !(basicInput.equals("exit")));
    }
}