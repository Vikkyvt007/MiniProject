package dao.daointerface;

import model.client.Customer;
import model.payment.LoanAgreement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Operator {



    public String trackLoanStatus(int loanAgreementId);
    public Customer findCustomer(int customerId) throws IOException , SQLException;
    public double calculateLoanPenalty(int loanAgreementId);
    public ArrayList<LoanAgreement> getAllActiveLoanDetails() throws SQLException;
    public double payEmi(int loanAgreementId ,double emiAmount ,int month);
    public List<Customer> findMatchedDob(Customer c);

}
