package br.com.leigado.entities.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.leigado.entities.data.exception.DataException;

class NameTest {

	private static final String[] LIXOS = {
			null,
	        "",
	        "Maria",
	        "Maria-Silva",
	        "Marcos E",
	        "E Marcos",
	        "Maria  Silva",
	        "Maria Silva ",
	        " Maria Silva ",
	        "Maria silva",
	        "maria Silva",
	        "MARIA SILVA",
	        "MAria Silva",
	        "Maria SIlva",
	        "Jean-Baptiste",
	        "Jeanne d' Arc",
	        "Joseph Louis Gay-lussac",
	        "Pierre-simon Laplace",
	        "Maria daSilva",
	        "Maria~Silva",
	        "Maria Silva~",
	        "~Maria Silva",
	        "Maria~ Silva",
	        "Maria ~Silva",
	        "Maria da da Silva",
	        "Maria da e Silva",
	        "Maria de le Silva",
	        "William Henry Gates iii",
	        "Martin Luther King, Jr.",
	        "Martin Luther King JR",
	        "Martin Luther Jr. King",
	        "Martin Luther King Jr. III",
	        "Maria G. Silva",
	        "Maria G Silva",
	        "Maria É Silva",
	        "Maria wi Silva",
	        "Samuel 'Etoo",
	        "Samuel Etoo'",
	        "Samuel Eto''o"
	    };

	@Test
	void naoDeveriaCriarNomesInvalidos() {
		for (String string : LIXOS) {
			assertThrows(DataException.class, 
					() -> new Name(string));
		}
	}

}
