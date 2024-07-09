package com.g4f;

import java.util.ArrayList;
import org.json.JSONObject;
import com.g4f.providers.NexraGPT;

public class AI {
    private ArrayList<Message> messages;
    private String prompt;
    private String model;
    private String type;
    private boolean historyAble;
    private boolean stream;
    private boolean markdown;

    
    public AI() {
        
    }

    public AI(ArrayList<Message> messages, String prompt,String model, String type, String defaultModel, boolean historyAble, boolean stream, boolean markdown) {
        this.messages = messages;
        this.prompt = prompt;
        this.model = model;
        this.type = type;
        this.historyAble = historyAble;
        this.stream = stream;
        this.markdown = markdown;
    }

    public String getCompletionString(){
        NexraGPT gpt = new NexraGPT();
        gpt.setDefaultModel(this.model);
        gpt.setMarkdown(this.markdown);
        gpt.setStream(this.stream);
        JSONObject response = gpt.getCompletions(this.messages, this.prompt);
        String messageResponse = response.getString("gpt");
        return messageResponse;
    }

    public JSONObject getCompletionJSON(){
        NexraGPT gpt = new NexraGPT();
        gpt.setDefaultModel(this.model);
        gpt.setMarkdown(this.markdown);
        gpt.setStream(this.stream);
        JSONObject response = gpt.getCompletions(this.messages, this.prompt);
        Message assisstantMessage = new Message("assistant", response.getString("gpt"));
        JSONObject messageResponse = new JSONObject(assisstantMessage);
        return messageResponse;
    }


    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }

    public boolean isHistoryAble() {
        return historyAble;
    }
    public void setHistoryAble(boolean historyAble) {
        this.historyAble = historyAble;
    }
    public boolean isStream() {
        return stream;
    }
    public void setStream(boolean stream) {
        this.stream = stream;
    }
    public boolean isMarkdown() {
        return markdown;
    }
    public void setMarkdown(boolean markdown) {
        this.markdown = markdown;
    }
}
