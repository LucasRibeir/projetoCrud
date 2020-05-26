package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Cliente;
import persistence.ClienteDao;

@Controller
public class ClienteController {
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public ModelAndView iniciar() {
		
		
		ModelAndView mv = new ModelAndView("sistema");
		try {
			
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.findAll();
		mv.addObject("lista", lista);
		
	}catch(Exception ex) {
		
	}

	mv.addObject("msg", "Bem vindo ao Sistema NineTails-Cadastro de clientes");
	return mv;
}

	
	@RequestMapping(value= "/gravar.html", method =RequestMethod.POST)
	public ModelAndView gravar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			ClienteDao dao = new ClienteDao();
			dao.create(cliente, cliente.getEndereco());
			List<Cliente> lista = dao.findAll();
			mv.addObject("lista", lista);
	mv.addObject("msg","DAdos gravados Cliente e Endereco");
		}catch(Exception ex) {
			mv.addObject("msg","Erro"+ ex.getMessage());
		}finally {
			return mv;
		}
	}
	
			@RequestMapping(value= "/deletar.html", method =RequestMethod.GET)
			public ModelAndView deletar(Cliente cliente) {
				ModelAndView mv = new ModelAndView("sistema");
				try {
					ClienteDao dao = new ClienteDao();
					dao.delete(cliente, cliente.getEndereco());
					List<Cliente> lista = dao.findAll();
					mv.addObject("lista", lista);
			mv.addObject("msg1","excluido com sucesso");
				}catch(Exception ex) {
					mv.addObject("msg","Erro"+ ex.getMessage());
		}finally {
			return mv;
		}
	}
	
//		@RequestMapping(value="/listar", method=RequestMethod.GET)
//		public ModelAndView listar() {
//			ModelAndView mv = new ModelAndView ("listar");
//		ClienteDao cli = new ClienteDao();
//		return mv;
//		}
//
//		}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listar");
		ClienteDao ud = new ClienteDao();
		
		try {
			List<Cliente> u = (List<Cliente>) ud.findAll();
			mv.addObject("msg", u );
		} catch(Exception ex) {
			
		}
		return mv;

		}
	}
