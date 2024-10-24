package br.com.dengue.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dengue.dto.BuscarRegistrosDTO;
import br.com.dengue.dto.RegistroDTO;
import br.com.dengue.servico.RegistroServico;

@RestController
@RequestMapping("registro")
public class RegistroControle {

	@Autowired
	private RegistroServico  registroServico;
	
	@PostMapping
	public ResponseEntity<RegistroDTO>criarRegistro(@RequestBody RegistroDTO registroDTO){
		var criar = registroServico.registrarCaso(registroDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(criar.getId()).toUri();
		return ResponseEntity.created(uri).body(new RegistroDTO(criar));
	}
	
	
	@GetMapping
	public ResponseEntity<List<BuscarRegistrosDTO>>buscarPorZona(){
		var buscar = registroServico.buscarTodosOsRegistros();
		return ResponseEntity.ok(buscar);
		
	}
}
