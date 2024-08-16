/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.lectureroom;

/**
 *
 * @author ebepa
 */
import java.util.Scanner;

public class LectureRoomController {
    
    // LectureRoom class to manage students and lights
    static class LectureRoom {
        private int studentCount;
        private boolean[] lights;

        public LectureRoom() {
            this.studentCount = 0;
            this.lights = new boolean[3];  // 3 lights, all initially off
        }

        public void addStudents(int count) {
            if (count > 0) {
                this.studentCount += count;
                System.out.println(count + " students added. Total students: " + this.studentCount);
            } else {
                System.out.println("Invalid number of students to add.");
            }
        }

        public void removeStudents(int count) {
            if (count > 0) {
                this.studentCount = Math.max(0, this.studentCount - count);
                System.out.println(count + " students removed. Total students: " + this.studentCount);
            } else {
                System.out.println("Invalid number of students to remove.");
            }
        }

        public void turnOnLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = true;
                System.out.println("Light " + lightNumber + " is now ON.");
            } else {
                System.out.println("Invalid light number. Please enter 1, 2, or 3.");
            }
        }

        public void turnOffLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = false;
                System.out.println("Light " + lightNumber + " is now OFF.");
            } else {
                System.out.println("Invalid light number. Please enter 1, 2, or 3.");
            }
        }

        public void displayRoomStatus() {
            System.out.println("Current students in room: " + this.studentCount);
            System.out.println("Light statuses: ");
            for (int i = 0; i < lights.length; i++) {
                System.out.println("  Light " + (i + 1) + ": " + (lights[i] ? "ON" : "OFF"));
            }
        }
    }

    // EasyReader class to handle input
    static class EasyReader {
        private Scanner scanner;

        public EasyReader() {
            this.scanner = new Scanner(System.in);
        }

        public char readChar() {
            return scanner.next().toUpperCase().charAt(0);
        }

        public int readInt() {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next(); // clear the invalid input
            }
            return scanner.nextInt();
        }

        public void close() {
            scanner.close();
        }
    }

    // Main method to control the LectureRoom
    public static void main(String[] args) {
        LectureRoom lectureRoom = new LectureRoom();
        EasyReader reader = new EasyReader();
        char choice;

        do {
            System.out.println("\n--- Lecture Room Control Menu ---");
            System.out.println("W - Add students to the room");
            System.out.println("X - Remove students from the room");
            System.out.println("Y - Turn on a light");
            System.out.println("Z - Turn off a light");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");

            choice = reader.readChar();

            switch (choice) {
                case 'W':
                    System.out.print("Enter the number of students to add: ");
                    int studentsToAdd = reader.readInt();
                    lectureRoom.addStudents(studentsToAdd);
                    break;
                case 'X':
                    System.out.print("Enter the number of students to remove: ");
                    int studentsToRemove = reader.readInt();
                    lectureRoom.removeStudents(studentsToRemove);
                    break;
                case 'Y':
                    System.out.print("Enter the light number to turn on (1-3): ");
                    int lightToTurnOn = reader.readInt();
                    lectureRoom.turnOnLight(lightToTurnOn);
                    break;
                case 'Z':
                    System.out.print("Enter the light number to turn off (1-3): ");
                    int lightToTurnOff = reader.readInt();
                    lectureRoom.turnOffLight(lightToTurnOff);
                    break;
                case 'Q':
                    System.out.println("Quitting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            lectureRoom.displayRoomStatus();
        } while (choice != 'Q');

        reader.close();
    }
}
