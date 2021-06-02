package com.telusko.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "authorities")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Authorities {
	
	@EmbeddedId
	private AuthorityPKId authorityPKId;
	
	

}
