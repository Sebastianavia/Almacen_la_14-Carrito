package config;
import services.UserServices;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
@ApplicationPath("api")
public class ApplicationConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> recursos = new HashSet<>();
        recursos.add(services.UserServices.class);
        recursos.add(services.OrderServices.class);
        recursos.add(services.ProductoServices.class);
        recursos.add(services.Oerder_ProductServices.class);
        return recursos;
    }
}