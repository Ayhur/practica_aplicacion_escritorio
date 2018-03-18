package ddos;

import modelo.Cliente;

public interface ClientesDAO {
	
	void registrarCliente(Cliente c);
	Boolean validarClienteExiste(String dni);

}
