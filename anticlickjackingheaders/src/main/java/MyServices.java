import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mihairoman on 26/11/2016.
 */
@ApplicationPath("/api")
public class MyServices extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(AntiClickJackingHeaders.class);
//        set.add(CacheControlFilter.class);
        return set;
    }
}
