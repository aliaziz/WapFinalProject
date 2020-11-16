package controller.adminServlet;

import controller.BaseServlet;
import dao.CensoredWordDao;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {ServletUrl.CENSORED_WORD_SERVLET, "/admin" + ServletUrl.CENSORED_WORD_SERVLET})
public class CensoredWordsServlet extends BaseServlet {
    private CensoredWordDao censoredWordDao = new CensoredWordDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = censoredWordDao.getUnhealthyWords();
        req.getSession().setAttribute("censoredWords", list);
        resp.sendRedirect("censoredWords.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        boolean added = censoredWordDao.addWord(word);

        if (added) resp.getWriter().write("success");
        else resp.getWriter().write("failed");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        boolean deleted = censoredWordDao.removeWord(word);

        if (deleted) resp.getWriter().write("success");
        else resp.getWriter().write("failed");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldWord = req.getParameter("oldWord");
        String newWord = req.getParameter("newWord");
        boolean updated = censoredWordDao.updateWord(oldWord, newWord);

        if (updated) resp.getWriter().write("success");
        else resp.getWriter().write("failed");
    }
}
