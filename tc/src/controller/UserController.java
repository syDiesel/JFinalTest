package controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import interceptor.AuthInterceptor;
import service.UserService;
import validator.LoginValidator;

import java.io.File;
import java.util.UUID;

/**
 * Created by reeco_000 on 2015/7/22.
 */
public class UserController extends Controller {
    private UserService userService = new UserService();

    public void index() {
    }

    @Before(LoginValidator.class)
    public void login() {
        String username = getPara("username");
        String password = getPara("password");
        boolean loginCheck = userService.login(username, password);
        if (loginCheck) {
            renderJson("10000");
            setSessionAttr("flag", true);

        } else
            renderJson("10001");
    }

    public void register() {
        String username = getPara("username");
        String password = getPara("password");
        boolean result = userService.add(username, password);
        if (result)
            renderJson("10010");
        else
            renderJson("10011");
    }

    @Before(AuthInterceptor.class)
    public void show() {
        renderJsp("user.jsp");
    }

    public void image() {
        try {

            String folderName = UUID.randomUUID().toString();
            UploadFile files = getFile(getPara("img"), folderName);
            File img = new File("d:"+folderName);
            img.createNewFile();
            renderJson("20010");
        } catch (Exception e) {
            renderJson("20012");
        }
    }
}