package com.infina.monetaBackEnd.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "alimSatim")
public class AlimSatim {

	@Id
	private int alimSatimId;

	@ManyToOne(fetch = FetchType.EAGER)
	private Musteri musteri;
	@ManyToOne(fetch = FetchType.EAGER)
	private Fon fon;
	private String islemTarihi;
	private String islemTipi;
	private double stok;
	private double bakiye;
	private double miktar;
	private double fiyat;

	private double tutar;



}