package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.DetalleFactura;


public interface iDetalleFactura {

    public boolean crearDetalleFactura(DetalleFactura detallefac);
    public List<DetalleFactura> leerDetalleFactura(int id_factura);
    public boolean actualizarDetalleFactura(DetalleFactura detallefac);
    public boolean eliminarDetalleFactura(DetalleFactura detallefac);
    DetalleFactura obtenerDetalleFactura(int id_detallefactura);

}
