/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.estadistica.Estadistica;
import com.gusedu.estadistica.EstadisticaImpl;
import com.gusedu.estadistica.EstadisticaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author NV55C
 */
@ManagedBean
@SessionScoped
public class EstadisticaBean implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * Creates a new instance of EstadisticaBean
     */
    
    private List<Estadistica> lista;
    private BarChartModel barra;
    
    EstadisticaService estadisticaservice; 
    
    public EstadisticaBean() {
        estadisticaservice= new EstadisticaImpl();
    }
    
    
     @PostConstruct
     public void init() {
		 
	     createAnimatedModels();     
	 }
    	private void createAnimatedModels() {
        
         
        setBarra(initBarModel());
        getBarra().setTitle("Bar Charts");
        getBarra().setAnimate(true);
        getBarra().setLegendPosition("ne");
    }
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries est = new ChartSeries();
        est.setLabel("Citas");
        lista=new ArrayList<>();
        lista.addAll(estadisticaservice.visitaAnual());
        System.out.println("Salida : "+lista.size());
        for(int i=0;i<lista.size();i++)
        {
        	est.set(lista.get(i).getFECHA(), lista.get(i).getCANTIDAD());
        	//est.set(x, y);
        }
        model.addSeries(est);
         
        return model;
    }
    public List<Estadistica> getLista() {
 
		return lista;
	}

	public void setLista(List<Estadistica> lista) {
		this.lista = lista;
	}

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }
    
    
}
