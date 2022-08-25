public class Principal {
    public static void main(String[] args) {
        LeituraRetorno leituraRetorno = new LeituraRetornoBradesco();
        ProcessarBoletos processador = new ProcessarBoletos(leituraRetorno);

        processador.processar("bradesco-1.csv");
    }
}
