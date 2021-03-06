package resources;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.EventoDAO;
import modelo.Clientes;


@Path("listarclientes")
public class ClientesPorEventoWebService {
	
	private ArrayList<Clientes> listaClientesDAO;
	private Clientes cliente = new Clientes();

	@GET
	@Path("codigoEvento/{codEvento}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Clientes> listarClientesPorEvento(@PathParam("codEvento") int codEvento){
		
		EventoDAO eventoDAO = new EventoDAO();
		
		listaClientesDAO = new ArrayList<>();
		listaClientesDAO = eventoDAO.listarClientesPorEvento(codEvento);
		
		return listaClientesDAO;
		
		}
	
	@GET
	@Path("cpfCliente/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clientes buscarCliente(@PathParam("cpf") BigDecimal cpf) {
		
		ClienteDAO cliDAO = new ClienteDAO();
		
		cliente = cliDAO.buscarCliente(cpf);
		
		return cliente;
	}
	
}