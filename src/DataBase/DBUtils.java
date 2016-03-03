package DataBase;

/**
 *
 * @author ANI
 */
public class DBUtils {
//    public static final String DbUrl = "jdbc:derby://localhost:1527/BLACKJACK";

//This line will automatically create the database BLACKJACK and connect to
//the schema. you only need to start the Java DB Server
    public static final String DbUrl
            = "jdbc:derby://localhost:1527/BLACKJACK;create=true";
    public static final String DbDriverClass = "org.apache.derby.jdbc.ClientDriver";
    public static final String DbUser = "blackjack";
    public static final String DbPassword = "blackjack";
}
