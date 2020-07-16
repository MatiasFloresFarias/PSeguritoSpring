package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Cliente;

public interface ICliente {
	public int crearCliente(Cliente cliente);
	public List<Cliente> leerCliente();
	public int actualizarCliente(Cliente cliente);
	public int eliminarCliente(int idcliente);
	public Cliente obtenerCliente(int idcliente);

}