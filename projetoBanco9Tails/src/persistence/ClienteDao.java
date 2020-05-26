package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import entity.Cliente;
import entity.Endereco;

public class ClienteDao {
	EntityManager manager;
    TypedQuery<Cliente> query;
    
    public ClienteDao() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PUhiber");
    	if(manager==null) {
    		manager = factory.createEntityManager();
    	}
    }

public void create (Cliente c, Endereco e) throws Exception{
	manager.getTransaction().begin();
	manager.persist(c);
	e.setCliente(c);
	manager.persist(e);
	manager.getTransaction().commit();
}

public void delete (Cliente c, Endereco e) throws Exception{
	manager.getTransaction().begin();
	manager.remove(c);
	e.setCliente(c);
	manager.remove(e);
	manager.getTransaction().commit();
}



public List<Cliente> findAll() throws Exception{
	List<Cliente> lista = manager.createQuery("select o from Cliente as o", Cliente.class).getResultList();
	return lista;
}



public static void main(String[] args) {
Cliente x = new Cliente(null, "KArla","karla@gmail.com", "3788-5572");

Endereco e = new Endereco(null, "Rua joao n, 44", "Vila nova " , "Nova iguaçu" , "RJ" , "265621-30");
try {
	ClienteDao dao = new ClienteDao();
	dao.create(x, e);
	
//	for (Cliente cli : dao.findAll()) {
//		System.out.println("Cliente:"+ cli);
//		System.out.println("Endereco:" + cli.getEndereco());
//		}
	System.out.println("Dados Gravados");
	
}catch (Exception ex) {
	ex.printStackTrace();
	
}

}
}
