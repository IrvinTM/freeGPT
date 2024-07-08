package com.g4f.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.g4f.Message;

public class RequestBodyNexra {
    private ArrayList<Message> messages;
    private boolean stream;
    private String prompt;
    private String model;
    private boolean markdown;

    public RequestBodyNexra(ArrayList<Message> messages, boolean stream, String prompt, String model, boolean markdown) {
        this.messages = messages;
        this.stream = stream;
        this.prompt = prompt;
        this.model = model;
        this.markdown = markdown;
    }

    public JSONObject getJSONBody(){
        JSONArray jsonMesages = new JSONArray(this.messages);
        JSONObject body = new JSONObject();
        body.put("messages", jsonMesages);
        body.put("stream", this.stream);
        body.put("prompt", this.prompt);
        body.put("model", this.model);
        body.put("markdown", this.markdown);
        return body;
    }
}