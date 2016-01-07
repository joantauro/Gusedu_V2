/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.dao.ProductoService;
import com.gusedu.dao.impl.ProductoServiceImpl;
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
    
    private Producto producto;
    private List<Producto> listaproducto;
    private String query;
    
    
    public ProductoBean() {
        
        producto = new Producto();
        producto.setTipoProducto(new TipoProducto());
        producto.setUnidadMedida(new UnidadMedida());
        producto.setModelo(new Modelo());
        
        productoservice = new ProductoServiceImpl();
        
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
    
}
