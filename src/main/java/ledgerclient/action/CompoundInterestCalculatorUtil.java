package ledgerclient.action;

import ledgerclient.LoanCalculator;
import ledgerclient.model.Loan;

public class CompoundInterestCalculatorUtil implements LoanCalculator {

  @Override
  public Integer calculateAmount(Integer principal, Integer years, Integer rateOfInterest) {
    return null;
  }

  @Override
  public Integer getMonthlyEmi(Integer principal, Integer years, Integer rateOfInterest) {
    return null;
  }

  @Override
  public Integer getLumpSumAmountPaid(Loan loan, Integer emiNumber) {
    return null;
  }
}
