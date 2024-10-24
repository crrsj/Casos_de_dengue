package br.com.dengue.modelo;

import java.time.LocalDate;

import br.com.dengue.dto.RegistroDTO;
import br.com.dengue.enums.Alerta;
import br.com.dengue.enums.Cidade;
import br.com.dengue.enums.Exame;
import br.com.dengue.enums.ZONA;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataHora;
	private String nomePaciente;
	private String cpf;
	private LocalDate dataNasc;
	@Enumerated(EnumType.STRING)
	private Cidade cidade;
	@Enumerated(EnumType.STRING)
	private ZONA zona;
	@Enumerated(EnumType.STRING)
	private Exame exame;
	private Integer casos;
	@Enumerated(EnumType.STRING)
	private Alerta alerta;
	

	public Registro(RegistroDTO registroDTO) {
		this.casos = registroDTO.getCasos();
		this.dataHora = registroDTO.getDataHora();
		this.nomePaciente = registroDTO.getNomePaciente();
		this.cpf = registroDTO.getCpf();
		this.dataNasc = registroDTO.getDataNasc();
		this.cidade = registroDTO.getCidade();
		this.zona = registroDTO.getZona();
		this.exame = registroDTO.getExame();		
		this.alerta = registroDTO.getAlerta();
	}
}
