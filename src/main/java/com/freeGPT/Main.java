package com.freeGPT;

import java.util.ArrayList;

import com.freeGPT.utils.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> msg = new ArrayList<Message>();
        msg.add(new Message("assistant", "Hello! How are you today?"));
        msg.add(new Message("user", "Hello, my name is Yandri."));
        msg.add(new Message("assistant", "Hello, Yandri! How are you today?."));
    
        AI ai = new AI();

        ai.setModel(ai.getModels()[0]);
        System.out.println("using model"+ ai.getModel());
        Stream.streamText(ai.getCompletionString(), 50);
        
    
        /* ai.getCompletionsStream(); */
        /* String[] models = ai.getModels();
        for (String model: models){
            ai.setModel(model);
            System.out.println(model);
            ai.setPrompt("Cual modelo eres y cual es tu llimite de tokens");
            System.out.println(ai.getCompletionString());
            System.out.println();
        } */
        // ai.setModel("GPT-4");
        // ai.setHistoryAble(true);
        // ai.setMessages(msg);
        // ai.setPrompt("what ai model are you?");
        // ai.setStream(false);

        // System.out.println(ai.getCompletionJSON());


        //TODO fix streaming 


    }

    
    
}