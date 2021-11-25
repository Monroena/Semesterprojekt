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
    public int loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) throws SQLException, OurException {
        return LoginController.getLoginControllerOBJ().loginVal(user, pass);
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String doLogin(LoginData loginData){
        return LoginController.getLoginControllerOBJ().doLogin(loginData);
    }

}
