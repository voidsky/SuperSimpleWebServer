package com.stud.oop.Logger;

public class SingleLogger {
    
    // static object of single logger
    private static SingleLogger instance = new SingleLogger();
    
    // constructor is private so class could not be instaniated
    private SingleLogger() {}
    
    // get only object available
    public static SingleLogger getInstance() {
        return instance;
    }
    
    public void showMessage(String message) {
        System.out.printf("Singleton logger: %s\r\n",message);
    }
    
}
