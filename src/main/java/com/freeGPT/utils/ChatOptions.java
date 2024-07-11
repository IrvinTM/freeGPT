package com.freeGPT.utils;

public class ChatOptions {
    private boolean debug;
    private String model;
    private String provider;
    private boolean stream;
    private boolean markdown;
    private int chunkSize;

    public ChatOptions() {
    }

    public ChatOptions(boolean debug, String model, String provider, boolean stream, String conversationStyle,
            boolean markdown, int chunkSize) {
        this.debug = debug;
        this.model = model;
        this.provider = provider;
        this.stream = stream;
        this.markdown = markdown;
        this.chunkSize = chunkSize;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }
    
}
