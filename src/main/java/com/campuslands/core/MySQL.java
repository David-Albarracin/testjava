package com.campuslands.core;

public class MySQL {

    protected final String url;
    protected final String user;
    protected final String password;

    public MySQL() {
        this.url = "jdbc:mysql://localhost:3306/cinecampus";
        //this.user = "campus2023";
        //this.password = "campus2023";
        this.user = "root";
        this.password = "123456";
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}