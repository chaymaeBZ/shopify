import services.mysql.Mysql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bazzaouichaymae on 12/26/16.
 */
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Mysql mysql = Mysql.sharedInstance();
        String request = "select * from test;";
        mysql.executeQuery(request);

        PrintWriter out = resp.getWriter();
        out.println(request);
    }
}
