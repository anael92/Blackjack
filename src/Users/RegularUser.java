package Users;

import DataBase.DB;
import Inteface.IUserAction;

/**
 *
 * @author ANI
 */
public class RegularUser extends User implements IUserAction {

    DB db = DB.getInstance();

    public RegularUser() {
    }

    public RegularUser(int id, String firstName, String lastName,
            String gender, String userName, String password) {
        super(id, firstName, lastName, gender, userName, password, 2);
//2 is regular
    }

    public RegularUser(String firstName, String lastName,
            String gender, String userName, String password, int wins, int balance) {
        super(firstName, lastName, gender, userName, password, 2, wins, balance);
//2 is regular
    }

    @Override
    public void signUp(String firstName, String lastName, String gender,
            String userName, String password) {
        RegularUser user = new RegularUser(firstName, lastName,
                gender, userName, password, 0, 10000);
        db.addUser(user);
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.getPassword().equals(oldPassword)) {
            this.setPassword(newPassword);
            db.changePassword(newPassword, this.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeAccount(User user) {
        db.removeAccount(user);
    }

}
