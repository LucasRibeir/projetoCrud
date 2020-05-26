package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



//@Table  Lembra q te falei sobre isso no audio???
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente; //hahahhaah ai o erro
	@Column(length=50)
	
	private String nome;
	@Column(length=50, unique=true)
	
	private String email;
	@Column(length=50,unique=true)
	private String telefone;
	
	@OneToOne(mappedBy="cliente", fetch = FetchType.EAGER)
	private Endereco endereco;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(Integer idCliente, String nome,  String email, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		
		this.email = email;
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome +  ", email=" + email
				+ ", telefone=" + telefone + "]";
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	
	
}
