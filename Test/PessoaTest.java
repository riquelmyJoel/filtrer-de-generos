import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PessoaTest {

    @Test
    public void deveFiltrarSomenteMulheres() {

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Ana", 20, "Feminino"));
        pessoas.add(new Pessoa("João", 25, "Masculino"));
        pessoas.add(new Pessoa("Maria", 18, "Feminino"));

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());

        assertFalse(mulheres.isEmpty());
        assertEquals(2, mulheres.size());

        assertTrue(
                mulheres.stream()
                        .allMatch(p -> p.getGenero().equalsIgnoreCase("Feminino"))
        );
    }
}