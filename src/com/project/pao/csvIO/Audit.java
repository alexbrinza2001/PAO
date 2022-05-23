package com.project.pao.csvIO;

import java.io.*;
import java.time.LocalDateTime;

public class Audit {
    public static Audit audit;

    private Audit() {}

    public static Audit getAudit() {
        if (audit == null)
            audit = new Audit();
        return audit;
    }

    public void writeAction(String action){
        try (FileWriter fileWriter = new FileWriter("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\Audit.csv", true)) {
            File file = new File("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\Audit.csv");

            if (file.length() == 0) {
                fileWriter.append("Interogation").append(",").append("Timestamp").append("\n");
            }

            LocalDateTime date = LocalDateTime.now();
            fileWriter.append(action).append(",").append(String.valueOf(date)).append("\n");
            fileWriter.flush();

        } catch (IOException e) {
            System.out.println("\n\tException: " + e.getMessage());
        }
    }

}