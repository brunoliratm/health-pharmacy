package Tratamento;

import java.io.IOException;

public class Limpeza {
    public static void limpeza(){
        String os = System.getProperty("os.name").toLowerCase();

        try {
            Process process;
            if (os.contains("win")) {
                process = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                process = new ProcessBuilder("clear").inheritIO().start();
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
