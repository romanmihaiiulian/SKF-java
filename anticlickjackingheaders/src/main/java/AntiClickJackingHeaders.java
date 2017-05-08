import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by mihairoman on 08/05/2017.
 */
@Path("/antiClickJackingHeaders")
public class AntiClickJackingHeaders {

    @GET
    public Response antiClickJackingHeaders() {
        Response.ResponseBuilder response = Response.ok();

        //this will completely prevent your page from being displayed in an iframe.
        response.header("X-Frame-Options", "deny");

        //this will completely prevent your page from being displayed in an iframe on other sites.
        response.header("X-Frame-Options", "SAMEORIGIN");

        return response.build();
    }
}
