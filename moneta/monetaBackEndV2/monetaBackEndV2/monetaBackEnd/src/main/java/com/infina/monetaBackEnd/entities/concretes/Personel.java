package com.infina.monetaBackEnd.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personel")
public class Personel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int personelId;

	private String ad;

	private String soyad;

	private String kullaniciAdi;

	private String sifre;

}