package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDao extends Dao {
	
	  public void create(Aluno a) throws Exception{
		    if (a.getNota1()<0 | a.getNota1()>10) {
		    	throw new IllegalArgumentException("Nota1 Invalida");
		    }
		    if (a.getNota2()<0 | a.getNota2()>10) {
		    	throw new IllegalArgumentException("Nota2 Invalida");
		    }
		   open(); 
		   stmt = con.prepareStatement("insert into aluno values  "
		   		+ "       (null,?,?,?,?,?,?,?,?) ");
		     stmt.setString(1,a.getNome());
		     stmt.setString(2,a.getEmail());
		     stmt.setString(3,a.getDisciplina());
		     stmt.setDouble(4,a.getNota1());
		     stmt.setDouble(5,a.getNota2());
		     stmt.setString(6,a.getSenha());
		     stmt.setString(7,a.getSituacao());
		    stmt.setString(8, a.getFoto());
          stmt.execute();
          stmt.close();
          close();
	  }
	  
	  public List<Aluno> findAll() throws Exception{
		   open();
		    stmt = con.prepareStatement("select * from aluno");
		    List<Aluno > alunos = new ArrayList<Aluno>();
		    rs = stmt.executeQuery();
		    while(rs.next()){
		    	Aluno a= new Aluno    (rs.getInt(1),
		    		rs.getString(2), rs.getString(3),rs.getString(4),
            		rs.getDouble(5),rs.getDouble(6), rs.getString(7),
            		rs.getString("foto"));
		      	a.setSituacao(rs.getString("situacao"));
		    	alunos.add(a);
		    }
		    close();
		    return alunos;
	  }
	  
	  public  Aluno findById(Integer id) throws Exception{
		  Aluno resp = findAll().stream().filter
  (x->x.getId().equals(id)).findAny().orElse(null);
		  return resp;
	  }
	  public  Aluno findByLogout(Aluno a) throws Exception{
		  Aluno resp = findAll().stream().filter(
      x->a.getEmail().equals(x.getEmail())    &      a.getSenha().equals(x.getSenha()) 
    		  ).findAny().orElse(null);
		  return resp;
	  }
	  
	  
	  
	  public static void main(String[] args) {
		try {
			 AlunoDao dao =new AlunoDao();
     		 Aluno a = new Aluno(null,"joao","joao@gmail.com",
					 "java",2., 2.,"123456","joao.jpg").
					 afterConstruct().gerarSituacao().gerarCriptografia();
			 dao.create(a);
			 AlunoDao dao2 =new AlunoDao();
			 Aluno b = new Aluno(null,"vitu","vitu@gmail.com",
					 "java",1., 2.,"123456","vitu.jpg").
					 afterConstruct().gerarSituacao().gerarCriptografia();
			 
			  dao2.create(b);
		Aluno c = new Aluno(null,"lu","lu@gmail.com",
						 "java",8., 10.,"123456","lu.jpg").
						 afterConstruct().gerarSituacao().gerarCriptografia();
		 AlunoDao dao3 =new AlunoDao();
		 dao3.create(c);
			  System.out.println(dao.findAll());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	  
	  
	  
	  
}
