package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Factura;


public interface IFactura {
	public int crearFactura(Factura fac);
	public List<Factura> leerFactura();
	public int actualizarFactura(Factura fac);
	public int eliminarFactura(int id_factura);
	Factura obtenerFactura(int id_factura);


}
