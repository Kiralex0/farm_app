package org.example;

import org.example.model.Farm;
import org.example.ui.UI;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       UI session = new UI(new Farm(new LinkedList<>()));
        session.start();
    }
}
