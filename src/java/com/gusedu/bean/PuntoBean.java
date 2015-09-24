// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   PuntoBean.java

package com.gusedu.bean;

import com.gusedu.dao.ParService;
import com.gusedu.dao.PuntoService;
import com.gusedu.dao.impl.ParServiceImpl;
import com.gusedu.dao.impl.PuntoServiceImpl;
import com.gusedu.model.Par;
import com.gusedu.model.Punto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

// Referenced classes of package com.gusedu.bean:
//            classPar, classPunto
@ManagedBean
@SessionScoped
public class PuntoBean {

            ParService parService;
            PuntoService puntoService;
            private Punto punto;
            private List<Par>  parcito;
            private List<classPunto> lista;
            private List<classPar> listapar;
            private int filaPunto;
            private int filaPar;

            public PuntoBean() {
/*  46*/        parService = new ParServiceImpl();
/*  47*/        puntoService = new PuntoServiceImpl();
/*  48*/        punto = new Punto();
/*  50*/        filaPar = 0;
            }

            @PostConstruct
            public void post() {
/*  57*/        listapar = new ArrayList();
/*  58*/       List<Par> pares = new ArrayList<>();
/*  59*/        pares = parService.getAllParesOrderGoiz();
/*  60*/        System.out.println(pares.size());
/*  63*/        double p = pares.size();
/*  64*/        int leng = pares.size() / 4;
/*  65*/        double t = p / 4D;
/*  66*/        if ((double)leng < t) {
/*  68*/            leng++;
                }
/*  70*/        filaPar = leng;
/*  71*/        int f = leng * 4 - (int)p;
/*  72*/        for (int j = 0; j < leng; j++) {
/*  74*/            if (j >= leng - f) {
/*  76*/                pares.add(new Par());
                    }
/*  79*/            listapar.add(new classPar((Par)pares.get(j), (Par)pares.get(j + leng * 1), (Par)pares.get(leng * 2 + j), (Par)pares.get(j + leng * 3)));
                }

/*  81*/        listarpuntos();
            }

            public void buscar(int p1) {
/*  86*/        punto.setPunCodigo(Integer.valueOf(p1));
/*  87*/        parcito = parService.paresByPunto(punto);
/*  88*/        System.out.println((new StringBuilder()).append("Lista : ").append(parcito.size()).toString());
/*  89*/        FacesContext fc = FacesContext.getCurrentInstance();
/*  90*/        fc.getExternalContext().getSessionMap().put("punto", punto);
            }

            public void listarpuntos() {
/*  95*/        lista = new ArrayList();
/*  96*/        List<Punto>  ptos = new ArrayList();
/*  98*/        ptos = puntoService.getAllOrdenAlfabeticoAsc();
/* 100*/        double p = ptos.size();
/* 101*/        int len = ptos.size() / 4;
/* 102*/        double t = p / 4D;
/* 103*/        if ((double)len < t) {
/* 105*/            len++;
                }
/* 107*/        filaPunto = len;
/* 108*/        int f = len * 4 - (int)p;
/* 110*/        for (int i = 0; i < len; i++) {
/* 112*/            if (i >= len - f) {
/* 114*/                ptos.add(new Punto());
                    }
/* 116*/            lista.add(new classPunto((Punto)ptos.get(i), (Punto)ptos.get(i + len * 1), (Punto)ptos.get(i + len * 2), (Punto)ptos.get(i + len * 3)));
                }

            }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public List<Par> getParcito() {
        return parcito;
    }

    public void setParcito(List<Par> parcito) {
        this.parcito = parcito;
    }

    public List<classPunto> getLista() {
        return lista;
    }

    public void setLista(List<classPunto> lista) {
        this.lista = lista;
    }

    public List<classPar> getListapar() {
        return listapar;
    }

    public void setListapar(List<classPar> listapar) {
        this.listapar = listapar;
    }

    public int getFilaPunto() {
        return filaPunto;
    }

    public void setFilaPunto(int filaPunto) {
        this.filaPunto = filaPunto;
    }

    public int getFilaPar() {
        return filaPar;
    }

    public void setFilaPar(int filaPar) {
        this.filaPar = filaPar;
    }

      
}
