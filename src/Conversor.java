public class Conversor {
    public static double converterDolarParaPesoArgentino(double quantidade, double taxaPesoArgentino) {
        return quantidade * taxaPesoArgentino;
    }

    public static double converterPesoArgentinoParaDolar(double quantidade, double taxaPesoArgentino) {
        return quantidade / taxaPesoArgentino;
    }

    public static double converterDolarParaReal(double quantidade, double taxaReal) {
        return quantidade * taxaReal;
    }

    public static double converterRealParaDolar(double quantidade, double taxaReal) {
        return quantidade / taxaReal;
    }

    public static double converterDolarParaPesoColombiano(double quantidade, double taxaPesoColombiano) {
        return quantidade * taxaPesoColombiano;
    }

    public static double converterPesoColombianoParaDolar(double quantidade, double taxaPesoColombiano) {
        return quantidade / taxaPesoColombiano;
    }
}
