package com.app.domain.repository.impl;

import java.util.UUID;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class uuidTest {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        System.out.println(id);
        System.out.println(id.equals(id));
        System.out.println("halo");
    }
}
