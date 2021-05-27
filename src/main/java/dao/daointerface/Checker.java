package dao.daointerface;

import java.io.File;

public interface Checker {
    public void approveRejectLoan(File file);
    public void loanDisbursal(int loanAgreementId);
}
