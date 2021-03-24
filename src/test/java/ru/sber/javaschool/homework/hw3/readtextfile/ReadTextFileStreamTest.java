package ru.sber.javaschool.homework.hw3.readtextfile;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextFileStreamTest {
    String inputFileName = "src/main/resources/input.txt";
    String outputFileName = "src/main/resources/output.txt";

    @Test
    public void testMain() throws IOException {
        ReadTextFileStream.readTextFile(inputFileName, outputFileName);
        boolean result = false;
        for (String line : Files.readAllLines(Paths.get(outputFileName), StandardCharsets.UTF_8)) {
            if (line.contains("c")) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result);
    }
}