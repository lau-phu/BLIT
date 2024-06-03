package org.example.Controller;


import org.example.DAO.SuckerDaoImplementation;
import org.example.Entities.Sucker;
import org.example.Services.SuckerService;
import org.example.Utils.SQLConnector;

import java.util.Scanner;


public class MainController {

    public static void main(String[] args) {

        SQLConnector sqlObj = new SQLConnector();
        SQLConnector.dbConnection();

        SuckerDaoImplementation suckerimpl = new SuckerDaoImplementation();

        Scanner scan = new Scanner(System.in);

        System.out.println("this is CRUD test, all input are manual for testing purposes.");

        boolean loop = true;

        do {
            System.out.println("GayLord Casino User Management\n" +
                    "1: Create new account.\n" +
                    "2: Display all accounts.\n" +
                    "3: Update existing account.\n" +
                    "4: Delete an acount.\n" +
                    "5: Adjust winning\n" +
                    "0: to quit");
            try {
                int choice = scan.nextInt();

                switch (choice) {
                    case (0): {
                        loop = false;
                        break;
                    }
                    case (1): {
                        System.out.println("enter starting money");
                        double money = scan.nextDouble();
                        scan.nextLine();
                        System.out.println("please enter idiot's name");
                        String name = scan.nextLine();
                        System.out.println("please enter idiot's address");
                        String address = scan.nextLine();

                        suckerimpl.insertSucker(new SuckerService(name, money, address));
                        System.out.println(name + " has been added!\n");
                        break;
                    }
                    case (2): {
                        System.out.println(suckerimpl.getAllSuckers());
                        System.out.println();
                        break;
                    }
                    case (3): {
                        System.out.println("please enter their ID");
                        int id = scan.nextInt();
                        scan.nextLine();
                        if(suckerimpl.retrieveSucker(id).getId()==0){
                            System.out.println("user does not exists");
                            break;
                        }
                        System.out.println("modify their money");
                        double money = scan.nextDouble();
                        scan.nextLine();
                        System.out.println("modify their name");
                        String name = scan.nextLine();
                        System.out.println("modify their address");
                        String address = scan.nextLine();
                        System.out.println("modify their ban status");
                        String ban = scan.next();

                        suckerimpl.updateSucker(id, new Sucker(name, money, address, ban));
                        System.out.println("this idiot is updated\n");
                        break;
                    }
                    case (4): {
                        System.out.println("please enter their ID to put them out of their misery.");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println(suckerimpl.deleteSucker(id) >0 ? "he has been freed\n":"user not found");

                        break;
                    }
                    case (5): {
                        System.out.println("please enter their id");
                        int id = scan.nextInt();
                        scan.nextLine();

                        if(suckerimpl.retrieveSucker(id).getId()==0){
                            System.out.println("user does not exists");
                            break;
                        }
                        System.out.println("please enter their winning (negative number preferred)");
                        double win = scan.nextInt();
                        scan.nextLine();
                        SuckerService s = suckerimpl.retrieveSucker(id);
                        s.gainMoney(win);
                        suckerimpl.updateSucker(id, s);
                        System.out.println("completed\n");
                        break;
                    }
                }
            }
            catch (Exception E){
                System.out.println("error occurred, selection terminated!");
                scan.next();
            }
        } while (loop);













//        StudentDaoImplementation studentImplobj = new StudentDaoImplementation();
//
////        Student s1 = new Student("first",3.5,"manassas", "c");
////       studentImplobj.insertStudent(s1);
////        System.out.println("it works");
////        System.out.println(studentImplobj.getAllStudents());
//
//        Student updatedStudent = new Student("haha",9.5,"home", "S");
////        int updatedStudent  =  studentImplobj.updateStudent(111111, );
//        int updateStatus = studentImplobj.updateStudent(111111,updatedStudent);
//        if(updateStatus>0)
//            System.out.println("all good");
//        else
//            System.out.println("no good");
//        System.out.println(studentImplobj.getAllStudents());
//        //studentImplobj.deleteStudent(111113);


    }

    static boolean exists(int id){
        SQLConnector sqlObj = new SQLConnector();
        SQLConnector.dbConnection();

        SuckerDaoImplementation suckerimpl = new SuckerDaoImplementation();
        if(suckerimpl.retrieveSucker(id)!=null){
            System.out.println("user does not exist");
            return false;
        }
        else {
            return true;
        }


    }
}
