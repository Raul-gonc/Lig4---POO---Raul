package UI;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Ranking{
    private static final String ARQUIVO_RANKING = "ranking.csv";

    private Map<String, Integer> ranking;
    
    public Ranking() {
        ranking = carregarRanking();
    }
    
    //usa o metodo put de map, para adicionar
    public void adicionarJogador(String nome) {
        ranking.put(nome, ranking.getOrDefault(nome, 0) + 1);
        salvarRanking();
    }

    //Ordena os jogadores, limita a 10 e retorna como Strings
    public String[] getRanking() {
    	List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(ranking.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        String[] top10 = new String[Math.min(sortedEntries.size(), 10)];
        for (int i = 0; i < top10.length; i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            top10[i] = entry.getKey() + " : " + entry.getValue();
        }

        return top10;
    	/*
        System.out.println("\nRanking de Jogadores:");
        ranking.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar por contagem (maior para menor)
                .limit(10) // Mostrar apenas os top 10
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        */
    }

    //Faz a leitura dos dados no arquivo csv
    private Map<String, Integer> carregarRanking() {
        Map<String, Integer> ranking = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_RANKING))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];
                int vezes = Integer.parseInt(parts[1]);
                ranking.put(nome, vezes);
            }
        } catch (IOException e) {
            // Arquivo ainda não existe ou erro na leitura
	        JOptionPane.showMessageDialog(null, "Arquivo ainda não existe ou erro na leitura", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }

        return ranking;
    }

    //salva os dados atuais no csv
    private void salvarRanking() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_RANKING))) {
            for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            // Erro ao escrever no arquivo
	        JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}