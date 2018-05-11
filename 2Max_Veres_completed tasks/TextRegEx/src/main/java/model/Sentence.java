package model;

import java.util.ArrayList;

public class Sentence {
   private ArrayList<Word> sentence;

    public Sentence() {
        this.sentence = new ArrayList<>();
    }

    public ArrayList<Word> getSentence() {
        return sentence;
    }

    public void addWord(Word word) {
        sentence.add(word);
    }

    public Word getWord(int i) {
        return sentence.get(i);
    }

    public int size(){
        return sentence.size();
    }

    @Override
    public String toString() {
        return "Sentence:" +
                sentence;
    }
}
