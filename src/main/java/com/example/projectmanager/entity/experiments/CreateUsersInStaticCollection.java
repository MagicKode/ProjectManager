package com.example.projectmanager.entity.experiments;

import java.util.ArrayList;
import java.util.Random;

public class CreateUsersInStaticCollection {


    public static void main(String[] args) {
        Users users = new Users();

        System.out.println(users.createUser());
    }
}

class Users {
    public String createUser() {
        ArrayList<String> createUsers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Random r = new Random();
            char letter = (char) (r.nextInt(26) + 'a');
            createUsers.add(String.valueOf(letter));
        }
        return String.valueOf(createUsers);
    }
}
