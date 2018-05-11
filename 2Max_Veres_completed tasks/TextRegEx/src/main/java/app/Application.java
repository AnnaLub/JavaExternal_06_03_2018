package app;

import controller.TextReader;
import model.Sentence;
import model.Text;


/**Cоздать программу обработки текста с использованием классов: Cимвол, Слово, Предложение, Знак Припенания и др.
 * Во всех задачах с формированием текста заменять табуляции и последовольности пробелов одним пробелом.
 * Задание 1: Найти наибольшее количество предложений текста, в которых есть одинаковые слова
 **/

public class Application {

    public static void main(String[] args) {

        TextReader textReader = new TextReader();

        String replaced = textReader.replaceSymbols(textReader.readText("tutorial.txt"));
        System.out.println(replaced);
        Sentence sentence = TextReader.findSentenceWithMaxRepeatedWord(TextReader.stringToText(replaced));
        System.out.println(sentence);

    }
}
