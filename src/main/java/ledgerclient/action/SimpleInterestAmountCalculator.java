package ledgerclient.action;

import ledgerclient.AmountCalculator;

public class SimpleInterestAmountCalculator implements AmountCalculator {

  @Override
  public Integer calculateAmount(Integer principal, Integer years, Integer rateOfInterest) {
    Double interestAmount = (principal*years*rateOfInterest)/100.0;
    Integer amount = principal + (int)Math.ceil(interestAmount);
    return amount;
  }

  @Override
  public Integer getMonthlyEmi(Integer principal, Integer years, Integer rateOfInterest) {
    Integer totalAmount = calculateAmount(principal, years, rateOfInterest);
    Integer months = years*12;
    Integer monthEmi = (int)Math.ceil(totalAmount/(double)months);
    return monthEmi;
  }

}
