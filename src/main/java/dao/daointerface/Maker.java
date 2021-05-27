package dao.daointerface;

import model.client.Customer;
import enums.RepayFrequency;

import java.io.IOException;
import java.sql.SQLException;

public interface Maker {
    public boolean registerCustomer(Customer customer) throws IOException, SQLException;
    public void applyLoan(int customerId ,double loanamount ,double roi ,int tenure ,String typeOfLoan , RepayFrequency repaymentFrequency);
}

