package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Controller("/hello") // <1>
public class HelloController {
    @Get // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    public String index() {
        return "Hello World"; // <4>
    }
    
    @Get("{?name}") // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    public String sayHello(@QueryValue("name") String name) {
    	
    	FileHandler handler = new FileHandler("default.log", true);
        Logger logger = Logger.getLogger("example.micronaut");
        logger.addHandler(handler);
        logger.info("sayHello called with name = " + name);    	
    	
        return "Hello " + name; // <4>
    }    
}
