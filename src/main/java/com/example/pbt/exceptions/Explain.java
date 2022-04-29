package com.example.pbt.exceptions;

public class Explain {
    public static void main(String[] args) {
        new Finaller().execute();
        System.out.println("---------");


        System.out.println("pre-propagUC");
        try {
            new Propagation().propag1UC();
        } catch (ArithmeticException e) {
            System.out.println("got exception");
        }
        System.out.println("post-propagUC");
    }

}

class Propagation {
    public void propag1UC() {
        System.out.println("pre-propag1UC");
        propag2UC();
        System.out.println("post-propag1UC");
    }

    //Declare or not is the same
    public void propag2UC() throws ArithmeticException{
        System.out.println("pre-propag2UC");
        int i = 15 / 0;
        System.out.println("post-propag2UC " + i);
    }
}

class Finaller {
    public void execute() {
        try {
            System.out.println("Finaller-call");
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("Finaller-catch");
            return;
        } finally {
            System.out.println("Finaller-finally");
        }
    }

}
