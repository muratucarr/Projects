package com.infina.monetaBackEnd.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fon")
public class Fon {

	private String fonAdi;

	@Id
	private String fonKodu;

	private String isinKodu;

}