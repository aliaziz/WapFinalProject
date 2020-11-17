package controller.adminServlet;

import controller.BaseServlet;
import dao.CensoredWordDao;
import utils.Constants;
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
        resp.sendRedirect("censoredWords.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        boolean added = censoredWordDao.addWord(word);
        List<String> censoredWordsList = (List<String>) req.getServletContext().getAttribute(Constants.CENSORED_WORDS_LIST);

        if (added) {
            censoredWordsList.add(word);
            req.getServletContext().setAttribute(Constants.CENSORED_WORDS_LIST, censoredWordsList);
            resp.getWriter().write("success");
        } else resp.getWriter().write("failed");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        boolean deleted = censoredWordDao.removeWord(word);
        List<String> censoredWordsList = (List<String>) req.getServletContext().getAttribute(Constants.CENSORED_WORDS_LIST);

        if (deleted) {
            censoredWordsList.remove(word);
            req.getServletContext().setAttribute(Constants.CENSORED_WORDS_LIST, censoredWordsList);
            resp.getWriter().write("success");
        } else resp.getWriter().write("failed");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldWord = req.getParameter("oldWord");
        String newWord = req.getParameter("newWord");
        boolean updated = censoredWordDao.updateWord(oldWord, newWord);
        List<String> censoredWordsList = (List<String>) req.getServletContext().getAttribute(Constants.CENSORED_WORDS_LIST);

        if (updated) {
            censoredWordsList.remove(oldWord);
            censoredWordsList.add(newWord);
            req.getServletContext().setAttribute(Constants.CENSORED_WORDS_LIST, censoredWordsList);
            resp.getWriter().write("success");
        } else resp.getWriter().write("failed");
    }
}
