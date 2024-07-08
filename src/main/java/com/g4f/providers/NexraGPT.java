package com.g4f.providers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONObject;

import com.g4f.Message;
import com.g4f.utils.RequestBodyNexra;

public class NexraGPT {
    private String name;
    private String url;
    private String type;
    private String defaultModel;
    private boolean historyAble;
    private boolean stream;
    private boolean markdown;

    public NexraGPT() {
        this.name = "NexraGPT no api key";
        this.url = "https://nexra.aryahcr.cc/api/chat/gpt";
        this.type = "Chat";
        this.defaultModel = "gpt-4";
        this.historyAble = true;
        this.stream = false;
        this.markdown = false;

    }
    
    public JSONObject getCompletions(ArrayList<Message> msgs, String prompt){
        RequestBodyNexra body = new RequestBodyNexra(msgs, this.stream, prompt, this.defaultModel, this.markdown);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .setHeader("Content-Type", "application/json")
        .uri(URI.create(url))
        .POST(HttpRequest.BodyPublishers.ofString(body.getJSONBody().toString()))
        .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new JSONObject(response.body().toString());
        } catch (Exception e) {
            System.out.println("There was an error"+e.toString());
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDefaultModel() {
        return defaultModel;
    }

    public void setDefaultModel(String defaultModel) {
        this.defaultModel = defaultModel;
    }

    public boolean isHistoryAble() {
        return historyAble;
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
