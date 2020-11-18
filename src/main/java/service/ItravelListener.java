package service;

import dao.CensoredWordDao;
import utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ItravelListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        CensoredWordDao censoredWordDao = new CensoredWordDao();
        List<String> censoredWordsList = censoredWordDao.getUnhealthyWords();
        servletContext.setAttribute(Constants.CENSORED_WORDS_LIST, censoredWordsList);
    }
}
