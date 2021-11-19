import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("aftaler")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML})
public class AftaleService {

    @GET
    public List<Aftale> getPatient(@QueryParam("cpr") String cpr) throws SQLException, OurException {
        return AftaleController.getAftaleControllerOBJ().cprSearch(cpr).getAftaler();
    }

    @Path("aftalerSQL")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String makepatientSQL(@QueryParam("cpr") String cpr, @QueryParam("timestart")
            String timestart, @QueryParam("timeend") String timeend, @QueryParam("note") String notat) throws SQLException, OurException {
        return AftaleController.getAftaleControllerOBJ().createAftale(cpr, timestart, timeend, notat);
    }

    @Path("aftalerSQL")
    @GET
    public String selectFromTime(@QueryParam("from") String from, @QueryParam("to") String to) throws SQLException {
        return new Gson().toJson(SQL.getSqlOBJ().getAftaleListeDateTime(from, to));
    }
}
