package Projet.Projet_ISI;

import java.util.Collection;


import Projet.Projet_ISI.dao.DemandeurDao;
import Projet.Projet_ISI.dao.ReservationDao;
import Projet.Projet_ISI.metier.Demandeur;
import Projet.Projet_ISI.metier.Reservation;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @GET
	@Path("/chercher")
	@Produces("application/json")
	public Collection<Demandeur> get(){
		
		return DemandeurDao.findAll();
	}
    @GET
	@Path("/getD/{code}")
	@Produces("application/json")
	public Demandeur getById1(@PathParam("code")String code)
	{
		
		
		return DemandeurDao.findById(code);
	}
    @GET
   	@Path("/Reserv")
   	@Produces("application/json")
   	public Collection<Reservation> find(){
   		
   		return ReservationDao.findAll();
   	}
  
    
    @POST
    @Path("add")
	@Produces("application/json")
    public Demandeur save(@QueryParam("code") String code, @QueryParam("nom") String nom, @QueryParam("adresse") String adresse)
    { 
		
		Demandeur d=new Demandeur(code,nom,adresse);
		return DemandeurDao.save(d);
	} 
    @DELETE
    @Path("delete/{code}")
	@Produces("application/json")
    public void delete(@PathParam("code") String code)
    { 
		
		
	 DemandeurDao.delete(code);
	}
}
