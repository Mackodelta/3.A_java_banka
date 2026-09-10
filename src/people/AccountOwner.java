package people;

public class AccountOwner {
    private String uuid;
    public String name;
    public String lastname;
    public AccountOwner(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
}
