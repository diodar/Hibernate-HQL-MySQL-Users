package org.example.app.views;

import java.util.Scanner;

public class UserUpdateView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Enter user's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();
        title = "Enter new email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();
        return new String[]{id, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
