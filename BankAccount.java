import java.text.NumberFormat;

public class BankAccount {
    // MEMBER VARIABLES
    private String name;
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(String name) {
        this.name = name;
        accounts += 1;
    }
    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public String getCheckingBalance(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Checking Balance:");
        return formatter.format(this.checkingBalance);
    }
    public String getSavingsBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Savings Balance");
        return formatter.format(this.savingsBalance);
    }
    public static int getNumberOfAccounts() {
        return accounts;
    }
    public static String getTotalMoney() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(totalMoney);
    }
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void makeDeposit(int depositAmount, String accountType) {
        if(depositAmount > 0){
            if(accountType.equals("checking")){
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                System.out.println("Checking Balance: " + formatter.format(this.checkingBalance));
                System.out.println("Amount to deposit:" + formatter.format(depositAmount));
                this.checkingBalance += depositAmount;
                totalMoney += depositAmount;
            }
            else if(accountType.equals("savings")){
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                System.out.println("Savings Balance: "+ formatter.format(this.savingsBalance));
                System.out.println("Amount to deposit:" + formatter.format(depositAmount));
                this.savingsBalance += depositAmount;
                totalMoney += depositAmount;
            }
            else{
                System.out.println("Invalid account type");
            }
        }
        else{
            System.out.println("Deposit must be greater than 0");
        }
    }
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void makeWithdrawal(int withdrawalAmount, String accountType) {
        if(accountType.equals("checking")){
            if(withdrawalAmount > this.checkingBalance){
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                System.out.println("Withdrawal Amount: "+ formatter.format(withdrawalAmount) + ". Checking Balance: " + formatter.format(this.checkingBalance) +". Withdrawal too large");
            }
            else{
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                this.checkingBalance -= withdrawalAmount;
                totalMoney -= withdrawalAmount;
                System.out.println("Withdrawal AMount: "+ formatter.format(withdrawalAmount));
                System.out.println("Checking Balance: " + formatter.format(this.checkingBalance));
            }
        }
        else if(accountType.equals("savings")){
            if(withdrawalAmount > this.savingsBalance){
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                System.out.println("Withdrawal Amount: "+ formatter.format(withdrawalAmount) + ". Savings Balance: " + formatter.format(this.savingsBalance) +". Withdrawal too large");
            }
            else{
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                this.savingsBalance -= withdrawalAmount;
                totalMoney -= withdrawalAmount;
                System.out.println("Withdrawal  Amount: " + formatter.format(withdrawalAmount));
                System.out.println("Savings Balance: " + formatter.format(this.savingsBalance));
            }
        }
        else{
            System.out.println("Invalid account type.");
        }
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public String getBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total account balance");
        return formatter.format(this.checkingBalance + this.savingsBalance);
    }
}
