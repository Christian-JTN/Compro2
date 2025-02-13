package com.GitGood.Grades;

import java.io.*;
import java.util.Scanner;

public class GradesCal {
    public static final double MIN_GRADE = 50;
    public static final String FILE_DIR = "target/records";
    public static final int NUM_OF_SUBJECTS = 64;
    public static final int NUM_OF_TERMS = 3;

    public static void main(String[] args) {
        String name;
        String[] subjects = new String[NUM_OF_SUBJECTS];
        double[][] grades = new double[NUM_OF_SUBJECTS][NUM_OF_TERMS];
        String[] terms = {"Prelim", "Midterm", "Finals"};

        Scanner pogi = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = pogi.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n")
                .append(String.format("%-15s%-10s%-10s%-10s%-10s\n",
                        "SUBJECTS", "PRELIM", "MIDTERM", "FINAL", "FINAL RATING"));

        for (int i = 0; i < NUM_OF_SUBJECTS; i++) {
            System.out.print("Enter subject: ");
            subjects[i] = pogi.nextLine();
            sb.append(String.format("%-15s", subjects[i]));

            for (int j = 0; j < NUM_OF_TERMS; j++) {
                System.out.print("\t" + terms[j] + ": ");
                try {
                    grades[i][j] = Double.parseDouble(pogi.nextLine());
                    if (grades[i][j] < MIN_GRADE) {
                        throw new Exception("Error! No grades lesser than 50.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\tError! Invalid number.");
                    --j;
                    continue;
                } catch (Exception e) {
                    System.out.println("\t" + e.getMessage());
                    --j;
                    continue;
                }
                sb.append(String.format("%-10.2f", grades[i][j]));
            }

            sb.append(String.format("%-10.2f\n", getFinalRating(grades[i])));

            System.out.print("Add another subject (y/n): ");
            char choice = pogi.nextLine().charAt(0);
            if (Character.toLowerCase(choice) != 'y')
                break;
        }

        System.out.println(sb);
        writeToFile(name, sb.toString());
    }

    public static double getFinalRating(double[] termGrades) {
        return termGrades[0] * 0.3 + termGrades[1] * 0.3 + termGrades[2] * 0.4;
    }

    public static void writeToFile(String fileName, String data) {
        File folder = new File(FILE_DIR);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void readAllFiles() {
        File folder = new File(FILE_DIR);
        File[] studentGradeFiles = folder.listFiles();
        if (studentGradeFiles != null) {
            for (File file : studentGradeFiles) {
                if (file.isFile()) {
                    readFile(file);
                }
            }
        }
    }

    public static void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("--------------------------");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}