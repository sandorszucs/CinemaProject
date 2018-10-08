public class RegisteredUser extends User {

    private String telephoneNumber;
    private String address;
    private char gender;

    public RegisteredUser(String telephoneNumber, String address, char gender) {
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.gender = gender;
    }

    public void login (){ }

    public void logout (){ }

    public void viewMovies() { }

    public void bookTicket (){ }

    public void cancelTicket() { }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void makePayment() {


    }
}
