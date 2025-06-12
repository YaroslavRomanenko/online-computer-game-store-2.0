package com.example.coollookingapp;

public class DbConfig {
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;

    public DbConfig() {}

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public String getDatabase() { return database; }
    public void setDatabase(String database) { this.database = database; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getJdbcUrl() {
        return String.format("jdbc:postgresql://%s:%d/%s?currentSchema=public&user=%s&password=%s", host, port, database, user, password);
    }
}
