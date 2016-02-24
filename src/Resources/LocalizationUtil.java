/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author IBM
 */
public class LocalizationUtil {
        public static ResourceBundle localizedResourceBundle;
        
        
     public static ResourceBundle getBundleWelcomeScreenEN()
     {
          localizedResourceBundle = ResourceBundle.getBundle("Resources.UiWelcomeScreen");
          return localizedResourceBundle;
     }
     
     public static ResourceBundle getBundleWelcomeScreenIW()
     {
          localizedResourceBundle = ResourceBundle.getBundle("Resources.UiWelcomeScreen_iw", new Locale("iw"));
          return localizedResourceBundle;
     }
     
      public static ResourceBundle getBundleSignUpScreenEN()
     {
          localizedResourceBundle = ResourceBundle.getBundle("UiSignUp");
          return localizedResourceBundle;
     }
     
     public static ResourceBundle getBundleSignUpScreenIW()
     {
          localizedResourceBundle = ResourceBundle.getBundle("Resources.UiSignUp_iw", new Locale("iw"));
          return localizedResourceBundle;
     }
     
          
     public static ResourceBundle getBundleHomeIW()
     {
          localizedResourceBundle = ResourceBundle.getBundle("Resources.UiHome_iw", new Locale("iw"));
          return localizedResourceBundle;
     }
               
     public static ResourceBundle getBundleListOfUsersIW()
     {
          localizedResourceBundle = ResourceBundle.getBundle("Resources.UiListOfUsers_iw", new Locale("iw"));
          return localizedResourceBundle;
     }
     
         public static void changeOptionPane()
     {      
        ResourceBundle bundle = ResourceBundle.getBundle("Resources.JOptionPane_iw", new Locale("iw"));

        UIManager.put("OptionPane.yesButtonText", bundle.getString("Yes"));
        UIManager.put("OptionPane.noButtonText", bundle.getString("No"));
        UIManager.put("OptionPane.cancelButtonText", bundle.getString("Cancel"));
        UIManager.put("OptionPane.okButtonText", bundle.getString("Ok"));
     }
    public static boolean changePaswword_iw(Object[] message)
    {

        changeOptionPane();
        message[0] = "סיסמא קודמת";
        message[2] = "סיסמא חדשה";
        int option = JOptionPane.showConfirmDialog(null, message, "שינוי סיסמא",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    
        
}
