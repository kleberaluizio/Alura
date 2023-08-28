package com.kleberaluizio.cepsearchengine;

import com.kleberaluizio.cepsearchengine.model.Address;
import com.kleberaluizio.cepsearchengine.model.AddressJsonCreator;
import com.kleberaluizio.cepsearchengine.model.CepSearchEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CepSearchEngineApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CepSearchEngineApplication.class, args);


		CepSearchEngine cepSearchEngine = new CepSearchEngine();

		try {
			Address address = cepSearchEngine.createAddressFromJson("89422031");
			AddressJsonCreator.create(address);

		} catch (RuntimeException e){
			System.out.println(e.getMessage());
			System.out.println("Finalizando a aplicação!");
		}

	}

}
