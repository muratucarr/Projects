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
@Table(name = "alimSatim")
public class AlimSatim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alimSatimId;

	@ManyToOne(fetch = FetchType.EAGER)
	private Musteri musteri_portfoyNo;
	@ManyToOne(fetch = FetchType.EAGER)
	private Fon fon_fonKodu; 
	private Date islemTarihi;
	private String islemTipi;
	private double stok;
	private double miktar;
	private double fiyat;
	private double tutar;
	private String silindiMi;



}