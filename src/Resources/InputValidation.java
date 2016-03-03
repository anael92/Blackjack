
package Resources;

import Users.User;
import DataBase.DB;
import Resources.LocalizationUtil;
import java.util.ResourceBundle;

/**
 *
 * @author ANI
 */
public class InputValidation {
    
    public static ResourceBundle localizedResourceBundle;

    public static void setLocalizedResourceBundle
        (ResourceBundle localizedResourceBundle) {
        InputValidation.localizedResourceBundle = localizedResourceBundle;
    }
    
    public static String checkFirstName(String firstName)
    {
        if (firstName.isEmpty())
            return LocalizationUtil.localizedResourceBundle.getString("Empty");
        else if (firstName.matches(".*\\d+.*"))
            return LocalizationUtil.localizedResourceBundle.getString("Digit");
        else 
           return "";
    }
    
        public static String checkLastName(String lastName)
    {
        if (lastName.isEmpty())
            return LocalizationUtil.localizedResourceBundle.getString("Empty");
        else if (lastName.matches(".*\\d+.*"))
            return LocalizationUtil.localizedResourceBundle.getString("Digit");
        else 
           return "";
    }
        
    public static String checkUserName(String userName)
    {
        // think about it
       DB db = DB.getInstance();
       for (User u : db.getUsers())
       {
           if (u.getUserName().equals(userName))
               return LocalizationUtil.localizedResourceBundle
                       .getString("UserNameTaken");
       } 
       if (userName.length() > 20 || userName.length() < 4)
           return LocalizationUtil.localizedResourceBundle
                   .getString("UserNameLegnth");
       else if (userName.isEmpty())
           return LocalizationUtil.localizedResourceBundle
                   .getString("Empty");
       
       return "";
    }
    
    
    public static String checkPassword(String password)
    {
       if (password.length() < 6 || password.length() > 20) 
           return LocalizationUtil.localizedResourceBundle
                   .getString("PasswordLength");
       else if (password.isEmpty())
         return LocalizationUtil.localizedResourceBundle
                 .getString("Empty");
       
       return "";

    }
}
