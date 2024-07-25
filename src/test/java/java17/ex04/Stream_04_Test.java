package java17.ex04;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - Stream
 */
public class Stream_04_Test {

    @Test
    public void test_of() throws Exception {
        // Construire un stream
        Stream<String> stream = Stream.of("Alexandra", "Cyril", "Johnny", "Marion", "Sophie");

        // Convertir le stream en tableau
        String[] resultArray = stream.toArray(String[]::new);

        // Affichage du tableau résultat pour débogage
        System.out.println("Stream.of : " + java.util.Arrays.toString(resultArray));

        // Assertions
        assertThat(resultArray, arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }


    @Test
    public void test_builder() throws Exception {
        // TODO compléter pour rendre le test passant
        // TODO utiliser la méthode "add"
        Stream<String> streamBuilder = Stream.<String>builder()
                .add("Alexandra")
                .add("Cyril")
                .add("Johnny")
                .add("Marion")
                .add("Sophie")
                .build();

        // Convertir le stream en tableau
        String[] resultArray = streamBuilder.toArray(String[]::new);

        System.out.println("Stream.builder : " + java.util.Arrays.toString(resultArray));

        assertThat(resultArray, arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }



    @Test
    public void test_concat() throws Exception {
        Stream<String> s1 = Stream.of("Alexandra", "Cyril");
        Stream<String> s2 = Stream.of("Johnny", "Marion", "Sophie");

        // Concaténer les deux streams
        Stream<String> concatenatedStream = Stream.concat(s1, s2);

        // Convertir le stream concaténé en tableau pour les assertions
        String[] resultArray = concatenatedStream.toArray(String[]::new);

        System.out.println("Stream.concat : " + java.util.Arrays.toString(resultArray));

        assertThat(resultArray, arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_iterate() throws Exception {
        Stream<Integer> result1 = Stream.iterate(1, n -> n)
                .limit(5);

        Stream<Integer> result2 = Stream.iterate(1, n -> n + 1)
                .limit(5);

        Integer[] result1Array = result1.toArray(Integer[]::new);
        Integer[] result2Array = result2.toArray(Integer[]::new);

        System.out.println("Stream.iterate (constant) : " + java.util.Arrays.toString(result1Array));
        System.out.println("Stream.iterate (incremental) : " + java.util.Arrays.toString(result2Array));

        assertThat(result1Array, arrayContaining(1, 1, 1, 1, 1));
        assertThat(result2Array, arrayContaining(1, 2, 3, 4, 5));
    }

}
