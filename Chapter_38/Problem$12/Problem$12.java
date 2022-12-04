package chapter38;

/**
 * **38.12 (Opinion poll) Rewrite Exercise 37.13 using JSP.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    // Problem$12.jsp
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String GET_YES_NO_COUNT = "select * from Poll";
    public static final String UPDATE_YES_NO =
            "update Poll set yesCount = ?, noCount = ? where question = 'Are you a CS major? '";
}
