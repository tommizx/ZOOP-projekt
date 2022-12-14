package Stages;

import Model.*;
import Model.Math;
import Utils.*;

import java.util.Scanner;

public class Game {
    public Game() {
        this.categoryNumber = 0;
        this.questionsUtils = new QuestionUtils();
        this.sc = new Scanner(System.in);
        this.gameStageString = "start";
    }

    int categoryNumber;
    String basicInput;
    public String gameStageString;
    String userAnswer;
    QuestionUtils questionsUtils;
    ActiveUser activeUser;
    Category selectedCategory;
    ActiveUser[] activeUserArray = new ActiveUser[100];
    Scanner sc;
    Leaderboard leaderboard = new Leaderboard();
    public void userLoginStage() {
        System.out.println("Ahoj, program mozes kedykolvek ukoncit zadanim slova 'exit' ");
        System.out.println("Zadaj svoje meno : ");
        basicInput = sc.nextLine();
        GeneralUtils.exitCheck(basicInput);
        activeUser = new ActiveUser(basicInput);
        System.out.println("Ahoj, " + activeUser.getUserName() + "! :)");
        for(int i=0; i<activeUserArray.length; i++){
            if(activeUserArray[i]==null){
                activeUserArray[i] = activeUser;
                break;
            }
        }
        if(basicInput.equals("admin")){
            gameStageString = basicInput;
        }
        else{
            gameStageString = "selection";
        }
    }
    public void leaderboardStage(){
        ActiveUser k;
        if(activeUserArray[0]!=null){
            for(int m=0; m<3; m++){
                for(int i=0; i<100; i++){
                    if(activeUserArray[i+1]==null){
                        break;
                    }
                    for(int j=i+1; j<100; j++){
                        if(activeUserArray[j]!=null){
                            if(activeUserArray[i].activeUserHighestScoreArray[m] < activeUserArray[j].activeUserHighestScoreArray[m]){
                                k = activeUserArray[i];
                                activeUserArray[i] = activeUserArray[j];
                                activeUserArray[j] = k;
                            }
                        }
                    }
                }
                if(m==0){
                    leaderboard.generalKnowledgeLeaderboard = activeUserArray;
                }
                else if(m==1){
                    leaderboard.mathLeaderboard = activeUserArray;
                }
                else{
                    leaderboard.geographyLeaderboard = activeUserArray;
                }
            }
        }
        for(int i=0; i<100; i++){
            if(activeUserArray[i]!=null){
                System.out.println(activeUserArray[i].getUserName() + " --> " + activeUserArray[i].activeUserHighestScoreArray[0]);
            }
        }
        do{
            System.out.println("Ak sa chces vratit na vyber kategorie, napis 'selection'.");
            System.out.println("Ak sa chces odhlasit, napis 'logout'. ");
            basicInput = sc.nextLine();
            GeneralUtils.exitCheck(basicInput);
        }while( !(basicInput.equals("selection")) && (!basicInput.equals("logout")) );
        gameStageString = basicInput;
    }
    public void categorySelectionStage(){
        do{
            System.out.println("Vyber si kategoriu, v ktorej budes sutazit - General Knowledge (1), Math (2), Geography (3). ----> Zadaj cislo kategorie : ");
            System.out.println("Ak chces zobrazit leaderboard, napis 'leaderboard' ");
            do{
                basicInput = sc.nextLine();
                if(basicInput.equals("leaderboard")){
                    break;
                }
                if(GeneralUtils.isNumeric(basicInput)){
                    categoryNumber = Integer.parseInt(basicInput);
                }
                else{
                    GeneralUtils.exitCheck(basicInput);
                    System.out.println("Pre vyber kategorie musis zadat cislo!");
                }
            }while(!GeneralUtils.isNumeric(basicInput));
            if( (categoryNumber != 1) && (categoryNumber != 2) && (categoryNumber != 3) && !(basicInput.equals("leaderboard")) ){
                System.out.println("Kategoria s tymto cislom neexistuje!");
            }
        } while ( (categoryNumber != 1) && (categoryNumber != 2) && (categoryNumber != 3) && !(basicInput.equals("leaderboard")) );
        if(categoryNumber == 1){
            selectedCategory = (Category)new GeneralKnowledge(); //upcasting
        }
        else if(categoryNumber == 2){
            selectedCategory = (Category)new Math(); //upcasting
        }
        else{
            selectedCategory = (Category)new Geography(); //upcasting
        }
        if(basicInput.equals("leaderboard")){
            gameStageString = basicInput;
        }
        else{
            gameStageString = "play";
        }
    }
    public void adminStage(){
        ActiveUser tempUser = activeUser;
        activeUser = new AdminUser();
        do {
            System.out.println("Zadaj 'reset' ak chces zmazat cely leaderboard. Pozor! Tato akcia sa neda vratit.");
            System.out.println("Ak sa chces vratit do normalneho rezimu, napis 'logout'.");
            System.out.println("Ak chces ukoncit hru, napis 'exit'.");
            basicInput = sc.nextLine();
            GeneralUtils.exitCheck(basicInput);
            if (basicInput.equals("test")){
                SecondStage secondStage = SecondStage.createSecondStage();
                System.out.println(secondStage.getStageName());
            }
            if (basicInput.equals("reset")) {
                if(activeUser instanceof AdminUser){
                    ((AdminUser) activeUser).resetLeaderboard(leaderboard, activeUserArray); //downcasting
                    System.out.println("Leaderboard bol vymazany!");
                }
                gameStageString = "logout";
            }
            else if (basicInput.equals("logout")) {
                gameStageString = "logout";
            }
            else {
                System.out.println("Tento prikaz neexistuje.");
            }
        }while( (!basicInput.equals("reset")) && (!basicInput.equals("logout")) );
        activeUser = tempUser;
    }
    public void gameStage() {
        int[] alreadyUsedQuestionsArray = new int[3];
        System.out.println("Vybral si si kategoriu " + selectedCategory.getCategoryName());
        activeUser.resetPoints(activeUser);
        for (int i = 0; i < 3; i++) {
            int questionNumber = questionsUtils.getRandomQuestionIndex(5, alreadyUsedQuestionsArray);
            System.out.println(selectedCategory.questionArray[questionNumber]);
            userAnswer = sc.nextLine();
            GeneralUtils.exitCheck(userAnswer);
            if (selectedCategory instanceof GeneralKnowledge) {
                activeUser.setActiveUserPoints(activeUser.getActiveUserPoints() + selectedCategory.isAnswerCorrect(questionNumber, userAnswer));
            } else if (selectedCategory instanceof Math) {
                activeUser.setActiveUserPoints(activeUser.getActiveUserPoints() + selectedCategory.isAnswerCorrect(questionNumber, userAnswer));
            } else if (selectedCategory instanceof Geography) {
                activeUser.setActiveUserPoints(activeUser.getActiveUserPoints() + selectedCategory.isAnswerCorrect(questionNumber, userAnswer));
            }

//            activeUser.setActiveUserPoints(activeUser.getActiveUserPoints() + questionsUtils.isAnswerCorrect(questionNumber, userAnswer, selectedCategory));
            alreadyUsedQuestionsArray[i] = questionNumber;
        }
        if (activeUser.activeUserHighestScoreArray[selectedCategory.getCategoryNumber() - 1] < activeUser.getActiveUserPoints()) {
            System.out.println("Dosiahol/la si nove najvyssie skore v tejto kategorii! Predosle najvyssie skore : " + activeUser.activeUserHighestScoreArray[selectedCategory.getCategoryNumber() - 1]);
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
        if(basicInput.equals("exit")){
            final String exitString = basicInput;
        }
    }
}