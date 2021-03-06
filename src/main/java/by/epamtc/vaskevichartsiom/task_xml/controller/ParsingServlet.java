package by.epamtc.vaskevichartsiom.task_xml.controller;

import by.epamtc.vaskevichartsiom.task_xml.model.Banks;
import by.epamtc.vaskevichartsiom.task_xml.service.FileHandler;
import by.epamtc.vaskevichartsiom.task_xml.service.ParserService;
import org.xml.sax.SAXException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@MultipartConfig
public class ParsingServlet extends HttpServlet {
    private final String RESULT = "result.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parserType = request.getParameter("parserType");
        try {
            new FileHandler().updateFile("temp", request);
            Banks banks = new ParserService().parseXML(parserType,"temp");
            request.setAttribute("banks", banks.getBanks());
            request.setAttribute("parserType", parserType);
            request.getRequestDispatcher(RESULT).forward(request, response);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
