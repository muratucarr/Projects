package com.infina.monetaBackEnd.entities.concretes;

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
@Table(name = "havaleProvizyon")
public class HavaleProvizyon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int havaleProvizyonId;

 	@ManyToOne(fetch = FetchType.EAGER)
	private Musteri musteri_portfoyNo;

	private String tarih;

	private String islemTipi;

	private double bakiye;

	private double islemTutari;

}