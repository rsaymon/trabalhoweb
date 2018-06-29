package com.trabalhoweb.trabalhoweb.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue
	(strategy= GenerationType.AUTO)
	private long id_administrador;
	
	private String nome;
	private String login;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getId_administrador() {
		return id_administrador;
	}
	public void setId_administrador(long id_administrador) {
		this.id_administrador = id_administrador;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}