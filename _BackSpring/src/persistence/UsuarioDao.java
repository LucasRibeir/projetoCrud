package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao{
	
	 public  void  create(Usuario u)throws Exception{
		 open();
		  stmt = con.
 prepareStatement("insert into usuario values (null,?,?,?)");
		  stmt.setString(1,u.getNome());
		  stmt.setString(2,u.getLogin());
		  stmt.setString(3, u.getSenha());
		  stmt.execute();
		 stmt.close();
		 close();
	 }
	 
	 public List<Usuario> findAll()throws Exception{
		 open();
		  stmt = con.prepareStatement("select * from usuario");
		  rs = stmt.executeQuery();
		  List<Usuario> lista =new ArrayList<Usuario>();
		  while(rs.next()) {
			Usuario u = new Usuario();
			   u.setId(rs.getInt(1));
			   u.setNome(rs.getString(2));
			   u.setLogin(rs.getString(3));
			   u.setSenha(rs.getString(4));
			 lista.add(u);
		  }
		 close();
		 return lista;
	 }
	 
	 public  Usuario findByLogin(Usuario u)throws Exception{
		 open();
		  stmt = con.
 prepareStatement("select * from usuario where login=? and senha=?");
		  stmt.setString(1, u.getLogin());
		  stmt.setString(2, u.getSenha());
		  rs = stmt.executeQuery();
		  Usuario logar=null;
		  if(rs.next()) {
			logar = new Usuario();
			   logar.setId(rs.getInt(1));
			   logar.setNome(rs.getString(2));
			   logar.setLogin(rs.getString(3));
			   logar.setSenha(rs.getString(4));
		  }
		 close();
		 return logar;
	 }
	 
	 
	 
	 
	 
	 
	 public static void main(String[] args) {
		try {
			UsuarioDao dao = new UsuarioDao();
			
			dao.findAll().forEach(System.out::println);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage()); 
			
		}
	}
	 
	 

}
