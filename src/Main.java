import accounts.BankAccount;
import accounts.CurrentAccount;
import accounts.StudentAccount;
import people.AccountOwner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    AccountOwner owner = new AccountOwner("Tomas", "Pesek");

    List<BankAccount> accounts = new ArrayList<>();

    BankAccount bankAccount = new CurrentAccount(owner, 100);
    accounts.add(bankAccount);

    BankAccount studentAccount = new StudentAccount(owner, 100);
    accounts.add(studentAccount);


    for (BankAccount account : accounts) {

        if (account instanceof StudentAccount) {

            StudentAccount overrideAccount = (StudentAccount) account;
            System.out.println("school: " + overrideAccount.getSchool());
        }
    }

}
