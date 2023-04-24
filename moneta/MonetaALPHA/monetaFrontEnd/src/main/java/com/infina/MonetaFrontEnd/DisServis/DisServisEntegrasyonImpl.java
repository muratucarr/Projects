package com.infina.MonetaFrontEnd.DisServis;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infina.MonetaFrontEnd.model.FonAlimSatimResponse;
import com.infina.MonetaFrontEnd.model.FonFiyatResponse;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;
import com.infina.MonetaFrontEnd.model.HavaleProvizyonResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;
import com.infina.MonetaFrontEnd.model.PersonelResponse;



@ManagedBean(name = DisServisEntegrasyon.SERVICE_NAME)
@ApplicationScoped
public class DisServisEntegrasyonImpl implements DisServisEntegrasyon{

	Client client = ClientBuilder.newClient();
	WebTarget webtarget = client.target("http://localhost:8080");
	WebTarget personelWebTarget = webtarget.path("/api/personel");
	Invocation.Builder invocationBuilder = personelWebTarget.request(MediaType.APPLICATION_JSON);
	
	
	//---------------------PERSONEL----------------------------
	public List <PersonelResponse> getAllPersonel(){
		String REST_URI = "http://localhost:8080/api/personel/getall";
		List<PersonelResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<PersonelResponse>>() {});
		return list;
	}
	//----------------------MUSTERI---------------------------
	@Override
	public List<MusteriResponse> getAllMusteri() {
		String REST_URI = "http://localhost:8080/api/musteri/getAll";
		List<MusteriResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<MusteriResponse>>() {});
		return list;	
	}
	
	@Override
	public MusteriResponse addMusteriList(MusteriResponse Musteri) {
		String REST_URI = "http://localhost:8080/api/musteri/add";
		
		return client
		.target(REST_URI)
		.request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(Musteri,MediaType.APPLICATION_JSON) , MusteriResponse.class);
	}
	
	public MusteriResponse updateMusteri (int portfoyNo , MusteriResponse musteri)
    {
    	String REST_URI = "http://localhost:8080/api/musteri/update";
        return client.target(REST_URI)
                .path(String.valueOf(portfoyNo))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(musteri,MediaType.APPLICATION_JSON) , MusteriResponse.class);
    }
	//---------------------FON TANIMI----------------------
	
	public List <FonTanimiResponse> getAllFon(){
		String REST_URI = "http://localhost:8080/api/fon/getAll";
		List<FonTanimiResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<FonTanimiResponse>>() {});
		return list;
	}
	
	   public FonTanimiResponse addFonTanimi(FonTanimiResponse fonTanimi)
	    {
	    	String REST_URI = "http://localhost:8080/api/fon/add";

	        return client
	        		.target(REST_URI)
	        		.request(MediaType.APPLICATION_JSON)
	        		.post(Entity.entity(fonTanimi,MediaType.APPLICATION_JSON) , FonTanimiResponse.class);
	    }
	
	//----------------------FON FİYAT------------------------
	
    public FonFiyatResponse deleteFonFiyat(int fonFiyatId)
    {
        String REST_URI = "http://localhost:8080/api/FonFiyat/delete";
        return client.target(REST_URI)
                .path(String.valueOf(fonFiyatId))
                .request(MediaType.APPLICATION_JSON)
                .delete(FonFiyatResponse.class);
    }
    
	public List <FonFiyatResponse> getAllFonFiyat(){
        String REST_URI = "http://localhost:8080/api/FonFiyat/getAll";
        List<FonFiyatResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<FonFiyatResponse>>() {});
        return list;
    }
	
    @Override
    public FonFiyatResponse addFonFiyat(FonFiyatResponse fonFiyat)
    {

        String REST_URI = "http://localhost:8080/api/FonFiyat/add";

        return client
        		.target(REST_URI)
        		.request(MediaType.APPLICATION_JSON)
        		.post(Entity.entity(fonFiyat,MediaType.APPLICATION_JSON) , FonFiyatResponse.class);
    }

    
	//---------------------HAVALE-PROVİZYON-------------
	public List <HavaleProvizyonResponse> getAllHavaleProvizyon(){
		String REST_URI = "http://localhost:8080/api/havaleprovizyon/getall";
		List<HavaleProvizyonResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<HavaleProvizyonResponse>>() {});
		return list;
	}
	@Override
	public HavaleProvizyonResponse deleteHavaleProvizyon(int HavaleProvizyonResponseID) {
		String REST_URI = "http://localhost:8080/api/havaleprovizyon/delete";
			return client
				.target(REST_URI)
				.path(String.valueOf(HavaleProvizyonResponseID))
				.request(MediaType.APPLICATION_JSON)
				.delete(HavaleProvizyonResponse.class);
	}
	
	@Override
	public HavaleProvizyonResponse addHavaleProvizyon(HavaleProvizyonResponse HProv) {
		String REST_URI = "http://localhost:8080/api/havaleprovizyon/add";
		return client
			.target(REST_URI)
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(HProv,MediaType.APPLICATION_JSON),HavaleProvizyonResponse.class);
	}
	
	
	//--------------------FON ALIM-SATIM-----------------
	public List <FonAlimSatimResponse> getAllAlimSatim()
	{
		String REST_URI = "http://localhost:8080/api/alimsatim/getall";
		List<FonAlimSatimResponse> list = client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<FonAlimSatimResponse>>() {});
		return list;	
	}
	
    public FonAlimSatimResponse addFonAlimSatim(FonAlimSatimResponse fonAlimSatim)
    {
    	String REST_URI = "http://localhost:8080/api/alimsatim/add";

        return client
        		.target(REST_URI)
        		.request(MediaType.APPLICATION_JSON)
        		.post(Entity.entity(fonAlimSatim,MediaType.APPLICATION_JSON) , FonAlimSatimResponse.class);
    }
    
    public FonAlimSatimResponse updateFonAlimSatim(int alimSatimId , FonAlimSatimResponse fonAlimSatim)
    {
    	String REST_URI = "http://localhost:8080/api/alimsatim/update";
        return client.target(REST_URI)
                .path(String.valueOf(alimSatimId))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(fonAlimSatim,MediaType.APPLICATION_JSON) , FonAlimSatimResponse.class);
    }
    
}