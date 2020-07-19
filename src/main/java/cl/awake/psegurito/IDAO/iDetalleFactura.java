package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.DetalleFactura;


public interface iDetalleFactura {

    public int crearDetalleFactura(DetalleFactura detallefac);
    public List<DetalleFactura> leerDetalleFactura(int id_factura);
    public int actualizarDetalleFactura(DetalleFactura detallefac);
    public int eliminarDetalleFactura(int id_detallefactura);
    DetalleFactura obtenerDetalleFactura(int id_detallefactura);

}
