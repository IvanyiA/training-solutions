package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int minAmount) {
        for (BankAccount account : accounts)
            if (account.getBalance() > minAmount) {
                return true;
            }
        return false;
    }
}

