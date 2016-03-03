/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.dao.SintomaService;
import com.gusedu.dao.TerapiaService;
import com.gusedu.dao.TerapiaSintomaService;
import com.gusedu.dao.impl.SintomaServiceImpl;
import com.gusedu.dao.impl.TerapiaServiceImpl;
import com.gusedu.dao.impl.TerapiaSintomaServiceImpl;
import com.gusedu.entidad.ESintomaTerapia;
import com.gusedu.model.Cliente;
import com.gusedu.model.Sintoma;
import com.gusedu.model.SintomaVisita;
import com.gusedu.model.Terapia;
import com.gusedu.model.TerapiaSintoma;
import com.gusedu.model.TipoTerapia;
import com.gusedu.model.Visita;
import com.gusedu.util.StaticUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class TerapiaSintomaBean {

    private Sintoma sintoma;
    private TerapiaSintoma datos;
    public List<TerapiaSintoma> listar;
    public TerapiaService terapiaservice;
    TerapiaSintomaService terapiasintomaService;
    private TerapiaSintoma terapiasintoma;
    SintomaService sintomaService;
    private String queryS;
    private Terapia terapia;
    private boolean disable;
    private String comentario;
    
    private List rowNames;
    private List colNames;
    private ArrayList data3D;
    private List listaFechas;
    private List listaSintomas;
    private List listaESintomaTerapia;
            
    
    private List<TerapiaSintoma> listaterapiasintoma;
    
    public String toShort(Date fecha)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }
    
    public TerapiaSintomaBean() 
    {
        terapiaservice = new TerapiaServiceImpl();
        sintomaService = new SintomaServiceImpl();
        terapiasintomaService = new TerapiaSintomaServiceImpl();
        terapiasintoma = new TerapiaSintoma();
        sintoma = new Sintoma();
        queryS = "";
        terapia = new Terapia();
        terapia.setTipoTerapia(new TipoTerapia());
        terapia.setVisita(new Visita());
        inicializar();
        rowNames = new ArrayList();
        colNames = new ArrayList();
        data3D = new ArrayList();
//        disable = true;
    }

    
    @PostConstruct
    public void init()
    {
        listarSintoma();
        disable = true;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    public void inicializar()
    {
        datos = new TerapiaSintoma();
        datos.setTerapia(new Terapia());
        datos.setSintoma(new Sintoma());
        setDisable(true);
    }

    public TerapiaSintoma getDatos() {
        return datos;
    }

    public void setDatos(TerapiaSintoma datos) {
        this.datos = datos;
    }

    public List<TerapiaSintoma> getListar() {
        return listar;
    }

    public void setListar(List<TerapiaSintoma> listar) {
        this.listar = listar;
    }

    public void listarSintoma()
    {
         listar = terapiasintomaService.getAllSintoma();
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
    
    public void AGREGAR()
    {
        System.out.println("Ingresando terapia sintoma...");
        System.out.println("Terapia: "+ datos.getTerapia().getTerCodigo());
        System.out.println("Sintoma: "+ datos.getSintoma().getSinCodigo());
        terapiasintomaService.saveTerapiaSintoma(datos);      
        datos = new TerapiaSintoma();
        datos.setTerapia(new Terapia());
        datos.setSintoma(new Sintoma());
        listarSintoma();
    }
    
    public void ACTUALIZAR()
    {
        System.out.println("Actualizando terapia sintoma...");
        terapiasintomaService.updateTerapiaSintoma(datos);
        datos = new TerapiaSintoma();
        datos.setTerapia(new Terapia());
        datos.setSintoma(new Sintoma());
        listarSintoma();
        llenarLISTITA(terapia.getTerCodigo());
        SintomaTerapiaBean stBean = new SintomaTerapiaBean();
        stBean.llenamatriz();
    }
    
    public void ELIMINAR()
    {
        System.out.println("Eliminando terapia sintoma...");
        terapiasintomaService.deleteTerapiaSintoma(datos);
        datos = new TerapiaSintoma();
        datos.setTerapia(new Terapia());
        datos.setSintoma(new Sintoma());
        listarSintoma();
        llenarLISTITA(terapia.getTerCodigo());
    }
    
    public void BUSCARXID(int tersintoma)
    {
        llenarLISTITA(tersintoma);
        datos = terapiasintomaService.getByParameters(tersintoma);
        System.out.println("Terapia: " + datos.getTerapia().getTerDescripcion() + "\n" +
                           "Sintoma:" + datos.getSintoma().getSinDescripcion());
    }
    
    public void BuscarEliminar(int codigo)
    {
        BUSCARXID(codigo);
        ELIMINAR();
        SintomaTerapiaBean stBean = new SintomaTerapiaBean();
        stBean.llenamatriz();
    }
    
    public void GUARDARDATOS() 
    {
        if (terapiasintomaService.saveTerapiaSintoma(terapiasintoma)) 
        {
            registrarSintoma();
            StaticUtil.correctMesage("\311xito", "Se han guardado los datos m\351dicos");
            StaticUtil.keepMessages();
        } 
        else {
        StaticUtil.errorMessage("Error", "Hubo un error al guardar los datos");
        }
     }
    
    public void registrarSintoma() 
    {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        List s = (List)fc.getExternalContext().getSessionMap().get("listaterapiasintoma");
//        if (s != null) 
//        {
//            for (int i = 0; i < s.size(); i++) 
//            {
//                TerapiaSintoma tersin = new TerapiaSintoma();
//                tersin.setTerapia(terapia);
//                tersin.setSintoma((Sintoma)s.get(i));;
//                terapiasintomaService.saveTerapiaSintoma(tersin);
//            }
//        }
        FacesContext fc = FacesContext.getCurrentInstance();
        Terapia ter = (Terapia)fc.getExternalContext().getSessionMap().get("ultimaterapia");
        //System.out.println((new StringBuilder()).append("Terapia : ").append(ter.getTerCodigo()).append(" Síntoma : ").append(sintoma.getSinCodigo()).toString());
        System.out.println("TERAPIA : " + ter.getTerCodigo());
      
        System.out.println("SINTOMA : " + sintoma.getSinCodigo());
        TerapiaSintoma tersin = new TerapiaSintoma();
        tersin.setSintoma(sintoma);
        tersin.setTerapia(ter);
        terapiasintomaService.saveTerapiaSintoma(tersin);
    }

    public List<TerapiaSintoma> getListaterapiasintoma() {
        return listaterapiasintoma;
    }

    public void setListaterapiasintoma(List<TerapiaSintoma> listaterapiasintoma) {
        this.listaterapiasintoma = listaterapiasintoma;
    }
   
    public void addSintoma() 
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        System.out.println((new StringBuilder()).append("QueryS : ").append(queryS).toString());
        for (int i = 0; i < queryS.length(); i++) 
        {
            String c = (new StringBuilder()).append(queryS.charAt(i)).append("").toString();
            if (!c.equals(" "));
        }
        if (sintoma == null) 
        {
            if (queryS != "") 
            {
                sintoma = new Sintoma();
                sintoma.setSinDescripcion(queryS);
                sintomaService.saveSintoma(sintoma);
            } 
            else {
                StaticUtil.errorMessage("Error", "El campo síntoma está vacío");
                return;
            }
        }
        listarsintomas();
        for (Iterator iterator = listaterapiasintoma.iterator(); iterator.hasNext();) 
        {
            TerapiaSintoma s = (TerapiaSintoma)iterator.next();
            if (s.getSintoma().getSinCodigo() == sintoma.getSinCodigo()) 
            {
                StaticUtil.errorMessage("Error", "El síntoma ya ha sido agregado");
                sintoma = new Sintoma();
                return;
            }
        }
        Terapia ter = (Terapia)fc.getExternalContext().getSessionMap().get("ultimaterapia");
        //System.out.println((new StringBuilder()).append("Terapia : ").append(ter.getTerCodigo()).append(" Síntoma : ").append(sintoma.getSinCodigo()).toString());
        System.out.println("TERAPIA : " + ter.getTerCodigo());
      
        System.out.println("SINTOMA : " + sintoma.getSinCodigo());
        
        TerapiaSintoma tersin = new TerapiaSintoma();
        tersin.setSintoma(sintoma);
        tersin.setTerapia(ter);
        tersin.setTxsComentario(comentario);
        tersin.setTxsActivo(true);
        terapiasintomaService.saveTerapiaSintoma(tersin);
        System.out.println("Ingresando terapia sintoma...");
        System.out.println("Terapia: "+ datos.getTerapia().getTerCodigo());
        System.out.println("Sintoma: "+ datos.getSintoma().getSinCodigo());
        System.out.println("Comentario: " + datos.getTxsComentario());
        System.out.println("Activo" + datos.getTxsActivo().toString());
//        datos = new TerapiaSintoma();
//        datos.setTerapia(new Terapia());
//        datos.setSintoma(new Sintoma());
        queryS = "";
        sintoma = new Sintoma();
        listaterapiasintoma = terapiasintomaService.getAllTerapiaSintoma(ter);
        listarSintoma();
        SintomaTerapiaBean stBean = new SintomaTerapiaBean();
        stBean.llenamatriz();
    }
    
    public void llenarLISTITA(int ter)
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        System.out.println("TERAPIA : " + ter);       
        fc.getExternalContext().getSessionMap().put("ultimaterapia", terapiaservice.terapiaById(ter));
        listaterapiasintoma = terapiasintomaService.getAllTerapiaSintoma(terapiaservice.terapiaById(ter));
        if(ter==0)
        {
            disable = true;
        }else
        {
            disable = false;
        }
        System.out.println(ter);
    }
    
    public List autoCompletarSintoma(String query)
    {
        List<Sintoma> allSintomas = sintomaService.getAll();
        List<Sintoma> sinFiltrados = new ArrayList();
        System.out.println((new StringBuilder()).append("Lista : ").append(allSintomas.size()).toString());
        System.out.println((new StringBuilder()).append("QUERY : ").append(query).toString());
        for (int i = 0; i < allSintomas.size(); i++) 
        {
            Sintoma sintoma = (Sintoma)allSintomas.get(i);
            if (sintoma.getSinDescripcion().toLowerCase().startsWith(query)) 
            {
                sinFiltrados.add(sintoma);
            }
        }
        if (sinFiltrados.size() == 0) 
        {
            queryS = query;
            System.out.println((new StringBuilder()).append("Síntoma : ").append(queryS).toString());
        }
        return sinFiltrados;
    }

    public void listarsintomas() 
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        Terapia ter = (Terapia)fc.getExternalContext().getSessionMap().get("ultimaterapia");
        listaterapiasintoma = terapiasintomaService.getAllTerapiaSintoma(ter);
    }   

    public String getQueryS() {
        return queryS;
    }

    public void setQueryS(String queryS) {
        this.queryS = queryS;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }  

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void verifyRequiredFields() 
    {
        if (terapiasintoma!= null) {
            disable = false;
        } else {
            disable = true;
        }
    }     

    public void Update(TerapiaSintoma ts) 
    {
        terapiasintomaService.updateTerapiaSintoma(ts);
        SintomaTerapiaBean stBean = new SintomaTerapiaBean();
        stBean.llenamatriz();
    }

    public List getRowNames() {
        return rowNames;
    }

    public void setRowNames(List rowNames) {
        this.rowNames = rowNames;
    }

    public List getColNames() {
        return colNames;
    }

    public void setColNames(List colNames) {
        this.colNames = colNames;
    }

    public ArrayList getData3D() {
        return data3D;
    }

    public void setData3D(ArrayList data3D) {
        this.data3D = data3D;
    }

    public List getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List listaFechas) {
        this.listaFechas = listaFechas;
    }

    public List getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List listaSintomas) {
        this.listaSintomas = listaSintomas;
    }

    public List getListaESintomaTerapia() {
        return listaESintomaTerapia;
    }

    public void setListaESintomaTerapia(List listaESintomaTerapia) {
        this.listaESintomaTerapia = listaESintomaTerapia;
    }
    
    public void llenamatriz() {
/*  96*/        data3D = new ArrayList();
/*  97*/        rowNames = new ArrayList();
/*  98*/        colNames = new ArrayList();
/*  99*/        FacesContext fc = FacesContext.getCurrentInstance();
/* 100*/        Cliente cli = (Cliente)fc.getExternalContext().getSessionMap().get("cliente");
/* 103*/        listaFechas = new ArrayList();
/* 104*/        listaSintomas = new ArrayList();
/* 106*/        List all = new ArrayList();
/* 107*/        all = sintomaService.SP_MatrizSintomaxTerapia(cli.getCliCodigo());
/* 108*/        System.out.println((new StringBuilder()).append("Codigo de Cliente : ").append(cli.getCliCodigo()).append("\nAll : ").append(all.size()).toString());
/* 109*/        for (int i = 0; i < all.size(); i++) {
/* 111*/            if (!listaFechas.contains(((ESintomaTerapia)all.get(i)).getFecha())) {
/* 113*/                listaFechas.add(((ESintomaTerapia)all.get(i)).getFecha());
                    }
                }

/* 116*/        for (int j = 0; j < all.size(); j++) {
/* 118*/            if (!listaSintomas.contains(((ESintomaTerapia)all.get(j)).getSin_descripcion())) {
/* 120*/                listaSintomas.add(((ESintomaTerapia)all.get(j)).getSin_descripcion());
                    }
                }

/* 124*/        for (int j = 0; j < listaSintomas.size(); j++) {
/* 125*/            rowNames.add(listaSintomas.get(j));
                }

/* 128*/        System.out.println(listaFechas.size());
/* 129*/        for (int i = 0; i < listaFechas.size(); i++) {
/* 131*/            colNames.add(listaFechas.get(i));
                }

/* 134*/        for (int i = 0; i < rowNames.size(); i++) {
/* 135*/            data3D.add(new ArrayList());
/* 136*/            for (int j = 0; j < colNames.size(); j++) {
/* 137*/                ((ArrayList)data3D.get(i)).add(new ArrayList());
                    }

                }

/* 142*/        for (int i = 0; i < listaSintomas.size(); i++) {
/* 144*/            for (int j = 0; j < listaFechas.size(); j++) {
/* 146*/                for (int a = 0; a < all.size(); a++) {
/* 148*/                    if (!Objects.equals(listaFechas.get(j), ((ESintomaTerapia)all.get(a)).getFecha()) || !Objects.equals(listaSintomas.get(i), ((ESintomaTerapia)all.get(a)).getSin_descripcion())) {
/* 153*/                        continue;
                            }
/* 153*/                    if (((ESintomaTerapia)all.get(a)).isEstado()) {
/* 155*/                        ((ArrayList)((ArrayList)data3D.get(i)).get(j)).add("Si");
                            } else {
/* 158*/                        ((ArrayList)((ArrayList)data3D.get(i)).get(j)).add("No");
                            }
                        }

                    }

                }

            }
}
