package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Aluno;
import persistence.AlunoDao;

@Path("/aluno")
public class ServiceAluno {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public String gravar(String aluno) {
	  	try {  
		 Aluno  alu= new Gson().fromJson(aluno, Aluno.class);
		   alu.afterConstruct().gerarSituacao().gerarCriptografia(); 	
		   new AlunoDao().create(alu);
		   
			 return new Gson().toJson(alu) ; //resgate em JSON
		}catch(Exception ex) {
		 return "Error :" + ex.getMessage(); 
	 }
   }

@GET
 public String listar() {
	 try {
             return new Gson().toJson(new AlunoDao().findAll());
	 }catch(Exception ex) {
		 return null;
	 }
}

@Path("/logar")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String logar(String aluno) {
	try {
	Aluno resposta =new Gson().fromJson(aluno, Aluno.class);
	 Aluno banco = new AlunoDao().findByLogout(resposta.gerarCriptografia());
	 if (banco==null) {
		 throw new Exception("Login nao Realizado, falha...");
	 }
	 return new Gson().toJson(banco);
	}catch(Exception ex) {
		return "Error : " + ex.getMessage();
	}
}

@Path("/{id}")
@GET
public String BuscarCod(@PathParam("id") String id ) {
	 try {
            return new Gson().toJson(new AlunoDao().findById(new Integer(id)));
	 }catch(Exception ex) {
		   return "Error : Id Nao Encontrado";
	 }
}






















}
