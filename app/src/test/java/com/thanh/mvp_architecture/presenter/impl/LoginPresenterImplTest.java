package com.thanh.mvp_architecture.presenter.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginPresenterImplTest {
    String username;
    String password;

    @Before
    public void setUp() throws Exception {
        username="Thanh";
        password="Nguyen";
    }

    @After
    public void tearDown() throws Exception {
        print("Tear");
    }

    @Test
    public void onLogin() {
        print("Test");

    }
    void print(String message){
        System.out.println(message);

    }
}