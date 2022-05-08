package com.geekbrains.homeworklesson3;

import java.util.HashMap;
import java.util.Map;

public class Homework3Task1 {

    private static final String[] INPUT_DATA = {
            "a",
            "b", "b", "b",
            "c",
            "d",
            "e", "e",
            "f",
            "g", "g", "g",
            "h",
            "g",
            "i"
    };

    public static void main(String[] args) {
        Map<String, Integer> frequencyByWord = new HashMap<>();

        for (String word : INPUT_DATA) {
            Integer frequency = frequencyByWord.get(word);
            if (frequency == null) {
                frequency = 0;
            }

            frequencyByWord.put(word, frequency + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyByWord.entrySet()) {
            System.out.printf("Слово %s встречается %d раз %n", entry.getKey(), entry.getValue());
        }
    }
}
