import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("Lendo arquivo " + nomeArquivo);

        try (var reader = Files.newBufferedReader(Paths.get(nomeArquivo))) {
            String linha;
            var listaBoleto = new ArrayList<Boleto>();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            while ((linha = reader.readLine()) != null) {
                var vetor = linha.split(";");
                var boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodigoBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], dateFormatter));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], dateFormatter).atTime(0, 0, 0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setMulta(Double.parseDouble(vetor[7]));

                listaBoleto.add(boleto);
            }

            return listaBoleto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
