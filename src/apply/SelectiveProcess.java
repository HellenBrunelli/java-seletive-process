package apply;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//CASE 1  - Processo Seletivo

// base salarial
// pretenção salarial
// base > pretendido = Ligar para candidato
// base = pretendido = Ligar com contra proposta
// se nao Aguarde resultado dos demais candidatos

// CASE 2
// somente 5 candidatos sejam selecionados para entrevista
// que tenham pretenção salarial < = ao salário base


// CASE 3
// O RH faz 1 ligação ocm no maximo 3 tentativas para cada candidato
// se atender imprime: Conseguimos contato com [nome cadidato] após [x] tentativas.
// se não atender: Não conseguimos contato com o [nome do candidato]



public class SelectiveProcess {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        // analyzeCandidate(1000.00);
        // analyzeCandidate(2000.00);
        // analyzeCandidate(3000.00);
        selectCandidate();
    }

    static void selectCandidate() {
        // Criar um Map com nomes de candidatos como chaves e salários pretendidos como
        // valores
        Map<String, Double> candidates = new HashMap<>();

        // Adicionar candidatos e salários pretendidos ao Map
        candidates.put("Ana", 5000.00);
        candidates.put("João", 1500.00);
        candidates.put("Maria", 1800.00);
        candidates.put("Pedro", 6000.00);
        candidates.put("Sofia", 2000.00);

        // candidatos já selecionados
        int selectedCandidates = 0;
        double baseSalary = 2000.00;

        // Iterar sobre os candidatos
        // Map = conjunto de pares chave-valor,
        // Nesse Caso as chaves são do tipo String (nome candidatos) e o valor do tipo Double (pretenção salarial)
        // entry é o nome dado à variavel "index" do loop.
        // O operador : é usado para separar a declaração da variável entry do objeto sobre o qual estamos iterando.
        // .entrySet() é um método do Map que retorna um conjunto de objetos. map.Entry
        // entry.getKey() recupera a chave
        // entry.getValue() recupera o valor

        for (Map.Entry<String, Double> entry : candidates.entrySet()) {
            String name = entry.getKey();
            double salaryIntention = entry.getValue();

            // Printando Dados:
            // System.out.println("Nome: " + name);
            // System.out.println("Salário Pretendido: " + salaryIntention);

            // verificar se candidato atende requisitos            
            if (salaryIntention <= baseSalary) {
                System.out.println("Candidato " + name + " foi pré selecionado com salário de " + salaryIntention);
                callingCandidate(name);
                selectedCandidates++;
            }
        }
    }

    static void analyzeCandidate(double salaryIntention) {
        double baseSalary = 2000.00;

        if (baseSalary > salaryIntention)
            System.out.println("Ligar para candidato");
        else if (baseSalary == salaryIntention)
            System.out.println("Ligar com contra proposta");
        else
            System.out.println("Aguardar resultado dos demais candidatos");
    }

    // atender() método auxiliar para simular ligação
    static boolean toMeet() {
        return new Random().nextInt(3)==1;
    }

    static void callingCandidate(String candidate) {
        int numberOfCalls = 1; // numero de ligações
        boolean reconnect = true; // continuar tentando
        boolean answeredCall = false; // atendeu ligação

        do {
            answeredCall = toMeet();
            reconnect = !answeredCall;

            if(reconnect) {
                numberOfCalls++;
            }else {
                System.out.println("Contato realizado com sucesso!!");
            }
            
        // enquanto continuar chamando e o numero de toques for menor que tres...
        } while (reconnect && numberOfCalls < 3);

        if(answeredCall) {
            System.out.println("Conseguimos contato com " + candidate + " na " + numberOfCalls + " tentativa realizada.");
        }else {
            System.out.println("Não conseguimos contato com " + candidate + " na " + numberOfCalls + " tentativa realizada.");
        }
    }
}
