package com.example.demo;


import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.ui.Model;

@Named
@Path("/MyApp")
public class GreetingController {

	@GET
    @Path("/greeting")
	//@Template(name = "/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Amit");
        return "greeting";
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String index() {
		return "index";
	}

	
	/*@Path("/check")
	@RolesAllowed("ADMIN")*/
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String check() {
		return "check";
	}
	
	
	

}