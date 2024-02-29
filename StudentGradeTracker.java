package com.mycompany.studentgradetracker;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author UNI-TECH
 */
public class StudentGradeTracker {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean continueTracking = true; // Flag to control tracking loop
        
        while (continueTracking) {
            System.out.print("Enter the number of students: ");
            int numStudents = input.nextInt();
            
            int[] grades = new int[numStudents];
            int[] rollNos = new int[numStudents]; // Array to store roll numbers
            
            // Map to store grades along with their respective roll numbers
            Map<Integer, Integer> gradeToRollNo = new HashMap<>();
            
            for (int i = 0; i < numStudents; i++) {
                System.out.print("Roll no of student " + (i + 1) + ": ");
                rollNos[i] = input.nextInt();
                System.out.print("Enter grade of student " + (i + 1) + ": ");
                int grade = input.nextInt();
                grades[i] = grade;
                gradeToRollNo.put(grade, rollNos[i]); // Mapping grade to roll number
            }
            
            Arrays.sort(grades);
            
            int sum = 0;
            int highest = grades[numStudents - 1];
            int lowest = grades[0];
            
            for (int grade : grades) {
                sum += grade;
            }
            
            double average = (double) sum / numStudents;
            
            System.out.println("Average Grade: " + average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Roll numbers of students with highest grade:");
            for (int i = numStudents - 1; i >= 0; i--) {
                if (grades[i] == highest) {
                    System.out.println("Roll No: " + gradeToRollNo.get(highest) + ", Grade: " + highest);
                } else {
                    break; // Once we find a grade lower than highest, we can stop checking
                }
            }
            System.out.println("Lowest Grade: " + lowest);
            System.out.println("Roll numbers of students with lowest grade:");
            for (int i = 0; i < numStudents; i++) {
                if (grades[i] == lowest) {
                    System.out.println("Roll No: " + gradeToRollNo.get(lowest) + ", Grade: " + lowest);
                } else {
                    break; // Once we find a grade higher than lowest, we can stop checking
                }
            }
            
            System.out.print("Do you want to add more records? (yes/no): ");
            String continueChoice = input.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                continueTracking = false; // Set flag to false if user doesn't want to continue
            }
        }
        
        input.close();
    }
}
