package service;

import utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@WebListener
public class ItravelService implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = System.getProperty("catalina.home");
        ServletContext ctx = sce.getServletContext();
        String relativePath = ctx.getInitParameter("postImageFiles.dir");
        File file = new File(rootPath + File.separator + relativePath);
        if(!file.exists()) file.mkdirs();
        ctx.setAttribute(Constants.POST_FILES_DIR_FILE, file);
        ctx.setAttribute(Constants.POST_FILES_DIR, rootPath + File.separator + relativePath);
    }
}
