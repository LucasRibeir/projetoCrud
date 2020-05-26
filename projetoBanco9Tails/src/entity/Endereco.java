package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

	public static final long serialVersionUID=9L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEndereco;
	@Column(length=50)
	
	private String logradouro;
	@Column(length=50)
	
	private String bairro;
	@Column(length=50)
	
	private String cidade;
	@Column(length=50)
	
	private String estado;
	@Column(length=50)
	
	private String cep;
	

	@OneToOne
	@JoinColumn(name="id_cliente", referencedColumnName= "idCliente")

	private Cliente cliente;
	

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer idEndereco, String logradouro, String bairro, String cidade, String estado, String cep) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
	