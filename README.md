# Wrapper Library for ChatGPT and Other AI Models

A simple library wrapper for different AI models.

## Dependencies
Requires [org.json](https://mvnrepository.com/artifact/org.json/json)

## Installation

You can add the jar as a dependency in your project.

If you want to try it, you can also download the [Jar with dependencies](https://github.com/IrvinTM/freeGPT/releases/download/1.0/g4f-1.0-SNAPSHOT-jar-with-dependencies.jar) and do:

```bash
java -jar g4f-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Usage

Create a new object from the main class AI:

```Java
AI ai = new AI();
```
You can set the parameters with the getters and setters or directly in the constructor:
```Java
/**
     * @param messages     the list of messages
     * @param prompt       the prompt message
     * @param model        the model to use
     * @param type         the type of AI
     * @param defaultModel the default model
     * @param historyAble  indicates if history is enabled
     * @param stream       indicates if streaming is enabled
     * @param markdown     indicates if markdown is enabled
     */
```

Now you can use the methods.

```Java
ai.getCompletionString(); 
```
*Returns the completion string generated by the NexraGPT provider.*

```Java
ai.getCompletionJSON(); 
```
*Returns the completion JSON response as a 'JSONObject'.*