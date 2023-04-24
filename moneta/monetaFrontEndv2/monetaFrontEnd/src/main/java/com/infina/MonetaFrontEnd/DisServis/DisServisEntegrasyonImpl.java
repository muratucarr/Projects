package com.infina.MonetaFrontEnd.DisServis;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infina.MonetaFrontEnd.model.PersonelResponse;



@ManagedBean(name = DisServisEntegrasyon.SERVICE_NAME)
@ApplicationScoped
public class DisServisEntegrasyonImpl implements DisServisEntegrasyon{

	Client client = ClientBuilder.newClient();
	WebTarget webtarget = client.target("http://localhost:8080");
	WebTarget personelWebTarget = webtarget.path("/api/personel");
	Invocation.Builder invocationBuilder = personelWebTarget.request(MediaType.APPLICATION_JSON);
	
	@Override
	public void Deneme() {
		System.out.println("SELAMM");
		String REST_URI = "http://localhost:8080/api/personel/getall";
		System.out.println(client.target(REST_URI).request().get());
	}
	
	public List <PersonelResponse> getAllPersonel(){
		String REST_URI = "http://localhost:8080/api/personel/getall";
		List<PersonelResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<PersonelResponse>>() {});
		return list;
	}
	
}
