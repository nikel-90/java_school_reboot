package ru.sber.javaschool.homework.hw3.readtextfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTextFileStream {
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

    public static void readTextFile(String inputFileName, String outputFileName) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(inputFileName));
        Files.write(Paths.get(outputFileName),
                stream.map(line -> transformChar(line)).collect(Collectors.joining("\n")).getBytes());
    }

    private static String transformChar(String line) {
        return line.replace('c', ' ');
    }
}

