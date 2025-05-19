import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventoManager eventoManager = new EventoManager();
        Usuario usuario = null;

        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        usuario = new Usuario(nome, email, cidade);

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Participar de evento");
            System.out.println("4. Cancelar participação");
            System.out.println("5. Meus eventos");
            System.out.println("6. Verificar eventos em andamento");
            System.out.println("7. Listar eventos passados");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Categoria (Show, Festa, Esporte): ");
                    String categoria = scanner.nextLine();
                    System.out.print("Data e hora (AAAA-MM-DDTHH:MM): ");
                    LocalDateTime horario = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    Evento novoEvento = new Evento(nomeEvento, endereco, categoria, horario, descricao);
                    eventoManager.cadastrarEvento(novoEvento);
                    System.out.println("Evento cadastrado!");
                    break;

                case 2:
                    eventoManager.listarEventosOrdenados();
                    break;

                case 3:
                    eventoManager.listarEventosOrdenados();
                    System.out.print("Digite o nome do evento para participar: ");
                    String eventoParticipar = scanner.nextLine();
                    for (Evento e : eventoManager.getEventos()) {
                        if (e.getNome().equalsIgnoreCase(eventoParticipar)) {
                            eventoManager.participarEvento(usuario, e);
                            System.out.println("Participação confirmada!");
                            break;
                        }
                    }
                    break;

                case 4:
                    eventoManager.listarEventosUsuario(usuario);
                    System.out.print("Digite o nome do evento para cancelar: ");
                    String eventoCancelar = scanner.nextLine();
                    for (Evento e : eventoManager.getEventos()) {
                        if (e.getNome().equalsIgnoreCase(eventoCancelar)) {
                            eventoManager.cancelarParticipacao(usuario, e);
                            System.out.println("Participação cancelada!");
                            break;
                        }
                    }
                    break;

                case 5:
                    eventoManager.listarEventosUsuario(usuario);
                    break;

                case 6:
                    eventoManager.verificarEventosAtuais();
                    break;

                case 7:
                    eventoManager.listarEventosPassados();
                    break;
            }

        } while (opcao != 0);

        System.out.println("Programa finalizado.");
    }
}