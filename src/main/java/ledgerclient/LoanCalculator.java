package ledgerclient;

import ledgerclient.model.Loan;

// this interface can be implemented for all amount calculation logics
public interface LoanCalculator {

  Integer calculateAmount(Integer principal, Integer years, Integer rateOfInterest);

  Integer getMonthlyEmi(Integer principal, Integer years, Integer rateOfInterest);

  Integer getLumpSumAmountPaid(Loan loan, Integer emiNumber);

}
