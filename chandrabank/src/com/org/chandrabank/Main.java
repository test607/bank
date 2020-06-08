package com.org.chandrabank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("welcome to chandra bank");
        System.out.println("1.Enter Demand Draft Details");
        System.out.println("2.Print Demand Draft Details");
        System.out.println("3.exit");
        System.out.println("select you are choice");
        BankDao bankmodel = new BankDao();
        Scanner myObj = new Scanner(System.in);
        int choice;
        choice = Integer.parseInt(myObj.next());
        switch (choice) {
            case 1:

                System.out.println("Enter name of customer:");
                Scanner na = new Scanner(System.in);
                String name;
                name = (na.nextLine());
                System.out.println("Enter Customer phone number:");
                Scanner ph = new Scanner(System.in);
                long phonenum;
                phonenum = Long.parseLong((na.next()));
                System.out.println("Enter DD amount in (Rs):");
                Scanner am = new Scanner(System.in);
                String amount;
                amount = am.next();
                System.out.println("Enter Remarks:");
                Scanner re = new Scanner(System.in);
                String remarks;
                remarks = am.next();




               while (!name.matches("[a-zA-Z,]+")){
                   System.out.println("please retype name");
               }


                BankModel bankPojoClass=new BankModel();
                bankPojoClass.setCustomerName(name);
                bankPojoClass.setPhoneNumber(phonenum);
                bankPojoClass.setAmount(amount);
                bankPojoClass.setRemarks(remarks);
                bankmodel.savaData(bankPojoClass);
                break;
            case 2:
                System.out.println("Enter the Transaction Id to get Demand Draft details:");
                Scanner id = new Scanner(System.in);
                int tId;
                tId = Integer.parseInt(id.next());
                bankmodel.getData(tId);
                break;
            case 3:
                System.out.println("why u came here");
                break;

            default:
                throw new Exception("no such choice");

        }


    }
}
