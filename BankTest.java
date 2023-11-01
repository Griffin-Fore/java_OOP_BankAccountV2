public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount("George");
        BankAccount account2 = new BankAccount("Thomas");
        BankAccount account3 = new BankAccount("Abraham");
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println("Depositting into account 1: -----");
        account1.makeDeposit(100,"checking");
        System.out.println(account1.getCheckingBalance());
        
        System.out.println("Depositting into account 2: -----");
        account2.makeDeposit(200,"savings");
        System.out.println(account2.getSavingsBalance());
        System.out.println(BankAccount.getTotalMoney());

        account2.makeDeposit(300, "checking");
        account2.makeDeposit(400,"savings");
        System.out.println(account2.getCheckingBalance());
        System.out.println(BankAccount.getNumberOfAccounts());

        System.out.println("Depositting into account 3: -----");
        account3.makeDeposit(500,"checking");
        account3.makeDeposit(600,"savings");
        account3.makeDeposit(-50,"savings");
        account3.makeDeposit(100, "chackin");
        System.out.println(account3.getCheckingBalance());
        System.out.println(account3.getBalance());
        
        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        System.out.println("Withdrawing from account 1: -----");
        account1.makeWithdrawal(50, "checking");
        account1.makeWithdrawal(50, "savings");
        account1.makeWithdrawal(50,"chacking");
        System.out.println("Toal Money: "+ BankAccount.getTotalMoney());

        System.out.println("Withdrawing from account 2-----");
        account2.makeWithdrawal(50, "checking");
        account2.makeWithdrawal(50, "savings");
        System.out.println("Toal Money: " + BankAccount.getTotalMoney());

        System.out.println("Withdrawing from account 3-----");
        account3.makeWithdrawal(50, "checking");
        account3.makeWithdrawal(50, "savings");
        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("Number of accounts: " + BankAccount.getNumberOfAccounts());
        System.out.println("Total Money: " + BankAccount.getTotalMoney());
    }
}
