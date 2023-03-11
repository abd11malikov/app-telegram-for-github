package org.example;

import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if(name.length()>5&&name.length()<15){
            System.out.println("PIMA olimpiadasiga xush kelibsiz, "+name);
        }
    }
}