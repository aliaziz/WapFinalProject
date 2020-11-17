package service;

import dao.CensoredWordDao;
import dao.DBConnection;
import utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.List;

@WebListener
public class ItravelService implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = System.getProperty("catalina.home");
        ServletContext servletContext = sce.getServletContext();
        String relativePath = servletContext.getInitParameter("postImageFiles.dir");
        File file = new File(rootPath + File.separator + relativePath);
        if(!file.exists()) file.mkdirs();
        servletContext.setAttribute(Constants.POST_FILES_DIR_FILE, file);
        servletContext.setAttribute(Constants.POST_FILES_DIR, rootPath + File.separator + relativePath);

        CensoredWordDao censoredWordDao = new CensoredWordDao();
        List<String> censoredWordsList = censoredWordDao.getUnhealthyWords();
        servletContext.setAttribute(Constants.CENSORED_WORDS_LIST, censoredWordsList);
    }
}
