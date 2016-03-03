
package Inteface;

import Users.User;

/**
 *
 * @author ANI
 */
public interface IUserAction {
    
    public abstract void signUp(String firstName,String lastName,String gender,
            String userName,String password);
    public abstract boolean changePassword(String oldPassword,String newPassword);
    public abstract void removeAccount(User user);
    
}
