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
@Table(name = "musteri")
public class Musteri {
	@Id
	private int portfoyNo;

	private String ad;

	private String soyad;

	private String tcNo;

	private String yerlesimBelgesi;

	private double bakiye;

}