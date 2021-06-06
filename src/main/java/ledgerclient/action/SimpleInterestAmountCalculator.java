package ledgerclient.action;

import ledgerclient.AmountCalculator;

public class SimpleInterestAmountCalculator implements AmountCalculator {

  @Override
  public Integer calculateAmount(Integer principal, Integer years, Integer rateOfInterest) {
    double interestAmount = (principal*years*rateOfInterest)/100.0;
    int amount = principal + (int)Math.ceil(interestAmount);
    return amount;
  }

  @Override
  public Integer getMonthlyEmi(Integer principal, Integer years, Integer rateOfInterest) {
    int totalAmount = calculateAmount(principal, years, rateOfInterest);
    int months = years*12;
    int monthEmi = (int)Math.ceil(totalAmount/(double)months);
    return monthEmi;
  }

}
