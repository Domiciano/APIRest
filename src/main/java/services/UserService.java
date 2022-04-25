package services;

import entity.User;
import model.Message;
import provider.UserProvider;

import javax.ws.rs.*;
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

    @POST
    @Path("create")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(User user){
        try {
            UserProvider provider = new UserProvider();
            provider.create(user);
            return Response
                    .status(200)
                    .entity(new Message("info", "Operación exitosa"))
                    .build();
        }catch (Exception exception){
            return Response
                    .status(200)
                    .entity(new Message("Exception", exception.getMessage()))
                    .build();
        }
    }

}
