package com.uca.capas.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@Size(message = "El campo nombre no debe tener más de 500 caracteres", max=500)
	@NotEmpty(message = "El campo titulo no puede ser vacío")
	private String s_titulo;
	
	@Column(name="s_autor")
	@Size(message = "El campo nombre no debe tener más de 50 caracteres", max=150)
	@NotEmpty(message = "El campo autor de categoría no puede ser vacío")
	private String s_autor;
	
	/*@Column(name="c_categoria")
	private Integer c_categoria;*/
	
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	@CreationTimestamp	
	private LocalDate f_ingreso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Column(name = "b_estado")
	//@NotEmpty(message = "El campo fecha de categoría no puede ser vacío")
	private Boolean b_estado;
	
	@Column(name = "s_isbn")
	@Size(message = "El campo nombre no debe tener más de 10 caracteres", max=10)
	@NotEmpty(message = "El campo ISBN de categoría no puede ser vacío")
	private String s_isbn;

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	/*public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}*/

	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	public LocalDate getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(LocalDate f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	public String getEstadoDelegate() {
		if(this.b_estado == null) {
			return "";
		}else {
			return b_estado == true ?"Activo":"Inactivo";
		}
	}
	
}
