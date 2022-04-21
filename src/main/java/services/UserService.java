package services;

import entity.User;
import model.Message;
import provider.UserProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("user")
public class UserService {

    @GET
    @Path("all/{page}")
    @Produces("application/json")
    public Response getAll(@PathParam("page") int page){
        try {
            UserProvider provider = new UserProvider();
            ArrayList<User> users = provider.getAllUsers(page);
            return Response
                    .status(200)
                    .entity(users)
                    .build();
        }catch (SQLException ex){
            Message m = new Message("SQL Exception",ex.getMessage());
            return Response
                    .status(500)
                    .entity(m)
                    .build();
        }catch (ClassNotFoundException ex){
            Message m = new Message("Class not found Exception",ex.getMessage());
            return Response
                    .status(500)
                    .entity(m)
                    .build();
        }
    }

}
