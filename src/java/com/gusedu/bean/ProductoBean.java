/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.dao.ClienteService;
import com.gusedu.dao.ProductoService;
import com.gusedu.dao.impl.ClienteServiceImpl;
import com.gusedu.dao.impl.ProductoServiceImpl;
import com.gusedu.entidad.ClientePersona;
import com.gusedu.entidad.detalle_factura;
import com.gusedu.model.Modelo;
import com.gusedu.model.Producto;
import com.gusedu.model.TipoProducto;
import com.gusedu.model.UnidadMedida;
import com.gusedu.util.StaticUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NV55C
 */
@ManagedBean
@SessionScoped
public class ProductoBean {

    
    ProductoService productoservice;
    ClienteService clienteService ;
    
    private Producto producto;
    private List<Producto> listaproducto;
    private String query;
    
    private String dni;
    private String nom;
    private String ap_p;
    private String ap_m;
    private List<ClientePersona> lista_cliper; 
    
    private double costoParcial;
    private int cantidadProducto;
    private int cod_cli;
    public List<detalle_factura> lista_detfact;
    
    public ProductoBean() {
        
        producto = new Producto();
        producto.setTipoProducto(new TipoProducto());
        producto.setUnidadMedida(new UnidadMedida());
        producto.setModelo(new Modelo());
        
        productoservice = new ProductoServiceImpl();
        clienteService = new ClienteServiceImpl();
        
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    
    
    public List<Producto> getListaproducto() {
        listaproducto = productoservice.getAllProductos();
        return listaproducto;
    }

    public void cancelar()
    {
        producto = new Producto();
        producto.setTipoProducto(new TipoProducto());
        producto.setUnidadMedida(new UnidadMedida());
        producto.setModelo(new Modelo());
    }
    public void ADDPRODUCTO()
    {
        TipoProducto tp = new TipoProducto();
        tp.setTprCodigo(1);
        Modelo m = new Modelo();
        m.setModCodigo(1);
        UnidadMedida um = new UnidadMedida();
        um.setUmeCodigo(1);
        producto.setTipoProducto(tp);
        producto.setModelo(m);
        producto.setUnidadMedida(um);
        if(productoservice.saveProducto(producto))
        {
            StaticUtil.correctMesage("Exito", "Se ha registrado correctamente los datos del producto");
        }else
        {
            StaticUtil.errorMessage("Error", "No se pudo registrar los datos del producto");
        }
                
    }
    
    public void get_Producto(Producto p)
    {
        producto=p;
    }
    
    public void deleteProducto()
    {
         if(productoservice.deleteProducto(producto))
        {
            StaticUtil.correctMesage("Exito", "Se ha eliminado correctamente el producto");
        }else
        {
            StaticUtil.errorMessage("Error", "No se pudo eliminar el producto");
        }
    }
    
    public void updateProducto()
    {
         if(productoservice.updateProducto(producto))
        {
            StaticUtil.correctMesage("Exito", "Se ha actualizo correctamente el producto");
        }else
        {
            StaticUtil.errorMessage("Error", "No se pudo actualiza los datos del producto");
        }
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    public void filtrarBusqueda() {
		listaproducto = productoservice.getAllProductos();
		List<Producto> filtrados = new ArrayList<>();
		for (Producto u : listaproducto) {
	 
				if (u.getProDescripcionC().toLowerCase().contains(query.toLowerCase())  ) {
						filtrados.add(u);
					}
		 
		}
		listaproducto = filtrados;
	}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAp_p() {
        return ap_p;
    }

    public void setAp_p(String ap_p) {
        this.ap_p = ap_p;
    }

    public String getAp_m() {
        return ap_m;
    }

    public void setAp_m(String ap_m) {
        this.ap_m = ap_m;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

             public void calculaCostoParcial() {
                 double cant=cantidadProducto;
/* 460*/        try {
/* 460*/            if (cant > 0.0D) {
/* 461*/                costoParcial = Double.valueOf(cant * producto.getProCostoUnitario().doubleValue());
                    } else {
/* 463*/                costoParcial = Double.valueOf(0.0D);
                    }
                }
/* 465*/        catch (NumberFormatException ex) {
/* 466*/            System.out.print("Error, no se ha insertado un n\372mero");
                }
            }

    public double getCostoParcial() {
        return costoParcial;
    }

    public void setCostoParcial(double costoParcial) {
        this.costoParcial = costoParcial;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    
    
    public List<ClientePersona> getLista_cliper() {
        lista_cliper=clienteService.getALLlistaClientePersona();
        return lista_cliper;
    }

    public void setLista_cliper(List<ClientePersona> lista_cliper) {
        this.lista_cliper = lista_cliper;
    }

    public List<detalle_factura> getLista_detfact() {
        return lista_detfact;
    }

    public void setLista_detfact(List<detalle_factura> lista_detfact) {
        this.lista_detfact = lista_detfact;
    }
    
    
    
    public void BUSQUEDAD()
    {
 
        lista_cliper = clienteService.listaClientePersona(nom, ap_p, ap_m, dni);
        System.out.println("Lista : "+lista_cliper.size());
        System.out.println("NOMBRE : "+nom);
        System.out.println("AP_P : "+ap_p);
        System.out.println("AP_M : "+ap_m);
        System.out.println("DNI : "+dni);
    }
    
    public void preProducto(int idProducto)
    {
        producto = productoservice.getProductoById(idProducto);
    }
    
    public void ADD_PRODUCTO()
    {
        productoservice.SP_CrearCabeceraProducto(cod_cli, producto.getProCodigo(), producto.getProDescripcionM(), cantidadProducto, costoParcial);
    }
    
    public void MOSTRAR()
    {
        
        lista_detfact= productoservice.SP_ListarProductosF(cod_cli);
        
    }
    
    public void ELIMINAR(int fact)
    {
        System.out.println("Entro a Eliminar"+fact);
        productoservice.SP_EliminarProductoFactura(fact);
        lista_detfact= productoservice.SP_ListarProductosF(cod_cli);
    }
}
