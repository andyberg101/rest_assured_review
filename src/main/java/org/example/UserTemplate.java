package org.example;

public class UserTemplate {
    private int id;
    private String name;
    private String email;
    private String status;
    private String gender;


    public int getUserID() {
        return id;
    }

    public void setUserID(int value) {
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
        if (!(object instanceof UserTemplate userTemplate)) return false;
        return
                getName().equals(userTemplate.getName()) &&
                getEmail().equals(userTemplate.getEmail())&&
                getGender().equals(userTemplate.getGender())&&
                getStatus().equals(userTemplate.getStatus());
    }
}
