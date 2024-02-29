package com.mycompany.travelplanner;
import java.util.Scanner;

public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Travel Itinerary Planner!");
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        
        System.out.print("Enter the number of destinations: ");
        int numDestinations = scanner.nextInt();
        
        String[] destinations = new String[numDestinations];
        int[] daysInDestinations = new int[numDestinations];
        
        // Input destinations and days in each destination6
        for (int i = 0; i < numDestinations; i++) {
            System.out.print("Enter destination " + (i+1) + ": ");
            destinations[i] = scanner.next();
            System.out.print("Enter number of days in " + destinations[i] + ": ");
            daysInDestinations[i] = scanner.nextInt();
        }
        
        // Input departure date
        System.out.print("Enter departure date (DD-MM-YYYY): ");
        String departureDate = scanner.next();
        
        // Input preferences
        System.out.print("Enter your budget: ");
        double budget = scanner.nextDouble();
        String transportMode;
        do {
            System.out.print("Enter preferred mode of transport (car, train, plane): ");
            transportMode = scanner.next();
        } while (!isValidTransportMode(transportMode));
        
        // Generate itinerary
        System.out.println("\n--- Your Travel Itinerary ---");
        System.out.println("Number of Persons: " + numPersons);
        System.out.println("Departure Date: " + departureDate);
        System.out.println("Mode of Transport: " + transportMode);
        System.out.println("Budget: Rs" + budget);
        
        double totalCost = 0;
        for (int i = 0; i < numDestinations; i++) {
            System.out.println("\nDestination: " + destinations[i]);
            System.out.println("Days: " + daysInDestinations[i]);
            // Calculate and display cost for each destination
            double cost = calculateCost(transportMode, daysInDestinations[i]);
            totalCost += cost;
            System.out.println("Estimated Cost: Rs" + cost);
            // Display weather information for each destination
            displayWeather(destinations[i]);
        }
        
        System.out.println("\nTotal Estimated Cost: Rs" + totalCost);
        
        // Additional features like weather information and maps can be integrated here
        
        scanner.close();
    }
    
    // Function to calculate cost based on mode of transport and days
    private static double calculateCost(String transportMode, int days) {
        double costPerDay = 0;
        switch (transportMode) {
            case "car":
                costPerDay = 500; // Sample cost for car travel
                break;
            case "train":
                costPerDay = 2000; // Sample cost for train travel
                break;
            case "plane":
                costPerDay = 5000; // Sample cost for plane travel
                break;
        }
        return costPerDay * days;
    }
    
    // Function to display weather information for a destination
    private static void displayWeather(String destination) {
        // You can integrate weather API to get weather information for each destination
        // For simplicity, let's just print a sample message
        destination = destination.toLowerCase(); // Convert to lowercase for case-insensitive comparison
        switch (destination) {
            case "quetta":
                System.out.println("Weather in " + destination + ": cloudy temperature : 25C ");
                break;
            case "muree":
                System.out.println("Weather in " + destination + ": cold temperature : 10C ");
                break;
            case "islamabad":
                System.out.println("Weather in " + destination + ": sunny temperature : 35C ");
                break;
            case "lahore":
                System.out.println("Weather in " + destination + ": cloudy temperature : 25C ");
                break;
            case "swat":
                System.out.println("Weather in " + destination + ": cloudy temperature : 9C ");
                break;
            default:
                System.out.println("Weather information not available for " + destination);
        }
    }
    
    // Function to validate transport mode
    private static boolean isValidTransportMode(String mode) {
        return mode.equalsIgnoreCase("car") || mode.equalsIgnoreCase("train") || mode.equalsIgnoreCase("plane");
    }
}
