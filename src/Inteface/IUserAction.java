/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inteface;

import Users.User;

/**
 *
 * @author IBM
 */
public interface IUserAction {
    
    public abstract void signUp(String firstName,String lastName,String gender,
            String userName,String password);
    public abstract boolean changePassword(String oldPassword,String newPassword);
    public abstract void removeAccount(User user);
    
}
