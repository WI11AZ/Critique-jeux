package be.heh.application.domain.model;

public class User {
    private String ID;
    private String identifiant;
    private String password;
    private int role;

    public User(String ID, String identifiant, String password, int role){
        this.ID=ID;
        this.identifiant=identifiant;
        this.password=password;
        this.role=role;
    }
    public String getID(){
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
