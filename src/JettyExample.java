import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by vpavlenko on 22.11.14.
 */
public class JettyExample {

    public static void main(String []args) throws Exception {
        Server server = new Server(new InetSocketAddress("0.0.0.0", 10002));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.addServlet(new ServletHolder(new GetServlet()), "/hello");
        context.setContextPath("/");
        server.setHandler(context);
        server.start();
    }
}

class GetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h2>Hello, " + request.getParameter("name") + "</h2>");
    }
}