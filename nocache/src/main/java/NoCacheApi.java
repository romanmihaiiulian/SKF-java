import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

/**
 * Created by mihairoman on 26/11/2016.
 */
@Path("/nocache")
public class NoCacheApi {

    @GET
    @Path("/cachecontrol")
    public Response noCache() {
        Response.ResponseBuilder resp = Response.ok("cachecontrol");

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(-1);
        cacheControl.setNoCache(true);
        cacheControl.setMustRevalidate(true);

        resp.cacheControl(cacheControl);

        return resp.build();
    }

    @GET
    @Path("/headers")
    public Response nocacheWithHeaders() {
        Response.ResponseBuilder resp = Response.ok("headers");

        resp.header("Pragma", "no-cache");
        resp.header("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.header("Expires", "0");

        return resp.build();
    }

    @GET
    @Path("/filter")
    public Response nocacheWithFilters() {
        Response.ResponseBuilder resp = Response.ok("filters");

        resp.header("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.header("Pragma", "no-cache");
        resp.header("Expires", "0");

        return resp.build();
    }
}
