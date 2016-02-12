package com.gusedu.dao;

import java.util.List;

import com.gusedu.model.Sintoma;
import com.gusedu.model.SintomaPar;
import com.gusedu.model.SintomaTerapia;

public interface SintomaService {

    //Sintoma:
	public List<Sintoma> getAll();
 	
	public boolean saveSintoma(Sintoma sintoma);
	
	public boolean updateSintoma(Sintoma sintoma);
	
	public boolean deleteSintoma(Sintoma sintoma);
	
	public Sintoma getById(Integer id);
	
    //Sintoma Par:
        public List<SintomaPar> getAllPar();
        
	public boolean saveSintomaPar(SintomaPar sintomaPar);

	public boolean deleteSintomaPar(SintomaPar sintomaPar); 			
        
        public boolean updateSintomaPar(SintomaPar sintomaPar); 
	
	public SintomaPar getByParameters(Integer sintomapar) ;     
        
        
	public Sintoma getByNombre(String nombre);
	
	//SintomaTerapia
	
	public boolean saveSintomaTerapia(SintomaTerapia sintomaTerapia);
	
	public Sintoma lastSintoma();
	
}
