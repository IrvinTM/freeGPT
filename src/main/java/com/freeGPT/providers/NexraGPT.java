package com.freeGPT.providers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONObject;

import com.freeGPT.Message;
import com.freeGPT.utils.RequestBodyNexra;

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
    
    public JSONObject getCompletions(ArrayList<Message> messages, String prompt){
        RequestBodyNexra body = new RequestBodyNexra(messages, this.stream, prompt, this.defaultModel, this.markdown);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .setHeader("Content-Type", "application/json")
        .uri(URI.create(url))
        .POST(HttpRequest.BodyPublishers.ofString(body.getJSONBody().toString()))
        .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
        } catch (Exception e) {
            System.out.println("There was an error"+e.toString());
        }
        return new JSONObject(response.body().toString());
    }

    public void getStreamedCompletions(ArrayList<Message> messages, String prompt){
        RequestBodyNexra body = new RequestBodyNexra(messages, this.stream, prompt, this.defaultModel, this.markdown);
        // System.out.println("aqui el cuerpo"+ body.getJSONBody());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .setHeader("Content-Type", "application/json")
        .uri(URI.create("https://nexra.aryahcr.cc/api/chat/complements"))
        .POST(HttpRequest.BodyPublishers.ofString(body.getJSONBody().toString()))
        .build();
        HttpResponse<InputStream> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofInputStream()); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String[] parts = sb.toString().split("\u001e");
            for(String part: parts){
                try {
                    JSONObject obj = new JSONObject(part);
                    if (obj.getBoolean("finish")== true) {
                        break;
                    }
                    System.out.println(obj.getString("message"));
                    Thread.sleep(500);
                    System.out.print("\033[H\033[2J");
                    System.out.println("");
                    
                    
                } catch (Exception e) {
                    System.out.println("Experimental method please use another option");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("There was an error"+e.toString());
        }}
        
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
