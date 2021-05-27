package service;

import dao.daointerface.Checker;
import dao.daointerface.Maker;
import dao.daointerface.Operator;
import dao.daoimplementation.Bank;
import model.client.Customer;
import model.payment.LoanAgreement;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestMain {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println(" welcome to banking mini project \n");
        Operator operator = Bank.getSingletonInstance();
        Checker checker = Bank.getSingletonInstance();
        Maker maker = Bank.getSingletonInstance();
        System.out.println(operator);
        System.out.println(checker);
        System.out.println(maker);
       //  System.out.println(operator.findCustomer(10).toString());

/*
        Customer customer = new Customer();
        customer.setCustomerId(14);
        customer.setCustomerName("vikrant");
        customer.setDateOfBirth(Date.valueOf("1992-01-09"));
        customer.setContactNumber("8765468797");
        customer.setEmailAddress("aman@wap.com");
        customer.setMonthlyIncome(100000);
        customer.setDesignation("engineer level 3");
        customer.setTotalMonthlyExpenses(35000);
        customer.setProfession("engineer");
        customer.setCompanyName("nucleus");
        System.out.println(maker.registerCustomer(customer));
        List<Customer> list = new ArrayList<>();
       list = operator.findMatchedDob(customer);
       list.size();
        System.out.println("total matched customer are "+list.size());
       for(Customer cs : list)
       {
           System.out.println(cs.toString());
       }
*/
        // System.out.println(operator.findCustomer(14).getCustomerId());
       /*
        ArrayList<LoanAgreement> list = operator.getAllActiveLoanDetails();
        for (LoanAgreement loanAgreement : list) {
            System.out.println(loanAgreement.toString());

        */
        System.out.println(operator.trackLoanStatus(1));
        }


    }

