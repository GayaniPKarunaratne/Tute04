package Model;

public class Users {
    String Uname;
    String Password;

    public Users(String uname, String password) {
        Uname = uname;
        Password = password;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
