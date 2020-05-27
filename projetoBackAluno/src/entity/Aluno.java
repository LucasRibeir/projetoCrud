package entity;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jcommon.encryption.SimpleMD5;
public class Aluno  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 private Integer id;
	 private String nome;
	 private String email;
	 private String disciplina;
	 private Double nota1;
	 private Double nota2;
	 private String senha;
	 private String situacao;
	 private String foto;
	
	 public Aluno() {
	 }
		public Aluno(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

		public Aluno(Integer id, String nome, String email, String disciplina, 
				Double nota1, Double nota2, String senha,	String foto) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.disciplina = disciplina;
			this.nota1 = nota1;
			this.nota2 = nota2;
			this.senha = senha;
			this.foto = foto;
		}
		
		public Aluno gerarSituacao() {
			this.situacao = (  ((this.nota1+this.nota2)/2) >=7)?"aprovado":"reprovado";
			return this;
		}
		
	    public Boolean isEmail() {
	    	Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	    	Matcher m = p.matcher(this.email);
	    	return m.matches();
	    }
	    public Boolean isSenha() {
	    	Pattern p = Pattern.compile("[a-zA-Z0-9]{6,15}");
	    	Matcher m = p.matcher(this.senha);
	    	return m.matches();
	    }
	    public Aluno afterConstruct() {
	    	if (isEmail() & isSenha()) {
	    		 System.out.println("Senha e Email Validos");
	    	}
	    	else
	    	{
	    		 throw new IllegalArgumentException("Dados Invalidos ...");
	    	}
	    	return this;
	    }
	    
	    public Aluno gerarCriptografia() {
String chave="www.cotiinformatica.com.br@profedsonbelem@gmail.com";
	    	SimpleMD5 md5 = new SimpleMD5(getSenha(), chave);
	    	setSenha(md5.toHexString());
	    	return this;
	    }


		
		@Override
		public String toString() {
			return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", disciplina=" + disciplina + ", nota1="
					+ nota1 + ", nota2=" + nota2 + ", situacao=" + situacao + ", foto=" + foto + "]";
		}
	 
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	 
	 public static void main(String[] args) {
		 try {
		Aluno a = 
new Aluno(null,"lu","lu@gmail.com","java",10., 8.,"123456", "imagem.jpg")
               .afterConstruct()
                .gerarSituacao()
			  	 .gerarCriptografia();
		
		System.out.println(a);
		System.out.println("Senha :" + a.getSenha());
		 
		 }catch(Exception ex) {
			 System.out.println(ex.getMessage());
			 ex.printStackTrace();
		 }
		
	}
	 
	 
	 
	 
	 
	 
	 
}
