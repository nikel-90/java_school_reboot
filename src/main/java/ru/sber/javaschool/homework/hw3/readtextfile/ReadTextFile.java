package ru.sber.javaschool.homework.hw3.readtextfile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/input.txt";
        String outputFileName = "src/main/resources/output.txt";

        try {
            readTextFile(inputFileName, outputFileName);
            System.out.println("Файл успешно записан с изменениями!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTextFile(String input, String output) throws IOException {
        List<String> newLines = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8)) {
            newLines.add(line.replace("c", " "));
        }
        Files.write(Paths.get(output), newLines, StandardCharsets.UTF_8);
    }
}