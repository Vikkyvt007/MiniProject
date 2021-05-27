package dao.daoimplementation;

import connection.ConnectionI;
import connection.OracleConnectionImpl;
import connection.OraclePoolConnectionImpl;
import enums.LoanStatus;
import enums.RepayFrequency;
import dao.daointerface.Checker;
import dao.daointerface.Maker;
import dao.daointerface.Operator;
import model.assets.LoanProduct;
import model.client.Customer;
import model.payment.LoanAgreement;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 import org.apache.log4j.Logger;

public class Bank implements Operator , Checker , Maker {
    private List<LoanProduct> loanProducts;
    private Map<Integer ,Customer> customers;
    private static Bank bank = null;
    private boolean flag= false;
   static final  Logger logger = Logger.getLogger(Bank.class);
    private Bank()
    {


    }
    public static  Bank getSingletonInstance()
    {
        if(bank == null)
            bank = new Bank();

        return bank;

    }

    public List<LoanProduct> getLoanProducts() {
        return loanProducts;
    }

    public void setLoanProducts(List<LoanProduct> loanProducts) {
        this.loanProducts = loanProducts;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void approveRejectLoan(File file) {

    }

    @Override
    public void loanDisbursal(int loanAgreementId) {


    }

    @Override
    public boolean registerCustomer(Customer customer) throws IOException, SQLException {

        ConnectionI connectionI = null ;
        Connection conn = null;
        PreparedStatement p = null;
       // System.out.println("inside register");

            try {
               // System.out.println("false condition else");
                connectionI = new OracleConnectionImpl();
                conn = connectionI.createConnection();
                if (findCustomer(customer.getCustomerId()).getCustomerId()!= 0 || customer.getCustomerId()==0) {
                    System.out.println("can not regiter");
                    logger.info("can not register");

                } else {

                    String sql = "INSERT INTO LMS_CUSTOMER_M (Customer_ID,First_Name,Last_Name ,  Gender, Date_Of_Birth ,Contact_Number , Email_Address , Monthly_Income , Profession , Total_Monthly_Expense , Designation ,Company_Name)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                    System.out.println(sql);
                    p = conn.prepareStatement(sql);
                   // System.out.println(customer.toString());
                    p.setString(1, String.valueOf(customer.getCustomerId()));
                    System.out.println("first id");
                    p.setString(2, customer.getCustomerName());
                    p.setString(3,"NA");
                    p.setString(4, "U");
                    p.setDate(5, customer.getDateOfBirth());
                    p.setString(6, customer.getContactNumber());
                    p.setString(7, customer.getEmailAddress());
                    p.setInt(8, (int) customer.getMonthlyIncome());
                    p.setString(9, customer.getProfession());
                  //  System.out.println("profession");
                    p.setInt(10, (int) customer.getTotalMonthlyExpenses());
                  //  System.out.println("monthlyexp");
                    p.setString(11, customer.getDesignation());
                   // System.out.println("desig");
                    p.setString(12, customer.getCompanyName());
                  //  System.out.println("companyname");

                     p.executeUpdate();
                    flag = true;
                  //  System.out.println(" end of try" + count);

                }
            }
             catch(Exception e)
                {
                    logger.warn(e.getStackTrace());
                }
            finally{
                    conn.close();
                    //System.out.println("finally");
                }
        return flag;

        }




    @Override
    public void applyLoan(int customerId, double loanAmount, double roi, int tenure, String typeOfLoan, RepayFrequency repaymentFrequency) {

    }

    @Override
    public String trackLoanStatus(int loanAgreementId) {
        ArrayList<LoanAgreement> list = new ArrayList<>();
        ConnectionI connectionI ;
        Connection conn = null;
        PreparedStatement p = null;
        LoanAgreement loanAgreement = new LoanAgreement();
        ResultSet rs;
        String status= null;
        try {

            connectionI = new OracleConnectionImpl();
            conn = connectionI.createConnection();


            String sql = "SELECT Status FROM LMS_AGREEMENT_DTL WHERE AGREEMENT_ID= 1";
          //  p.setString(1,String.valueOf(loanAgreementId));
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            //  System.out.println(rs);
            //   System.out.println(sql);

            while (rs.next()) {
                // System.out.println("print");




                 status = rs.getString(1);
            //    System.out.println(status);
                if(status.equals("Pending"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.PENDING);
                }
                if(status.equals("Approved"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.APPROVED);
                }
                if(status.equals("Rejected"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.REJECTED);

                }
                if(status.equals("Active"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.ACTIVE);

                }
                if(status.equals("Closed"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.CLOSED);
                }
                list.add(loanAgreement);

            }
        }
        catch (Exception e)
        {
            logger.warn(e.getStackTrace());
        }
        finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return status;
    }

    @Override
    public Customer findCustomer(int customerId) throws  IOException , SQLException
    {

        ConnectionI connectionI ;
        Connection conn = null;
        PreparedStatement p = null;
        Customer customer = new Customer();
        ResultSet rs;
        try {
            connectionI= new OraclePoolConnectionImpl();

            // connectionI = new OracleConnectionImpl();
            conn = connectionI.createConnection();


          String sql = "SELECT * FROM LMS_CUSTOMER_M WHERE CUSTOMER_ID   ="+customerId;
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
          //  System.out.println(rs);
         //   System.out.println(sql);

            while (rs.next()) {
               // System.out.println("print");

                customer.setCustomerId(Integer.valueOf(rs.getString(1)));
                customer.setCustomerName(rs.getString(2) + " " + rs.getString(3));
                customer.setDateOfBirth(Date.valueOf(rs.getDate(5).toLocalDate()));
                customer.setContactNumber(rs.getString(6));
                customer.setEmailAddress(rs.getString(7));
                customer.setMonthlyIncome(rs.getInt(8));
                customer.setProfession(rs.getString(9));
                customer.setTotalMonthlyExpenses(rs.getInt(10));
                customer.setDesignation(rs.getString(11));
                customer.setCompanyName(rs.getString(12));

              //  System.out.println(customer.toString());

            }
        }
        catch (Exception e)
        {
            logger.warn(e.getStackTrace());
        }
       finally {
            if(conn != null)
            conn.close();
        }
        return customer;
    }

    @Override
    public double calculateLoanPenalty(int loanAgreementId) {
        return 0;
    }

    @Override
    public ArrayList<LoanAgreement> getAllActiveLoanDetails() throws SQLException {
        ArrayList<LoanAgreement> list = new ArrayList<>();
        ConnectionI connectionI ;
        Connection conn = null;
        PreparedStatement p;
        LoanAgreement loanAgreement = new LoanAgreement();
        ResultSet rs;
        try {

            connectionI = new OracleConnectionImpl();
            conn = connectionI.createConnection();


            String sql = "SELECT * FROM LMS_AGREEMENT_DTL WHERE Status = 'Active'";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            //  System.out.println(rs);
            //   System.out.println(sql);

            while (rs.next()) {
                // System.out.println("print");

               loanAgreement.setLaonAgreementId(Integer.valueOf(rs.getString(1)));
               loanAgreement.setTenure(rs.getInt(3));
               loanAgreement.setRoi(rs.getDouble(4));
               loanAgreement.setLoanAmount(rs.getDouble(5));
               String repay = rs.getString(6);
               if(repay.equals("M"))
               {
                   loanAgreement.setRepayFrequency(RepayFrequency.MONTHLY);
               }
                if(repay.equals("Y"))
                {
                    loanAgreement.setRepayFrequency(RepayFrequency.YEARLY);
                }
                if(repay.equals("Q"))
                {
                    loanAgreement.setRepayFrequency(RepayFrequency.QUARTERLY);
                }
                if(repay.equals("HY"))
                {
                    loanAgreement.setRepayFrequency(RepayFrequency.HALFYEARLY);
                }
                loanAgreement.setLoanDisbursalDate(rs.getDate(7).toLocalDate());
                String status = rs.getString(8);
                if(status.equals("Pending"))
                {
                      loanAgreement.setLoanStatus(LoanStatus.PENDING);
                }
                if(status.equals("Approved"))
                {
                loanAgreement.setLoanStatus(LoanStatus.APPROVED);
                }
                if(status.equals("Rejected"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.REJECTED);

                }
                if(status.equals("Active"))
                {
                    loanAgreement.setLoanStatus(LoanStatus.ACTIVE);

                }
                if(status.equals("Closed"))
                {
                     loanAgreement.setLoanStatus(LoanStatus.CLOSED);
                }
                list.add(loanAgreement);

            }
        }
        catch (Exception e)
        {
            logger.warn(e.getStackTrace());
        }
        finally {
            conn.close();
        }


        return list;
    }

    @Override
    public double payEmi(int loanAgreementId, double emiAmount, int month) {
        return 0;
    }

    @Override
    public List<Customer> findMatchedDob(Customer c)
    {
        List<Customer> list = new ArrayList<>();
    ConnectionI connectionI= null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        Date date =c.getDateOfBirth();
        Customer customer= new Customer();


    try
    {
        connectionI = new OraclePoolConnectionImpl();
        con = connectionI.createConnection();
     //   System.out.println(con);
        System.out.println(date);
       // String sql = "SELECT * FROM LMS_CUSTOMER_M";
        String sql ="SELECT * FROM LMS_CUSTOMER_M WHERE Date_Of_Birth =to_date('"+date+"','yyyy-mm-dd')";
        ps=con.prepareStatement(sql);
        rs= ps.executeQuery();
        while(rs.next())
        {
            customer.setCustomerId(rs.getInt(1));
            customer.setCustomerName(rs.getString(2));
            customer.setDateOfBirth(Date.valueOf(rs.getDate(5).toLocalDate()));
            list.add(customer);
        }



    }
    catch(Exception e)
    {
           logger.warn(e.getStackTrace());
        System.out.println(e.getMessage());
    }
    finally {
        if(con!=null)
            con = null;
    }

        return list;
    }
}
