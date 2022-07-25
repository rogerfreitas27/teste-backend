package com.attornatus.backend.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.attornatus.backend.repository.EnderecoRepository;


@SpringBootTest
public class EnderecoPersistenceTest {

	 @InjectMocks
	 private EnderecoPersistence enderecoPersistence;
	 
	 @Mock
	 private EnderecoRepository  enderecoRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {		
		 MockitoAnnotations.openMocks(this);
		 
	}
}
