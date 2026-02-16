package com.healthpharmacy.presentation.ui.util;

import java.io.IOException;

public class ConsoleUtils {
  public static void clear() {
    try {
      String os = System.getProperty("os.name").toLowerCase();
      ProcessBuilder pb = os.contains("win")
          ? new ProcessBuilder("cmd", "/c", "cls")
          : new ProcessBuilder("clear");

      pb.inheritIO().start().waitFor();
    } catch (IOException | InterruptedException e) {
      System.out.println("\n".repeat(50));
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void pressEnterToContinue() {
    System.out.print("\nPress ENTER to continue...");
    try {
      System.in.read();
    } catch (Exception ignored) {
    }
  }

  public static void handleDelay() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
