package com.gusedu.dao;

import com.gusedu.estadistica.EUltimaVisitaxCliente;
import java.util.Date;
import java.util.List;

import com.gusedu.model.Cliente;
import com.gusedu.model.Terapia;
import com.gusedu.model.Visita;

public interface VisitaService {

	public boolean saveVisita(Visita visita);

	public boolean updateVisita(Visita visita);

	public boolean deleteVisita(Visita visita);

	public List<EUltimaVisitaxCliente> getVisitasCliente(int clicodigo);
	
	public Visita getVisitaById(Integer idVisita);
	
	public Visita getLastVisitaCliente(Cliente cliente);
	
	public Visita buscarVisita(Cliente cliente);
	
	public Visita getLastVisitaCliente2(Cliente cliente);
	
	public double costodeVisita(Date fec_inicial,Date fec_final);
	
	public List<Visita> getVisitabyFechas(String username,Date fec_inicial,Date fec_final);

	public List<Visita> getVisitas();
        
        public List<Visita> getVisitasByEmpresa();
        
        public boolean SPsaveVisitaxTerapia(Visita vis,Terapia ter); 
        
        public Visita visitaDelDia(Cliente cliente);
        
        public int visitaProgramada(Date fecha,Cliente cliente);
        
        public boolean SPdeleteVisita(int cod_visita);
}
