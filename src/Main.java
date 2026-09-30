import accounts.BankAccount;
import accounts.CurrentAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import creditCards.CreditCard;
import people.Owner;
import transfers.WithdrawService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    WithdrawService withdrawService = new WithdrawService();

    Owner owner = new Owner("Tomas", "Pesek");

    List<BankAccount> accounts = new ArrayList<>();

    BankAccount bankAccount = new CurrentAccount(owner, 1000);
    accounts.add(bankAccount);

    BankAccount studentAccount = new StudentAccount(owner, 100);
    accounts.add(studentAccount);

    for (BankAccount account : accounts) {
        if (account instanceof InterestPoint) {
            ((InterestPoint)account).calculateInterest();
        }
    }


    for (BankAccount account : accounts) {

        if (account instanceof StudentAccount) {
            StudentAccount overrideAccount = (StudentAccount) account;
            System.out.println("school: " + overrideAccount.getSchool());
        }
    }

    withdrawService.withdraw(bankAccount, 500);
    withdrawService.addToBalance(bankAccount,300);
    withdrawService.addToBalance(bankAccount,100);
    System.out.println("balance: " + bankAccount.getBalance());


    CreditCard creditCard = new CreditCard(owner, 500);
    withdrawService.addToBalance(creditCard,1000);
    withdrawService.withdraw(creditCard,100);


    // transferService.withdraw(bankAccount, 500);
    // transferService.withdraw(bankAccount,500);
    // transferService.withdraw(bankAccount,500);



    System.out.println("balance: " + bankAccount.getBalance());
}
