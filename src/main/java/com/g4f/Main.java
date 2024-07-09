package com.g4f;

import java.util.ArrayList;

import com.g4f.providers.NexraGPT;

// import com.g4f.providers.NexraGPT;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> msg = new ArrayList<Message>();
        msg.add(new Message("assistant", "Hello! How are you today?"));
        msg.add(new Message("user", "Hello, my name is Yandri."));
        msg.add(new Message("assistant", "Hello, Yandri! How are you today?."));
    
        // AI ai = new AI();
        // ai.setModel("gpt-3.5-turbo");
        // ai.setHistoryAble(true);
        // ai.setMessages(msg);
        // ai.setPrompt("can you repeat my name please?");
        

        NexraGPT ai = new NexraGPT();
        ai.setDefaultModel("chatgpt");
        ai.setStream(true);
        ai.getStreamedCompletions(msg, "hello");

        // NexraGPT gpt = new NexraGPT();
        // gpt.setDefaultModel("gpt-3.5-turbo");
        // String result = gpt.getCompletions(msg, "what version of ai model are you").toString();
        // System.out.println(result);

        //TODO Implement streaming 


    }
    
}