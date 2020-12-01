package entity;

import java.time.LocalDate;

public class Cliente {
	private String cpf;
	private String nome;
	private String sobrenome;
	private LocalDate data_Nasc;
	private String email;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cep;
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getData_Nasc() {
		return data_Nasc;
	}

	public void setData_Nasc(LocalDate data_Nasc) {
		this.data_Nasc = data_Nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", data_Nasc=" + data_Nasc
				+ ", email=" + email + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", cep=" + cep + ", login=" + login + "]";
	}

}
