package com.davr7.springcrud.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.davr7.springcrud.common.DateAudit;
import com.davr7.springcrud.dtos.StudentDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends DateAudit {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullname;
	private String email;
	private String phone;
	private String password;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Article> writtenArticles = new LinkedList<>();
	
	public Student() {
	}
	
	public Student(StudentDTO st) {
		this.fullname = st.fullname();
		this.email = st.email();
		this.phone = st.phone();
		this.password = st.password();
	}
	
	public Student(Long id, String fullname, String email, String phone, String password) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Article> getWrittenArticles() {
		return writtenArticles;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
}
