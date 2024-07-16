package com.freeGPT.utils;

public class Stream {
    
    /**
     * Prints each character of the given text with a specified delay between each character.Used just to simulate streaming.
     *
     * @param text  the text to be streamed
     * @param delay the delay (in milliseconds) between each character
     */
    public static void streamText(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
        }
        System.out.println();
    }
}
