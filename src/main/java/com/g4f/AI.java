package com.g4f;

public class AI {
    private String model;
    private String type;
    private boolean historyAble;
    private boolean stream;
    private boolean markdown;

    
    public AI() {
        
    }

    public AI(String model, String type, String defaultModel, boolean historyAble, boolean stream, boolean markdown) {
        this.model = model;
        this.type = type;
        this.historyAble = historyAble;
        this.stream = stream;
        this.markdown = markdown;
    }

    public getCompletionString(){
        
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
    public void setType(String type) {
        this.type = type;
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
