import accounts.*;
import creditCards.CreditCard;
import accounts.accountFactories.BussinessAccountFactory;
import accounts.accountFactories.CurrentAccountFactory;
import accounts.accountFactories.SavingsAccountFactory;
import accounts.accountFactories.StudentAccountFactory;
import creditCards.CreditCardFactory;
import people.Owner;
import transfers.Transaction;
import transfers.TransactionFactory;
import transfers.TransferLoggerService;
import transfers.WithdrawService;
import Currency.CurrencyType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    List<Transaction> transactions = new ArrayList<>();
    TransferLoggerService loggerService = new TransferLoggerService(transactions);
    TransactionFactory transactionFactory = new TransactionFactory();
    WithdrawService withdrawService = new WithdrawService(loggerService, transactionFactory);

    AccountNumberGeneratorFactory generatorFactory = new AccountNumberGeneratorFactory(new SimpleAccountCreationLogger(), new TimestampedAccountCreationLogger());

    CurrentAccountFactory currentAccountFactory = new CurrentAccountFactory(generatorFactory);
    BussinessAccountFactory bussinessAccountFactory = new BussinessAccountFactory(generatorFactory);
    SavingsAccountFactory savingsAccountFactory = new SavingsAccountFactory(generatorFactory);
    StudentAccountFactory studentAccountFactory = new StudentAccountFactory("gg");
    CreditCardFactory creditCardFactory = new CreditCardFactory();

    Owner owner = new Owner("Tomas", "Pesek");

    List<BankAccount> accounts = new ArrayList<>();

    BankAccount bankAccount = currentAccountFactory.create(owner, 100, CurrencyType.CZK);
    accounts.add(bankAccount);

    BankAccount studentAccount = studentAccountFactory.create(owner, 100);
    accounts.add(studentAccount);

    BankAccount robuxAccount = savingsAccountFactory.create(owner, 1000, CurrencyType.ROBUX);
    accounts.add(robuxAccount);

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


    withdrawService.addToBalance(bankAccount, 300);
    withdrawService.addToBalance(bankAccount, 100);
    withdrawService.withdraw(bankAccount, 200);
    System.out.println("balance: " + bankAccount.formatBalance(CurrencyType.ROBUX));
    loggerService.printStatement(bankAccount, CurrencyType.ROBUX);


    CreditCard creditCard = creditCardFactory.create(owner,500);
    withdrawService.addToBalance(creditCard,1000);
    withdrawService.withdraw(creditCard,100);


    // transferService.withdraw(bankAccount, 500);
    // transferService.withdraw(bankAccount,500);
    // transferService.withdraw(bankAccount,500);



    System.out.println("balance: " + bankAccount.getBalance());
}
