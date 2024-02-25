package org.example;

public class NewUser {
    private int id;
    private String name;
    private String email;
    private String status;
    private String gender;


    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(String value) {
        this.gender = value;
    }

    public String getGender() {
        return gender;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof NewUser newUser)) return false;
        return
                getName().equals(newUser.getName()) &&
                        getEmail().equals(newUser.getEmail()) &&
                        getGender().equals(newUser.getGender()) &&
                        getStatus().equals(newUser.getStatus());
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
