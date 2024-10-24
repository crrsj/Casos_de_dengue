package br.com.dengue.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.dengue.enums.Alerta;
import br.com.dengue.enums.Cidade;
import br.com.dengue.enums.Exame;
import br.com.dengue.enums.ZONA;
import br.com.dengue.modelo.Registro;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RegistroDTO {
	

	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nomePaciente;
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;
	private Cidade cidade;	
	private ZONA zona;	
	private Exame exame;
	private Integer casos;
	
	private Alerta alerta;
	
	public RegistroDTO(Registro criar) {	
		this.casos = criar.getCasos();
		this.dataHora = criar.getDataHora();
		this.nomePaciente = criar.getNomePaciente();
		this.cpf = criar.getCpf();
		this.dataNasc = criar.getDataNasc();
		this.cidade = criar.getCidade();
		this.zona = criar.getZona();
		this.exame = criar.getExame();		
		this.alerta = criar.getAlerta();
	}
}
