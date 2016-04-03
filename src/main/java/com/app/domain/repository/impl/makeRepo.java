package com.app.domain.repository.impl;

import com.app.domain.Account;
import com.app.domain.Client;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Tomasz on 01.04.2016.
 */
public class makeRepo {

    public static void main(String[] args) throws IOException {
        JsonClientRepository jsonClientRepository = new JsonClientRepository();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("name");
            String name = in.next();
            System.out.println("balance");
            int balance = in.nextInt();
            System.out.println("currency");
            String cur = in.next();
            Client client = new Client(name, new Account(cur, balance));
            jsonClientRepository.addClient(client);
        }
    }
}
