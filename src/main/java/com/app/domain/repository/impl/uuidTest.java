package com.app.domain.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class uuidTest {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        System.out.println(id);
        System.out.println(id.equals(id));

        String s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(s);
    }
}
