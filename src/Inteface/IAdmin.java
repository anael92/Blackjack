
package Inteface;

import Users.User;

/**
 *
 * @author ANI
 */
public interface IAdmin extends IUserAction{
    
    public void changePermission(User user);
    
}
