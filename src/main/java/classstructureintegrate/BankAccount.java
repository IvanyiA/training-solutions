package classstructureintegrate;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int ammount){
        balance = balance + ammount;}

    public void withdraw(int ammount){
        balance = balance - ammount;
    }

    public void transfer(BankAccount errera, int atutalniFt){
        withdraw(atutalniFt);
        errera.deposit(atutalniFt);
    }


    public String getInfo(){
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }


}
