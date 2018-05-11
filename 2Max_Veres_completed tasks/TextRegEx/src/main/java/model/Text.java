package model;

import java.util.ArrayList;

public class Text {
    private ArrayList<Sentence> text;

    public Text() {
        this.text = new ArrayList<>();
    }

    public ArrayList<Sentence> getText() {
        return text;
    }

    public Sentence getSentence(int i) {
        return text.get(i);
    }

    public void addSentence(Sentence sentence) {
        text.add(sentence);
    }

    public int size(){
        return text.size();
    }

    @Override
    public String toString() {
        return "Text:" +
                text;
    }
}
