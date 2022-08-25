public class Principal {
    public static void main(String[] args) {
        var processador = new ProcessarBoletos(LeituraRetorno::lerArquivoBradesco);
        processador.processar("bradesco-1.csv");
    }
}
