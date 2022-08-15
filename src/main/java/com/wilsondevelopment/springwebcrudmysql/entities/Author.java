package com.wilsondevelopment.springwebcrudmysql.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="book_author", 
		joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id") ,
		inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id")
	)
	@JsonManagedReference
	private List<Book> books;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author() {
		
	}
	
	public Author(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}
	
	
}
