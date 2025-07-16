package com.mycompany.mavenproject1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.mavenproject1.Modelos.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class interfaceGrafica {

    private static final CadastroImoveis cadastro = new CadastroImoveis();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Scanner scanner = new Scanner(System.in);
    //private static final List<Financiamento> financiamentos = new ArrayList<>();
    private static final String CAMINHO_FINANCIAMENTOS_JSON = "json/financiamentos.json";
    private static final List<Financiamento> financiamentos = carregarFinanciamentos();

    public void iniciar() {

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\nMenu:");
            System.out.println("──────────────────────────────────────────");
            System.out.println("1 - Cadastrar Imóvel");
            System.out.println("2 - Consultar Imóveis");
            System.out.println("3 - Financiamento");
            System.out.println("4 - Sair");
            System.out.println("──────────────────────────────────────────");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarImovel()
                ;
                case 2 -> consultarImoveis(scanner)
                ;
                case 3 -> financiamentoOpcao(scanner)
                ;
                case 4 -> {
                    
                    salvarImoveis(); 
                    salvarFinanciamentos();
                    // salvar dados antes de sair
                    System.out.println("Saindo...");
                    return
                ;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

    }

private void salvarImoveis() {

    try {
        List<Casa> casas = cadastro.listarImoveisPorTipo(Casa.class);
        List<Terreno> terrenos = cadastro.listarImoveisPorTipo(Terreno.class);
        List<Apartamento> apartamentos = cadastro.listarImoveisPorTipo(Apartamento.class);

        mapper.writeValue(new File("json/casa.json"), casas);
        mapper.writeValue(new File("json/terreno.json"), terrenos);
        mapper.writeValue(new File("json/apartamento.json"), apartamentos);
        System.out.println("──────────────────────────────────────────");
        System.out.println("Dados salvos com sucesso!");
        System.out.println("──────────────────────────────────────────");

    } catch (IOException e) {
        System.out.println("Erro ao salvar os arquivos JSON: " + e.getMessage());
    }
}

private void cadastrarImovel() {

    System.out.println("Escolha o tipo de imóvel para cadastrar:");
        System.out.println("──────────────────────────────────────────");
        System.out.println("1 - Casa");
        System.out.println("2 - Terreno");
        System.out.println("3 - Apartamento");
        System.out.println("──────────────────────────────────────────");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
    
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine().replace(",", "."));
    
        switch (opcao) {
            case 1 -> {
                System.out.print("Número de Quartos: ");
                int numQuartos = scanner.nextInt();
                scanner.nextLine();
                cadastro.adicionarImovel(new Casa(endereco, preco, numQuartos));
            }
            case 2 -> {
                System.out.print("Área (m²): ");
                double area = Double.parseDouble(scanner.nextLine().replace(",", "."));
                cadastro.adicionarImovel(new Terreno(endereco, preco, area));
            }
            case 3 -> {
                System.out.print("Andar: ");
                int andar = scanner.nextInt();
                scanner.nextLine();
                cadastro.adicionarImovel(new Apartamento(endereco, preco, andar));
            }
            default -> System.out.println("Tipo inválido!");
        }
        System.out.println("──────────────────────────────────────────");
        System.out.println("Imóvel cadastrado com sucesso!");
        System.out.println("──────────────────────────────────────────");
        salvarImoveis(); // Salva após cadastrar
}

private static List<Financiamento> carregarFinanciamentos() {

    ObjectMapper mapper = new ObjectMapper();
    File arquivo = new File(CAMINHO_FINANCIAMENTOS_JSON);
    if (!arquivo.exists()) {
        return new ArrayList<>();
    }
    try {
        FinanciamentoBancoDoBrasil[] array = mapper.readValue(arquivo, FinanciamentoBancoDoBrasil[].class);
        return new ArrayList<>(Arrays.asList(array));
    } catch (IOException e) {
        System.out.println("Erro ao carregar financiamentos: " + e.getMessage());
        return new ArrayList<>();
    }
}

private void criarFinanciamento(Scanner scanner) {

    System.out.println("Escolha o tipo de imóvel para financiar:");
    System.out.println("──────────────────────────────────────────");
    System.out.println("1 - Casa");
    System.out.println("2 - Terreno");
    System.out.println("3 - Apartamento");
    System.out.println("──────────────────────────────────────────");
    int tipo = scanner.nextInt();
    scanner.nextLine();

    List<Imovel> imoveis = cadastro.getImoveis().stream()
        .filter(i -> (tipo == 1 && i instanceof Casa) ||
                 (tipo == 2 && i instanceof Terreno) ||
                 (tipo == 3 && i instanceof Apartamento))
        .toList();

    if (imoveis.isEmpty()) {
        System.out.println("Nenhum imóvel encontrado.");
        return;
    }

    System.out.println("Escolha o imóvel pelo índice:");
    System.out.println("──────────────────────────────────────────");
    for (int i = 0; i < imoveis.size(); i++) {
        System.out.println((i + 1) + " - " + imoveis.get(i).getEndereco());
    }

    int escolha = scanner.nextInt();
    scanner.nextLine();
    if (escolha < 1 || escolha > imoveis.size()) {
        System.out.println("Índice inválido.");
        System.out.println("──────────────────────────────────────────");
        return;
    }

    Imovel escolhido = imoveis.get(escolha - 1);

    System.out.print("Digite a duração do financiamento em meses: ");
    int meses = scanner.nextInt();
    scanner.nextLine();

    Financiamento novoFinanciamento = new FinanciamentoBancoDoBrasil(escolhido.getPreco(), meses);
    financiamentos.add(novoFinanciamento);
    salvarFinanciamentos(); 
    System.out.println("Financiamento criado com sucesso!");
    System.out.println("──────────────────────────────────────────");

    novoFinanciamento.exibirDetalhesFinanciamento(); 


}

private void financiamentoOpcao(Scanner scanner) {
    System.out.println("──────────────────────────────────────────");
    System.out.println("\n1 - Criar Financiamento");
    System.out.println("2 - Visualizar Financiamentos");
    System.out.println("──────────────────────────────────────────");
    System.out.print("Escolha uma opção: ");
    int escolha = scanner.nextInt();
    scanner.nextLine();
    if (escolha == 1) {
        criarFinanciamento(scanner);
    } else if (escolha == 2) {
        visualizarFinanciamentos();
    } else {
        System.out.println("Opção inválida!");
        System.out.println("──────────────────────────────────────────");
    }
}

private void salvarFinanciamentos() {
    ObjectMapper mapper = new ObjectMapper();
        try {
            File arquivo = new File(CAMINHO_FINANCIAMENTOS_JSON);
            File diretorio = arquivo.getParentFile();
            
            if (!diretorio.exists()){
                    diretorio.mkdirs();
            }
            mapper.writeValue(new File(CAMINHO_FINANCIAMENTOS_JSON), financiamentos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar financiamentos: " + e.getMessage());
        }
}

private void visualizarFinanciamentos() {
    financiamentos.clear();
    financiamentos.addAll(carregarFinanciamentos());
    if (financiamentos.isEmpty()) {
        System.out.println("Nenhum financiamento encontrado.");
        return;
    }
    System.out.println("Lista de Financiamentos:");
    for (int i = 0; i < financiamentos.size(); i++) {
        System.out.println("Financiamento #" + (i + 1));
        financiamentos.get(i).exibirDetalhesFinanciamento();
        System.out.println("──────────────────────────────────────────");
    }
}

private void consultarImoveis(Scanner scanner) {
    System.out.println("Escolha o tipo de imóvel para listar:");
    System.out.println("──────────────────────────────────────────");
    System.out.println("1 - Casas");
    System.out.println("2 - Terrenos");
    System.out.println("3 - Apartamentos");
    System.out.println("──────────────────────────────────────────");
    System.out.print("Opção: ");
        
    int opcao = scanner.nextInt();
    scanner.nextLine();
    
    switch (opcao) {
        
        case 1 -> {
            List<Casa> casas = cadastro.listarImoveisPorTipo(Casa.class);
            System.out.println("\nCasas Encontradas:");
            System.out.println("──────────────────────────────────────────");
                
            if (casas.isEmpty()) {
                System.out.println("Nenhuma casa encontrada.");
            } else {
                for (Casa casa : casas) {
                    System.out.printf("Endereço: %s%n", casa.getEndereco());
                    System.out.printf("Preço: R$ %.2f%n", casa.getPreco());
                        System.out.printf("Quartos: %d%n", casa.getNumQuartos());
                        System.out.println("──────────────────────────────────────────");
                    }
                }
            }
        case 2 -> {                
        List<Terreno> terrenos = cadastro.listarImoveisPorTipo(Terreno.class);
        System.out.println("\nTerrenos Encontrados:");
        System.out.println("──────────────────────────────────────────");

            if (terrenos.isEmpty()) {
                System.out.println("Nenhum terreno encontrado.");
            } else {
                for (Terreno terreno : terrenos) {
                    System.out.printf("Endereço: %s%n", terreno.getEndereco());
                    System.out.printf("Preço: R$ %.2f%n", terreno.getPreco());
                    System.out.printf("Área: %.2f m²%n", terreno.getArea());
                    System.out.println("──────────────────────────────────────────");
                    }
    }
            }
        case 3 -> {
            List<Apartamento> apartamentos = cadastro.listarImoveisPorTipo(Apartamento.class);
            System.out.println("\nApartamentos Encontradas:");
            System.out.println("──────────────────────────────────────────");
                
            if (apartamentos.isEmpty()) {
                System.out.println("Nenhuma apartamento encontrada.");
            } else {
                for (Apartamento apartamento : apartamentos) {
                    System.out.printf("Endereço: %s%n", apartamento.getEndereco());
                    System.out.printf("Preço: R$ %.2f%n", apartamento.getPreco());
                    System.out.printf("Andar: %d%n", apartamento.getAndar());
                    System.out.println("──────────────────────────────────────────");
                    }
                }
            }
            default -> System.out.println("Opção inválida!\n──────────────────────────────────────────");
        }
}


}
