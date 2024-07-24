package com.freeGPT;

import java.util.ArrayList;
import java.util.Scanner;

import com.freeGPT.utils.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> msg = new ArrayList<Message>();
    
        AI ai = new AI();

        ai.setModel(ai.getModels()[0]);
        System.out.println("using model"+ ai.getModel());
        ai.setMessages(msg);

        Scanner sc  = new Scanner(System.in);


        while (true) {
            String prompt;
            String response;
            prompt = sc.nextLine();
            if (prompt == "exit") {
                break;
            }
            ai.setPrompt(prompt);
            response = ai.getCompletionString();
            Stream.streamText(ai.getCompletionString(), 50);
            msg.add(new Message("user", prompt));
            msg.add(new Message("assistant", response));

        }
        sc.close();
    }

    
    
}