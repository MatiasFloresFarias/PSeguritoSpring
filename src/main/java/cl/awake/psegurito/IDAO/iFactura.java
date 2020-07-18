package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Factura;


public interface iFactura {
	public boolean crearFactura(Factura fac);
	public List<Factura> leerFactura();
	public boolean actualizarFactura(Factura fac);
	public boolean eliminarFactura(Factura fac);
	Factura obtenerFactura(int id_factura);


}
