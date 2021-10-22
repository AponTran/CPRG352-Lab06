
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AponTran
 */

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("userName");

        if (username != null) {
           String actionValue = request.getParameter("action");
            if (actionValue != null && actionValue.equals("logout") ) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set section
        HttpSession session = request.getSession();
        String actionValue = request.getParameter("action");
        
        if (actionValue.equals("register")) {
            String username = request.getParameter("username");
            if (username != null) {
                session.setAttribute("userName", username);
                response.sendRedirect("ShoppingList");
                return;
            }
            else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }
        //add funtcion
        else if (actionValue.equals("add")) {
            
            ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemAdded");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
            if (!request.getParameter("itemadded").isEmpty()) {
                String item = request.getParameter("itemadded");
                itemList.add(item);
                session.setAttribute("itemAdded", itemList);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        // delete function
        else if (actionValue.equals("delete")) {
            ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemAdded");
            String deleteItem = request.getParameter("items");
            if (deleteItem != null) {
                itemList.remove(deleteItem);
            }
            session.setAttribute("itemAdded", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
    }
}
