package maxi.coderhouse.primeraentregafacturacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeraentregafacturacionApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory daoFactory;
		public static void main(String[] args) {
			SpringApplication.run(PrimeraentregafacturacionApplication.class, args);
			System.out.println("Aplicacion de Maxi levantada con exito");
		}
		@Override
		public void run (String... args) throws Exception {
			try {
				// cargo cliente
				Cliente cliente = new Cliente("Maximiliano", "Andrade", 38626847);
				
				// cargo domicilio
				Domicilio domicilio = new Domicilio("Avenida siempre viva", 7, 420, "Trevelin", "Chubut");
				
				// Asigno cliente a domicilio
				domicilio.setCliente(cliente);

				// Asigno domicilio a cliente
				List <Domicilio> domicilios = new ArrayList<Domicilio>();
				domicilios.add(domicilio);

				cliente.setDomicilio(domicilios);

				// Se crea el cliente
				daoFactory.create(cliente);

				// Busco el cliente guardado
				Cliente clienteGuardado = daoFactory.getCliente(cliente);
				imprimirCliente(clienteGuardado, "Cliente Guardado");

				// Modifico el cliente guardado
				modificarCliente(clienteGuardado);

				// Busco el cliente modificado
				Cliente clienteModificado = daoFactory.getCliente(clienteGuardado);
				imprimirCliente(clienteModificado, "Cliente Modificado");

			} catch (Exception e) {
				// Manejo de exepciones
				System.err.println("Ocurrio un error mediante la ejecución" + e.getMessage());
			}
		}

		private void modificarCliente (Cliente clienteGuardado) {
			clienteGuardado.setNombre("Cristian");
			clienteGuardado.setApellido("Lavoz");
			daoFactory.update(clienteGuardado);
		}
	
	private void imprimirCliente(Cliente clienteGuardado, String s) {
		System.out.println("---------------------------");
		System.out.println(s + clienteGuardado.toString());
	}
	}

