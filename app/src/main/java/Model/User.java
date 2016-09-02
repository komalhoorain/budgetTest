package Model;

/**
 * Created by Komal UETian on 8/29/2016.
 */
public class User {
    private int userID;
    private String Name;
    private String Email;
    private String Username;
    private String Passowrd;
    private String Description;


    public User()
    {

    }

    public User(int id, String name, String email, String username, String passowrd, String description) {
        this.userID = id;
        this.Name = name;
        this.Email= email;
        this.Username=username;
        this.Passowrd=passowrd;
        this.Description=description;
    }

    public User(User user)
    {
        this.userID = user.userID;
        this.Name = user.Name;
        this.Email= user.Email;
        this.Username= user.Username;
        this.Passowrd=user.Passowrd;
        this.Description=user.Description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassowrd() {
        return Passowrd;
    }

    public void setPassowrd(String passowrd) {
        Passowrd = passowrd;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
