package controller;

import model.Sentence;
import model.Text;
import model.Word;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader {

    public String readText(String file){
        String text = "";
        BufferedReader bf;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder sb = new StringBuilder();
            while((text=bf.readLine())!=null) {
                sb.append(text);
            }
            text=sb.toString();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String replaceSymbols(String text){
        String textout = "";
        String [] words = text.split(" ");
        if(text.length()<2 && words[0].equals("")){
            return textout =" ";
        }else{
            for (int i = 0; i < words.length; i++) {
                if (words[i].isEmpty()&&words[i+1].isEmpty()&&words[i+2].isEmpty()&&words[i+3].isEmpty()){
                    words[i]=" ";
                    i=i+3;
                    textout+=words[i];
                }else{
                    if(!words[i].isEmpty())
                        textout+=words[i]+" ";
                }
            }
            return textout;
        }
    }

    public String findMaxRepeatedWord(String rep) {
        String[] repeated = rep.split(" ");
        int count = 0;
        int max = 0;
        String maxRep = "";
        for (int i = 0; i < repeated.length - 1; i++) {
            for (int j = 0; j < repeated.length - 1; j++) {
                if (repeated[i].equals(repeated[j])) {
                    count++;
                }
                if (count > max) {
                    max = count;
                    maxRep = repeated[j];
                }
            }
            count = 0;
        }
        System.out.println("count: "+max);
        return maxRep;
    }


    public static Sentence findSentenceWithMaxRepeatedWord(Text text) {
        Sentence sentence = new Sentence();
        Word word = new Word();
        int count = 0;
        int max = 0;
        int sentencefinder = 0;
        for (int i = 0; i < text.size(); i++) {
            sentence = text.getSentence(i);
            for (int j = 0; j < sentence.size(); j++) {
                for (int k = 0; k < sentence.size(); k++) {
                    Word one = sentence.getWord(j);
                    Word second = sentence.getWord(k);
                    String oneword = removePunct(one.getWord());
                    String secondword = removePunct(second.getWord());
                    if (oneword.equalsIgnoreCase(secondword)) {
                        count++;
                    }
                    if (count > max) {
                        max = count;
                        word.setWord(secondword);
                        sentencefinder = i;
                    }
                }
                count = 0;
            }
        }
        if (max==0){
            System.out.println("No repeated words");
        }
        System.out.println("max repeated: " + max);
        System.out.println(word);
        return text.getSentence(sentencefinder);
    }

    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public static String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (PUNCT.indexOf(c) < 0) {
                result.append(c);
            }
        }
        return result.toString();
    }

    //need test - works with objects
    public static Text stringToText(String rep){
        String[] str = rep.split(" ");
        Word word = new Word();
        Sentence sentence = new Sentence();
        Text text = new Text();
        for (int i = 0; i < str.length; i++) {
        word.setWord(str[i]);
        sentence.addWord(word);
        word = new Word();
        int wordlength = str[i].length() - 1;
        if (str[i].charAt(wordlength) == '.')
        {
            text.addSentence(sentence);
            sentence = new Sentence(); }
        }
        return text;
    }
}

