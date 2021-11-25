package api;

import com.google.gson.Gson;
import dataAccesLayer.SQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("import")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
public class ImportService {

    @GET
    public String importerxml() throws SQLException {
        return new Gson().toJson(SQL.getSqlOBJ().getAftalerListe());
    }

}
