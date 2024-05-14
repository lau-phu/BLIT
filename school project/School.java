package com.helloworld;

import java.util.Objects;
import java.util.Scanner;

public class School extends Student{

    public School(int id, String fname, String lname, int subjectNum, int grade) {
        super(id, fname, lname, subjectNum, grade);
    }

    public void registerCourse(String a){
        for(int i=0;i<getSubjectNum();i++){
            if(getCourse()[i]==null){
                setCourse(i,a);
                System.out.println("Course added");
                return;
            }
        }
        System.out.println("all your courses is full");
    }

    public void dropCourse(String a){
        for(int i=0;i<getSubjectNum();i++){
            if(Objects.equals(getCourse()[i], a)){
                setCourse(i,null);
                System.out.println("Course dropped");
                return;
            }
        }
        System.out.println("course not found");
    }

    public void printCourses(){
        System.out.print("here are the courses: \n|");
        for(int i=0;i<getSubjectNum();i++){

            if(getCourse()[i]==null){
                System.out.print("empty|");
            }else {
                System.out.print(getCourse()[i] + "|");
            }
            }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Student student = new Student();

        String word;
        int value;
        System.out.print("please enter your ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("please enter your first name: ");
        String fname = scan.nextLine();

        System.out.print("please enter your last name: ");
        String lname = scan.nextLine();

        System.out.print("please enter your number of subjects: ");
        int subjects = scan.nextInt();
        scan.nextLine();

        System.out.print("please enter your grade level in number: ");
        int grade = scan.nextInt();
        scan.nextLine();


        System.out.print("please enter your social security number: ");
        String social = scan.nextLine();
        scan.nextLine();

        System.out.print("honk?");
        String honk = scan.nextLine();
        if (Objects.equals(honk, "pee pee pee")) {
            System.out.println("pee pee pee");
        }

        School school = new School(id, fname, lname, subjects, grade);
        int choice;
        do {
            System.out.println("type 1 to add coures \ntype 2 to drop courses \ntype 3 to print your coures \ntype 0 to quit");
            choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                System.out.println("what is your course to add?");
                String newCourse = scan.nextLine();
                school.registerCourse(newCourse);
            } else if (choice == 2) {
                System.out.println("what is your course to drop?");
                String newCourse = scan.nextLine();
                school.dropCourse(newCourse);
            } else if (choice == 3) {
                school.printCourses();
            }
        } while (choice != 0);
        scan.close();


    }
}

