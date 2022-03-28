package br.com.alura.learnSpringDATA.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.learnSpringDATA.orm.Cargo;
import br.com.alura.learnSpringDATA.repository.CargoRepository;

@Service
public class CargoService {

	private CargoRepository repository;
	private boolean prosseguir = true;
	
	public CargoService(CargoRepository resitory) {
		this.repository=resitory;
	}
	
	public void iniciar(Scanner sc) {

		while (prosseguir) {
			
			int opSelecionada = 0;
			
			try {
				opSelecionada = menu(sc);
			} catch (Exception e) {
				e.printStackTrace();
			}

			switch (opSelecionada) {
			
				case 1:
					salvar(sc);
					break;
	
				case 2:
					atualizar(sc);
					break;
					
				case 3:
					deletar(sc);
					break;
				
				case 4:
					selecionarTodos();
					break;
					
				case 5:
					selecionarPorID(sc);
					break;	
					
				case 6:
					System.out.println("Programa finalizado");
					prosseguir = false;
					break;
	
				default:
					System.out.println("Programa finalizado");
					prosseguir = false;
					break;
			}
		}

	}
	
	public int menu(Scanner sc) {
		StringBuilder str = new StringBuilder();
		str.append("1 - Cadastrar CARGO \n");
		str.append("2 - Atualizar CARGO \n");
		str.append("3 - Deletar CARGO \n");
		str.append("4 - Selecionar Todos CARGOS \n");
		str.append("5 - Selecionar por ID \n");
		str.append("6 - SAIR \n");
		
		System.out.println(str.toString());

		int op = sc.nextInt();
		
		return op;
	}
	
	public void salvar(Scanner sc) {
		System.out.println("Informe a descricao do cargo");
		String descricao = sc.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		
		this.repository.save(cargo);
		System.out.println("Cadastrado com sucesso");
	}
	
	public void atualizar(Scanner sc) {
		System.out.println("Informe o id do produto que deseja alterar");
		Long id = sc.nextLong();
		
		System.out.println("Informe a nova descricao do produto");
		String descricao = sc.next();
		
		Cargo cargoAtualizar = new Cargo();
		cargoAtualizar.setId(id);
		cargoAtualizar.setDescricao(descricao);
		
		this.repository.save(cargoAtualizar);
		System.out.println("Atualizado com sucesso");
	}
	
	public void selecionarTodos() {
		Iterable<Cargo> cargos = this.repository.findAll();

		cargos.forEach(cargo -> System.out.println(cargo)); 
	}
	
	public void selecionarPorID(Scanner sc) {
		System.out.println("Informe o id do produto :");
		Long idProduto = sc.nextLong();
		
		Optional<Cargo> cargoSelecionado = this.repository.findById(idProduto);

		System.out.println(cargoSelecionado); 
	}
	
	public void deletar(Scanner sc) {
		System.out.println("Informe o id do cargo que deseja excluir");
		Long id = sc.nextLong();
		
		this.repository.deleteById(id);
		System.out.println("removido com sucesso !");
	}
	
}
