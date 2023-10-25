import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // PREGUNTA 1 !!!!!!!!!!!!!!!!!!!!!!!!!
        List<String> listaCadenas = crearCadenasAleatorias(10);
        List<String> cadenasAleatorias = listaCadenas;
        System.out.println("Cadenas aleatorias: " + cadenasAleatorias);

        contarYMostrarResultados(cadenasAleatorias, "Cadenas vacías", s -> s.isEmpty());
        contarYMostrarResultados(cadenasAleatorias, "Cadenas con longitud > 5", s -> s.length() > 5);
        contarYMostrarResultados(cadenasAleatorias, "Cadenas que comienzan con 's'", s -> s.startsWith("s"));

        List<String> listaSinCadenasVacias = filtrar(cadenasAleatorias, s -> !s.isEmpty());
        System.out.println("Lista sin cadenas vacías: " + listaSinCadenasVacias);

        List<String> listaCadenasLongitudMayor5 = filtrar(cadenasAleatorias, s -> s.length() > 5);
        System.out.println("Cadenas con longitud > 5: " + listaCadenasLongitudMayor5);

        String palabrasEnMayusculas = cadenasAleatorias.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("Palabras en mayúsculas: " + palabrasEnMayusculas);
    }

    public static List<String> crearCadenasAleatorias(int cantidad) {
        Random random = new Random();
        List<String> cadenas = random.ints(cantidad, 97, 123)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.toList());
        return cadenas;
    }

    public static List<String> filtrar(List<String> cadenas, Predicate<String> condition) {
        return cadenas.stream().filter(condition).collect(Collectors.toList());
    }

    public static void contarYMostrarResultados(List<String> cadenas, String mensaje, Predicate<String> condition) {
        long count = cadenas.stream().filter(condition).count();
        System.out.println(mensaje + ": " + count);
    }
}


    /*PREGUNTA 2 !!!!!!!!!!!!!!!!!!!!!!!!
    import java.util.IntSummaryStatistics;
    import java.util.List;
    import java.util.Arrays;

    public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntSummaryStatistics stats = numeros.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();

        System.out.println("Recuento: " + stats.getCount());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
    }
}

