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
public interface IAdmin extends IUserAction{
    
    public void changePermission(User user);
    
}
