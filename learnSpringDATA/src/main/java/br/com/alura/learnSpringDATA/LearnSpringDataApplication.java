package br.com.alura.learnSpringDATA;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.learnSpringDATA.orm.Cargo;
import br.com.alura.learnSpringDATA.service.CargoService;

@SpringBootApplication
public class LearnSpringDataApplication implements CommandLineRunner {

	private CargoService cargoService;
	
	public LearnSpringDataApplication(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Caiu método");
		Scanner sc = new Scanner(System.in);
		cargoService.iniciar(sc);
	}

}
