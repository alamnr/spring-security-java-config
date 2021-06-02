package com.telusko.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class JdbcUser {
	@Id
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	Set<Authorities> authoritySet;

}
