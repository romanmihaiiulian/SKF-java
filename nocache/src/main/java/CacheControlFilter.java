import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by mihairoman on 26/11/2016.
 */
@Provider
public class CacheControlFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains("filter")) {
            containerResponseContext.getHeaders().add("Cache-Control", "no-cache, no-store, must-revalidate");
            containerResponseContext.getHeaders().add("Pragma", "no-cache");
            containerResponseContext.getHeaders().add("Expires", "0");
        }
    }
}
