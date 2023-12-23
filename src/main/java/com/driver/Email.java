package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)){
            if(isPasswordValid(newPassword)){
                this.password = newPassword;
            }
        }
    }

    public boolean isPasswordValid(String newPassword){


        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;

        int i= 0;
        boolean validPass= false;
        if(newPassword.length() < 8) return false;
        while(i < newPassword.length()){
            char ch = newPassword.charAt(i);
            if(ch>='A'&& ch<='Z'){
                containsUpperCase = true;
            } else if(ch>='a'&& ch <='z' ){
                containsLowerCase = true;
            } else if(ch>='0'&& ch <='9' ){
                containsDigit = true;
            }else{
                containsSpecialChar = true;
            }
//            else if(ch>=33&&ch<=47 ||ch>=58&&ch<=64 ||ch>=91&&ch<=96 || ch>=123&&ch<=126){
//                containsSpecialChar = true;
//            }
            i++;
        }
        if(containsUpperCase && containsLowerCase && containsDigit && containsSpecialChar) {
            return true;
        }
        return false;
    }
}
