package com.attornatus.backend.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.anyLong;

import com.attornatus.backend.model.Endereco;
import com.attornatus.backend.model.Pessoa;
import com.attornatus.backend.repository.PessoaRepository;
import com.attornatus.backend.validation.ValidationEndereco;


@SpringBootTest
public class PessoaPersistenceTeste {
	
	public static final long ID = 2L;
	public static final String NOME = "Jose Leoncio";
	public static final LocalDate NASCIMENTO = LocalDate.now();
	
	 @InjectMocks
	private PessoaPersistence pessoaPersistence;
	 
	@Mock
	private  ValidationEndereco validationEndereco;
	
	 @Mock
	private  EnderecoPersistence enderecoPersistence;
	 
	 @Mock
	private PessoaRepository pessoaRepository;
	 
	
	private Pessoa pessoa;	
	private Endereco endereco;	 
	private Optional<Pessoa> pessoaOptional;
	private Optional<Pessoa> tipoPessoa;
	
	@BeforeEach
	void setUp() throws Exception {		
		 MockitoAnnotations.openMocks(this);
		 iniciaPessoa();
	}
	
	@Test  //testar optional de endereco
	void quandoBuscarPessoaPorIdRetornarInstaciaPessoa() {
		Mockito.when(pessoaRepository.findById(anyLong())).thenReturn(pessoaOptional);
		Optional<Pessoa> resposta = pessoaPersistence.findById(ID);
		Assertions.assertEquals(tipoPessoa.getClass(), resposta.getClass());
	}

	
	
	
	
	
	
	
	
	
	
	
	private void iniciaPessoa() {
		Pessoa p = new Pessoa(ID,NOME, NASCIMENTO);	
		Endereco endereco = new Endereco(1L,"Rua São Sebastiao", "23064010", 47,"Rio de Janeiro",true);
				
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		p.setEnderecos(enderecos);
		pessoaOptional = Optional.of(new Pessoa(ID,NOME, NASCIMENTO, enderecos));
		tipoPessoa = Optional.of(new Pessoa(5L,"Joao", LocalDate.now(), enderecos));
	}	
}
