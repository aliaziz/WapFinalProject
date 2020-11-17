package controller.postServlet;

import controller.BaseServlet;
import dao.PostDao;
import model.Post;
import utils.Constants;
import utils.ServletUrl;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = {ServletUrl.POST_SERVLET, "/user"+ServletUrl.POST_SERVLET})
@MultipartConfig
public class PostServlet extends BaseServlet {
    private final PostDao postDao = new PostDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = getSessionUserId(req);

        String query = req.getParameter("query");
        if (query != null) {
            getSearchedPosts(resp, query);
        } else {
            getPostsFromFollowed(resp, userId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("postDescription");
        List<String> censoredWordsList = (List<String>) req.getServletContext().getAttribute(Constants.CENSORED_WORDS_LIST);
        boolean containsUnhealthy = censoredWordsList.stream().anyMatch(description::contains);

        Part image = req.getPart("postImage");
        String imagePath = saveImage(image, req);
        double postLat = Double.parseDouble(req.getParameter("postLat"));
        double postLong = Double.parseDouble(req.getParameter("postLon"));

        int likes = Integer.parseInt(req.getParameter("likes"));
        int userId = getSessionUserId(req);

        Post post = new Post(imagePath, description, likes, userId, postLat, postLong);
        post.setPostHealth(containsUnhealthy ? 0 : 1);
        boolean inserted = postDao.savePost(post);

        if (inserted) {
            resp.getWriter().write(containsUnhealthy ? "Blocked for review" : "Posted");
        } else {
            resp.sendError(406, "Failed to post");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int userId = getSessionUserId(req);
        boolean deleted = postDao.deletePost(postId, userId);

        if (deleted) {
            resp.getWriter().write("success");
        } else {
            resp.sendError(406);
        }
    }

    private String saveImage(Part part, HttpServletRequest request) throws IOException {
        String folderPath = "itravelImages/";
        String storagePath = request.getServletContext().getRealPath("/")+folderPath;
        File f = new File(storagePath);
        if (!f.exists()) {
            f.mkdir();
        }

        String imageName = Calendar.getInstance().getTimeInMillis() + ".png";
        File imageFile = new File(f, imageName);
        boolean written = ImageIO.write(ImageIO.read(part.getInputStream()), "png", imageFile);
        if (written) return "/WapFinalProject/"+folderPath+imageName;
        else return null;
    }

    private void getSearchedPosts(HttpServletResponse resp, String query) throws IOException {
        List<Post> postList = postDao.searchPost(query);
        String jsonString = gson.toJson(postList);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }

    private void getPostsFromFollowed(HttpServletResponse resp, int userId) throws IOException {
        List<Post> postList = postDao.getPosts(userId);
        String jsonString = gson.toJson(postList);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }
}
