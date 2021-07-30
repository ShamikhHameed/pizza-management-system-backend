package com.nsss.pizzamanagementsystembackend.request;

public class PasswordChangeRequest {
    private String username;
    private String existingPassword;
    private String newPassword;

    public PasswordChangeRequest(String username, String existingPassword, String newPassword) {
        this.username = username;
        this.existingPassword = existingPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExistingPassword() {
        return existingPassword;
    }

    public void setExistingPassword(String existingPassword) {
        this.existingPassword = existingPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
