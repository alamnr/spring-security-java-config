package com.telusko.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AuthorityPKId implements Serializable {
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "authority", nullable = false)
	private String authority;

}
