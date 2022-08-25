package controlador;

import modelo.BeanCoche;
import servicios.ServiceCoche;
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

@WebServlet(name = "ServletCoche",
        urlPatterns = {
                "/get-coches",
                "/add-coche",
                "/create-coche",
                "/save-coche",
                "/get-coche",
                "/delete-coche"
        })

public class ServletCoche extends HttpServlet {
    Logger logger = Logger.getLogger("ServletCoche");
    String action;
    String urlRedirect = "/get-coches";
    ServiceCoche serviceCoche = new ServiceCoche();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-coches":
                List<BeanCoche> coches = serviceCoche.getAll();
                System.out.println(coches.size());
                request.setAttribute("coches", coches);
                urlRedirect = "/views/index.jsp";
                break;
            case "/create-coche":
                urlRedirect = "/views/create.jsp";
                break;
            case "/get-coche":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanCoche coche = serviceCoche.getCoche(Long.parseLong(id));
                    request.setAttribute("coche", coche);
                    urlRedirect = "/views/update.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-coches";
                }
                break;
            default:
                request.setAttribute("coches", serviceCoche.getAll());
                urlRedirect = "/get-coches";
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
            case "/add-coche":
                String modelo = request.getParameter("modelo");
                String matricula = request.getParameter("matricula");
                Long id_persona = Long.valueOf(request.getParameter("id_persona"));
                BeanCoche coche = new BeanCoche();
                coche.setModelo(modelo);
                coche.setMatricula(matricula);
                coche.setId_persona(id_persona);
                ResultAction result = serviceCoche.save(coche);
                urlRedirect = "/get-coches?result=" +
                        result.isResult() + "&message=" +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result.getStatus();
                break;
            case "/save-coche":
                String modelo2 = request.getParameter("modelo");
                String matricula2 = request.getParameter("matricula");
                long id_persona2 = Long.parseLong(request.getParameter("id_persona"));
                String id = request.getParameter("id");

                BeanCoche coche2 = new BeanCoche();
                coche2.setId(Long.parseLong(id));
                coche2.setModelo(modelo2);
                coche2.setMatricula(matricula2);
                coche2.setId_persona(id_persona2);
                ResultAction result2 = serviceCoche.update(coche2);

                urlRedirect = "/get-coches?result=" +
                        result2.isResult() + "&message=" +
                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result2.getStatus();
                break;
            case "/delete-coche":
                String idCoche = request.getParameter("id");
                ResultAction deleteResult = serviceCoche.delete(idCoche);
                urlRedirect = "/get-coches?result=" +
                        deleteResult.isResult() + "&message=" +
                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + deleteResult.getStatus();
                break;
            default:
                urlRedirect = "/getcoches";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}