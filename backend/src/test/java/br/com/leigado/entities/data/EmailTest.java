package br.com.leigado.entities.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.leigado.entities.data.exception.DataException;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEndercosInvalidos() {
		assertThrows(DataException.class, 
				() -> new Email(null));
		
		assertThrows(DataException.class,
				() -> new Email(""));
		
		assertThrows(DataException.class, 
				() -> new Email("email"));
		
		assertThrows(DataException.class, 
				() -> new Email("email.com"));
		
		assertThrows(DataException.class, 
				() -> new Email("email.com.br"));
		
		assertThrows(DataException.class, 
				() -> new Email("email@"));
		
		assertThrows(DataException.class, 
				() -> new Email("email@com"));
		
		assertThrows(DataException.class, 
				() -> new Email("email@.com"));
	}

}
