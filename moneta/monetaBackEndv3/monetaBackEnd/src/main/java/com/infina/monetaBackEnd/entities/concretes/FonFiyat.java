package com.infina.monetaBackEnd.entities.concretes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fonFiyat")
public class FonFiyat {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int fonFiyatId;

	private Date tarih;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fon fon_FonKodu;

	private double fiyat;

}