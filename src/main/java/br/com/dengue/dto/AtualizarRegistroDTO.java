package br.com.dengue.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.dengue.enums.ZONA;
import br.com.dengue.modelo.Registro;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarRegistroDTO {
	
	private Long id;
	private String nomePaciente;	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;
	private ZONA zona;	
	private Integer casos;
	
	public AtualizarRegistroDTO(Registro atualize) {
		this.id = atualize.getId();
		this.nomePaciente = atualize.getNomePaciente();
		this.dataNasc = atualize.getDataNasc();
		this.zona = atualize.getZona();
		this.casos = atualize.getCasos();
	}
	
}
