package controlador;

import modelo.BeanPersona;
import servicios.ServicePersona;
import utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletPersona",
        urlPatterns = {
                "/get-personas",
                "/add-persona",
                "/create-persona",
                "/save-persona",
                "/get-persona",
                "/delete-persona"
        })

public class ServletPersona extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPersona");
    String action;
    String urlRedirect = "/get-personas";
    ServicePersona servicePersona = new ServicePersona();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-personas":
                List<BeanPersona> personas = servicePersona.getAll();
                System.out.println(personas.size());
                request.setAttribute("personas", personas);
                urlRedirect = "/views/index.jsp";
                break;
            case "/create-persona":
                urlRedirect = "/views/create.jsp";
                break;
            case "/get-persona":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanPersona persona = servicePersona.getPersona(Long.parseLong(id));
                    request.setAttribute("persona", persona);
                    urlRedirect = "/views/update.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-personas";
                }
                break;
            default:
                request.setAttribute("personas", servicePersona.getAll());
                urlRedirect = "/get-personas";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/add-persona":
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String curp = request.getParameter("curp");
                String birthday = request.getParameter("birthday");
                BeanPersona persona = new BeanPersona();
                persona.setName(name);
                persona.setSurname(surname);
                persona.setCurp(curp);
                ResultAction result = servicePersona.save(persona);
                urlRedirect = "/get-personas?result=" +
                        result.isResult() + "&message=" +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result.getStatus();
                break;
            case "/save-persona":
                String name2 = request.getParameter("name");
                String surname2 = request.getParameter("surname");
                String curp2 = request.getParameter("curp");
                String birthday2 = request.getParameter("birthday");
                String id = request.getParameter("id");

                BeanPersona persona2 = new BeanPersona();
                persona2.setId(Long.parseLong(id));
                persona2.setName(name2);
                persona2.setSurname(surname2);
                persona2.setCurp(curp2);
                ResultAction result2 = servicePersona.update(persona2);

                urlRedirect = "/get-personas?result=" +
                        result2.isResult() + "&message=" +
                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result2.getStatus();
                break;
            case "/delete-persona":
                String idPersona = request.getParameter("id");
                ResultAction deleteResult = servicePersona.delete(idPersona);
                urlRedirect = "/get-personas?result=" +
                        deleteResult.isResult() + "&message=" +
                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + deleteResult.getStatus();
                break;
            default:
                urlRedirect = "/get-personas";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}