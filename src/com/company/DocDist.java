package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DocDist {
    private String Doc1;
    private String Doc2;

    public DocDist(String doc1, String doc2) {
        Doc1 = doc1;
        Doc2 = doc2;
    }

    public void getDistinctOfFiles() throws IOException {
        Map<String, Integer> freq_map1 = getFileFreq(Doc1);
        Map<String, Integer> freq_map2 = getFileFreq(Doc2);

        double distance = vector_angle(freq_map1, freq_map2);
        System.out.printf("The distance between the documents is: {0}f (radians)",distance);
    }

    private double vector_angle(Map<String, Integer> M1, Map<String, Integer> M2){
        double numerator = inner_product(M1, M2);
        double denominator = Math.sqrt(inner_product(M1, M2) * inner_product(M1, M2));
        return Math.acos(numerator/denominator);
    }

    private double inner_product(Map<String, Integer> M1, Map<String, Integer> M2){
        double sum = 0.0;
        for (Map.Entry<String, Integer> entry: M1.entrySet()) {
            if (M2.containsKey(entry.getKey())){
                sum+=entry.getValue() * M2.get(entry.getKey());
            }
        }
        return sum;
    }

    private Map<String, Integer> getFileFreq(String filename) throws IOException {
        String text = read_file(filename);
        String[] words_array = get_words_array(text);
        Map<String, Integer> freq_mapping = count_frequency(words_array);

        System.out.println("File: "+filename);
        System.out.println(words_array.length+" words,");
        System.out.println(freq_mapping.size()+" distinct words");

        return freq_mapping;
    }

    private String read_file(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        return content;
    }
    private String[] get_words_array(String text){
        String new_text = new String();
        String replaced = text.replaceAll("(\\W|$)", "\\s");

        String[] words_array = replaced.split("\\s");
        return words_array;
    }

    private void insertion_sort(int[] array){
        //O(n)
        for (int i = 0; i<array.length; i++){
            //O(1)
            int key = array[i];
            //O(1)
            int j = i-1;
            //O(n)
            while (j > -1 && array[j] > key){
                array[j+1] = array[j];
            }
            //O(n)
            array[j] = key;
        }
    }

    private HashMap<String, Integer> count_frequency(String[] words_array){
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words_array) {
            int value = 0;
            if (freqMap.get(word) != null) value = freqMap.get(word);
            freqMap.put(word, value++);
        }
        return freqMap;
    }
}
