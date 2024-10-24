package br.com.dengue.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dengue.dto.BuscarRegistrosDTO;
import br.com.dengue.dto.RegistroDTO;
import br.com.dengue.enums.Alerta;
import br.com.dengue.enums.Cidade;
import br.com.dengue.enums.Exame;
import br.com.dengue.modelo.Registro;
import br.com.dengue.repositorio.RegistroRepositorio;

@Service
public class RegistroServico {

	@Autowired
	private RegistroRepositorio registroRepositorio;
	
	public Registro registrarCaso(RegistroDTO registroDTO) {		
		var registro = new Registro(registroDTO);
		registro.setExame(Exame.POSITIVO);	
		registro.setAlerta(Alerta.VERDE);		
		if(registro.getCasos() > 5 && registro.getCasos() <= 10) {
			registro.setAlerta(Alerta.AMARELO);
		}
		
		if(registro.getCasos() > 10) {
			registro.setAlerta(Alerta.VERMELHO);
		}
		registro.setCidade(Cidade.ARACAJU);	
		return registroRepositorio.save(registro);
	 }
	
	  public List<BuscarRegistrosDTO> buscarTodosOsRegistros(){
		  var buscar = registroRepositorio.findAll().stream().map(BuscarRegistrosDTO::new).toList();
		  return buscar;
	  }
	  
	  
	 
}
