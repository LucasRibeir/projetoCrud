package service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import entity.Usuario;
import persistence.UsuarioDao;

@Path("usuario")
public class ServiceUsuario {
 
	@GET
	@Path("/gravar/{nome}/{login}/{senha}")
	public  String  gravarGet(
    @PathParam("nome")   String nome,
	 @PathParam("login") String login,
	 @PathParam("senha") String senha
			) {
		Usuario u = new Usuario(null,nome,login,senha);
		try {
          new UsuarioDao().create(u);
		  return "Dados Gravados";	
		}catch(Exception ex) {
		 return "Error Na Gravacao";
		}
	}
	
	@GET
	@Path("/logar/{login}/{senha}")
	public  String  LogarGet(
	 @PathParam("login") String login,
	 @PathParam("senha") String senha
			) {
		Usuario u = new Usuario(null,null,login,senha);
		try {
          Usuario resposta = new UsuarioDao().findByLogin(u);
		  return new Gson().toJson(resposta);	
		}catch(Exception ex) {
		 return "Error no Login";
		}
	}
	
	@GET
	public  String  listar() {
		try {
        List<Usuario>lista = new UsuarioDao().findAll();
		  return new Gson().toJson(lista);	
		}catch(Exception ex) {
		 return "Error no Login";
		}
	}
	
	
	
}
