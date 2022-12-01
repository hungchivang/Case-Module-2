//package io;
//
//import Model.Account;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadAndWrite {
//
//    List<Account> accounts = new ArrayList<>();
//    List<Account> accountAdmin = new ArrayList<>();
//
//    public List<Account> readCustomer() {
//        try {
//            FileReader fileReader = new FileReader("accCustomer.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while (true) {
//                line = bufferedReader.readLine();
//                if (line == null) {
//                    break;
//                }
//                String[] txt = line.split(";");
//                String username = txt[0];
//                String password = txt[1];
//                accounts.add(new Account(username, password));
//            }
//            bufferedReader.close();
//            fileReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return accounts;
//    }
//
//
//    public void writeCustomer(List<Account> accounts) {
//        try {
//            FileWriter fileWriter = new FileWriter("accCustomer.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Account account : accounts) {
//                bufferedWriter.write(account.toString());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public List<Account> readAdmin() {
//        try {
//            FileReader fileReader = new FileReader("accAdmin.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while (true) {
//                line = bufferedReader.readLine();
//                if (line == null) {
//                    break;
//                }
//                String[] txt = line.split(";");
//                String username = txt[0];
//                String password = txt[1];
//                accountAdmin.add(new Account(username, password));
//            }
//            bufferedReader.close();
//            fileReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return accountAdmin;
//    }
//
//
//    public void writeAdmin(List<Account> accountAdmin) {
//        try {
//            FileWriter fileWriter = new FileWriter("accAdmin.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Account account : accountAdmin) {
//                bufferedWriter.write(account.toString());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
