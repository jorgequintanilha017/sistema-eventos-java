import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class EventoManager {
    private List<Evento> eventos = new ArrayList<>();
    private Map<Usuario, List<Evento>> participacoes = new HashMap<>();
    private final String FILE_NAME = "events.data";

    public EventoManager() {
        carregarEventos();
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        salvarEventos();
    }

    public void listarEventosOrdenados() {
        eventos.sort(Comparator.comparing(Evento::getHorario));
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public void participarEvento(Usuario usuario, Evento evento) {
        participacoes.putIfAbsent(usuario, new ArrayList<>());
        participacoes.get(usuario).add(evento);
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        if (participacoes.containsKey(usuario)) {
            participacoes.get(usuario).remove(evento);
        }
    }

    public void listarEventosUsuario(Usuario usuario) {
        List<Evento> eventosUsuario = participacoes.getOrDefault(usuario, new ArrayList<>());
        if (eventosUsuario.isEmpty()) {
            System.out.println("Nenhum evento confirmado.");
        } else {
            eventosUsuario.forEach(System.out::println);
        }
    }

    public void verificarEventosAtuais() {
        LocalDateTime agora = LocalDateTime.now();
        for (Evento e : eventos) {
            if (e.getHorario().isBefore(agora) && e.getHorario().plusHours(2).isAfter(agora)) {
                System.out.println("Evento em andamento: " + e.getNome());
            }
        }
    }

    public void listarEventosPassados() {
        LocalDateTime agora = LocalDateTime.now();
        for (Evento e : eventos) {
            if (e.getHorario().isBefore(agora)) {
                System.out.println("Evento já ocorreu: " + e);
            }
        }
    }

    private void salvarEventos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Evento e : eventos) {
                writer.write(e.getNome() + ";" + e.getEndereco() + ";" + e.getCategoria() + ";" + e.getHorario() + ";" + e.getDescricao());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }

    private void carregarEventos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Evento evento = new Evento(
                        dados[0], dados[1], dados[2],
                        LocalDateTime.parse(dados[3]), dados[4]
                );
                eventos.add(evento);
            }
        } catch (IOException e) {
            System.out.println("Arquivo de eventos não encontrado, criando novo...");
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}