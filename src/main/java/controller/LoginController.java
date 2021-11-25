package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataAccesLayer.SQL;
import exceptions.OurException;
import model.LoginData;
import model.User;

import javax.ws.rs.WebApplicationException;
import java.sql.SQLException;

public class LoginController {

    private LoginController() {
    }

    static private final LoginController loginControllerOBJ = new LoginController();

    static public LoginController getLoginControllerOBJ() {
        return loginControllerOBJ;
    }

    public boolean loginVal(String brugerliste, String pass){
        if (brugerliste.length() > 1) {
            String[] opdelt = brugerliste.split("A");
            if (opdelt[1].equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public String doLogin(LoginData loginData) {
        try {
            // sql kald der kontrollere om brugeren eksitere
            String brugerListe = SQL.getSqlOBJ().hentBrugerListe(loginData.getUsername());

            // kontrol af login og generer token
            if (loginVal(brugerListe, loginData.getPassword())) {
                User user = new User(loginData);
                return JWTHandler.generateJwtToken(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            throw new WebApplicationException("fejl", 401);
    }
}

