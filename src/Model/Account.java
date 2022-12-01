package Model;

public class Account extends Hotel{
    private String username;

    private String password;
    private String name;
    private int age;
    private String sdt;
    private String gender;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String name, int age, String sdt, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sdt = sdt;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "username = " + username+
                ", password = " + password  +
                ", name = " + name +
                ", age = " + age +
                ", sdt = " + sdt +
                ", gender = " + gender ;
    }
}
