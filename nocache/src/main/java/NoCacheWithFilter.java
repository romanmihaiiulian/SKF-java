import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by mihairoman on 26/11/2016.
 */
@Path("/nocache/filter")
public class NoCacheWithFilter {

    @GET
    public Response noCacheWithFilter() {
        return Response.ok().build();
    }
}
