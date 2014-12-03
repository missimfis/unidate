package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {
            "/loginProcess",
            "/registrationProcess",
            "/dashboard",
            "/nachrichten_detail",
            "/nachrichten_senden",
            "/nachrichtenProcess",
            "/administration",
            "/nachrichten",
            "/chat",
            "/registriert",
            "/profil",
            "/profil_bearbeiten",
            "/profilCheck",
            "/chatSend"})

public class ControllerServlet extends HttpServlet {

    private final Map<String, String> doGetMap = new HashMap<>();
    private final Map<String, String> doPostMap = new HashMap<>();

    public ControllerServlet() {
        // fillup doGetMap data
        doGetMap.put("/nachrichten", "/view/nachrichten");
        doGetMap.put("/nachrichten_detail", "/view/nachrichten_detail");
        doGetMap.put("/nachrichten_senden", "/view/nachrichten_senden");
        doGetMap.put("/registriert", "/view/registriert");
        doGetMap.put("/dashboard", "/view/dashboard");
        doGetMap.put("/profil", "/view/profil");
        doGetMap.put("/profil_bearbeiten", "/view/profil_bearbeiten");
        doGetMap.put("/chat", "/view/chat");

        // fillup doPostMap data
        doPostMap.put("/loginProcess", "/controller/loginProcess");
        doPostMap.put("/registrationProcess", "/controller/registrationProcess");
        doPostMap.put("/nachrichten_senden", "/view/nachrichten_senden");
        doPostMap.put("/nachrichtenProcess", "/controller/nachrichtenProcess");
        doPostMap.put("/administration", "/controller/administration");
        doPostMap.put("/profilCheck", "/controller/profilCheck");
        doPostMap.put("/profil_bearbeiten", "/view/profil_bearbeiten");
        doPostMap.put("/chatSend", "/controller/chatSend");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        userPath = doGetMap.get(userPath);

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF" + userPath + ".jsp";
        
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        userPath = doPostMap.get(userPath);

        // use RequestDispatcher to forward request internally
        String url1 = "/WEB-INF" + userPath + ".jsp";

        request.getRequestDispatcher(url1).forward(request, response);
    }
}