create database BDNine;

use BDNine;

create table cliente(idCliente int primary key auto_increment,
nome varchar(50), endereco varchar(50), email varchar(50), telefone int(50)
)


	@OneToOne
	@JoinColumn(name= "id_cliente", referencedColumnName= "id")
	private Cliente cliente;