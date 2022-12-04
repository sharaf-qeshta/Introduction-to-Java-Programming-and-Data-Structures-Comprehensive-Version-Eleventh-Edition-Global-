package chapter38;

/**
 * ***38.13 (Multiple-question opinion poll) The Poll table in Exercise 37.13 contains only
 * one question. Suppose you have a Poll table that contains multiple questions.
 * Write a JSP that reads all the questions from the table and display them in a form,
 * as shown in Figure 38.13a. When the user clicks the Submit button, another JSP
 * page is invoked. This page updates the Yes or No counts for each question and
 * displays the current Yes and No counts for each question in the Poll table, as
 * shown in Figure 38.13b. Note that the table may contain many questions. The
 * questions in the figure are just examples. Sort the questions in alphabetical order.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    // see Problem$13a.jsp and Problem$13b.jsp
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String GET_ALL_QUESTIONS = "select * from Poll";
    public static final String UPDATE_YES_NO =
            "update Poll set yesCount = ?, noCount = ? where question = ?";
}
