package controller;

import model.Sentence;
import model.Word;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextReaderTest {


    @Test
    public void replaceSymbols_usingMock() {
        TextReader textReaderMock = mock(TextReader.class);
        String mockstr = "(was doublespace) One. Two, two. Three, three, three. Four, four, four, four. (was tab)Five, five, five, five, five, five. " +
                "Six, six, six, six, six, six. Seven, seven, seven, seven, seven, seven, seven. ";
        when(textReaderMock.readText("mock.txt")).thenReturn(mockstr);
        TextReader textReader = new TextReader();
        String replaced = textReader.replaceSymbols(textReaderMock.readText("mock.txt"));
        String replacesmock = mockstr;
        assertEquals(replacesmock,replaced);
    }

    @Test
    public void replaceSymbols_usingMockWithNull() {
        TextReader textReaderMock = mock(TextReader.class);
        String mockstr = " ";
        when(textReaderMock.readText("empty.txt")).thenReturn(" ");
        TextReader textReader = new TextReader();
        String replaced = textReader.replaceSymbols(textReader.readText("empty.txt"));
        String replacesmock = mockstr;
        assertEquals(replacesmock,replaced);
    }
}