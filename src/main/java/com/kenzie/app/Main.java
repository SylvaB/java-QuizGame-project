package com.kenzie.app;

// import necessary libraries


import DTO.Clues;
import DTO.QuizDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */
   static final String GET_URL = "https://jservice.kenzie.academy/api/clues";
   public static ObjectMapper objectMapper = new ObjectMapper();

   public static ArrayList<Integer> questionId() throws JsonProcessingException {
       QuizDTO qAndADTO = objectMapper.readValue(CustomHttpClient.sendGET(GET_URL), QuizDTO.class);
       ArrayList<Integer> questionID = new ArrayList<>();
       int currentQuestionID;

       for(int i = 0;i< qAndADTO.getClues().size(); i++) {
            currentQuestionID= qAndADTO.getClues().get(i).getId();
            questionID.add(currentQuestionID);
       }
          return questionID;
   }

    public static int getRandomQuestionId() throws IOException, InterruptedException {
        Random r = new Random();
        int randomQ =r.nextInt(questionId().size());

        return randomQ;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //Write main execution code here
        try{

        //declare variables
        Scanner userInput = new Scanner(System.in);
        QuizDTO qAndADTO = objectMapper.readValue(CustomHttpClient.sendGET(GET_URL), QuizDTO.class);
        int correctAnswCount =0;
        String userAnswer = "";
        int questionNum = 10;
        System.out.println("Welcome to Quiz Me!");

        for (int i = 0; i < questionNum; i++) {
            System.out.println("Question# "+ (i+1));
            int randomQId = getRandomQuestionId();
            System.out.println("Category: " +  qAndADTO.getClues().get(randomQId).getCategory().getTitle()+
                                    "\n" + "Question: " + qAndADTO.getClues().get(randomQId).getQuestion());
            System.out.println("Type your answer here: ");
            String answer = qAndADTO.getClues().get(randomQId).getAnswer();
            userAnswer = userInput.nextLine();

            if (userAnswer.equalsIgnoreCase(answer)) {
                correctAnswCount += 1;
                System.out.println("This is the correct answer! Well done! You have " + correctAnswCount + " points in total.");
            } else {
                System.out.println("Wrong answer!");
                System.out.println("The correct answer is: " + answer);
            }
            System.out.println();
        }
            System.out.println("Thank you for playing! You have " +correctAnswCount + " points.");
        }

        catch (Exception e){
            System.out.println("No question found");

        }
    }
}

