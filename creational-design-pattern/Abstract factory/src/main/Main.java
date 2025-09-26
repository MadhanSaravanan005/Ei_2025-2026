package main;

import java.util.Scanner;
import client.CarAssembler;
import factory.LuxuryCarFactory;
import factory.EconomyCarFactory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose car type (luxury/economy):");
        String type = scanner.nextLine().toLowerCase();

        CarAssembler assembler;

        if(type.equals("luxury")) {
            assembler = new CarAssembler(new LuxuryCarFactory());
        } else {
            assembler = new CarAssembler(new EconomyCarFactory());
        }

        assembler.assembleCar();
        scanner.close();
    }
}
