package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if (!email.contains("@") && !email.contains(".")) {
            throw new IllegalArgumentException(
                    String.format("email address (%s) is invalid", email)
            );
        }
    }

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }


}
