package br.com.dengue.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dengue.dto.AtualizarRegistroDTO;
import br.com.dengue.dto.BuscarRegistrosDTO;
import br.com.dengue.dto.RegistroDTO;
import br.com.dengue.enums.Alerta;
import br.com.dengue.enums.Cidade;
import br.com.dengue.enums.Exame;
import br.com.dengue.modelo.Registro;
import br.com.dengue.repositorio.RegistroRepositorio;
import jakarta.transaction.Transactional;

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
	  
	  @Transactional
	  public Registro atualizarRegistro(AtualizarRegistroDTO registroDTO) {
		  var atualizar = registroRepositorio.getReferenceById(registroDTO.getId());		  
		  atualizar.atualize(registroDTO);
		  return registroRepositorio.save(atualizar);    
		  
		 
	  }
	  
	  
	  public Registro buscarPorId(Long id){
		  Optional<Registro> buscaPorId = registroRepositorio.findById(id);
		  return buscaPorId.orElseThrow();
	  }
	 
	  public void excluir(Long id) {
		  registroRepositorio.deleteById(id);
	  }
}
