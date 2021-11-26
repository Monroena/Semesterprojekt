package api;

import controller.LoginController;
import exceptions.OurException;
import model.LoginData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("login")
@Produces({MediaType.TEXT_PLAIN})
public class LoginService {

    @GET
    public String loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass){
        LoginData loginData = new LoginData(user, pass);
        System.out.println("kontrol1"+ " " + user + " " + pass);
        return LoginController.getLoginControllerOBJ().doLogin(loginData);
    }
}
