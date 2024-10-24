package br.com.dengue.dto;

import br.com.dengue.enums.Alerta;
import br.com.dengue.enums.Cidade;
import br.com.dengue.enums.Exame;
import br.com.dengue.enums.ZONA;
import br.com.dengue.modelo.Registro;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuscarRegistrosDTO {
	
    private Long id;
	private String dataHora ;
	private String nomePaciente;	
	private Cidade cidade;	
	private ZONA zona;	
	private Exame exame;
    private Integer casos;
	private Alerta alerta;
	
	public BuscarRegistrosDTO(Registro registro) {
		this.id = registro.getId();
		this.dataHora = registro.getDataHora();
		this.nomePaciente = registro.getNomePaciente();
		this.cidade = registro.getCidade();
		this.zona = registro.getZona();
		this.exame = registro.getExame();	
		this.casos = registro.getCasos();
		this.alerta = registro.getAlerta();
	}
	
}

