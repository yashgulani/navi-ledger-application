package ledgerclient;

// this interface can be implemented for all amount calculation logics
public interface AmountCalculator {

  Integer calculateAmount(Integer principal, Integer years, Integer rateOfInterest);

  Integer getMonthlyEmi(Integer principal, Integer years, Integer rateOfInterest);

}
