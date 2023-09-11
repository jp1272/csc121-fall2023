import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BuggyBankingTester {
  buggy.IAccount as = new buggy.Checking("Adam Smith", 123, 150, 50);
  buggy.IAccount bj = new buggy.Savings("Betty Jones", 456, 120, 2.5);
  buggy.IAccount pt1 = new buggy.CD("Pat Malloy", 334, 300, false);

  @Test
  public void testAmtAvailable() {
      
  }
  
  @Test
  public void testMoreAvailable() {
      
  }

  @Test
  public void testWithdraw() {
      
  }

}

