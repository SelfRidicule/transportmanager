package com.myandroid;

public class UserModel {
	public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private  String username ;
    private  String password;


    public void setUserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *  get set
     */
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

}
