package com.g4f;

import java.util.ArrayList;

import com.g4f.providers.NexraGPT;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> msg = new ArrayList<Message>();
        msg.add(new Message("assistant", "Hello! How are you today?"));
        msg.add(new Message("user", "Hello, my name is Yandri."));
        msg.add(new Message("assistant", "Hello, Yandri! How are you today?."));
    

        NexraGPT gpt = new NexraGPT();
        gpt.setDefaultModel("gpt-3.5-turbo");
        gpt.getCompletions(msg, "what version of ai model are you");
    }
    
}