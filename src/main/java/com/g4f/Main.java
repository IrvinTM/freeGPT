package com.g4f;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> msg = new ArrayList<Message>();
        msg.add(new Message("assistant", "Hello! How are you today?"));
        msg.add(new Message("user", "Hello, my name is Yandri."));
        msg.add(new Message("assistant", "Hello, Yandri! How are you today?."));
    
        AI ai = new AI();
        ai.setModel("code-davinci-002");
        ai.setHistoryAble(true);
        ai.setMessages(msg);
        ai.setPrompt("what ai model are you?");

        System.out.println(ai.getCompletionJSON());


        //TODO fix streaming 


    }
    
}