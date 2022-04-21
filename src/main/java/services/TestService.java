package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestService {

    @GET
    @Path("index")
    public String index(){
        return "<b>index</b>";
    }

}
