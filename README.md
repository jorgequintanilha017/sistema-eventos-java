# Sistema de Cadastro e Notificação de Eventos (Java - Console)

Este projeto é um sistema em Java desenvolvido para cadastrar e notificar eventos locais com base na cidade do usuário. Ele foi criado com base em um exercício proposto com foco em **programação orientada a objetos**.

## 📋 Funcionalidades

- Cadastro de usuários com nome, e-mail e cidade
- Cadastro de eventos com os seguintes atributos:
  - Nome
  - Endereço
  - Categoria (ex: festas, shows, eventos esportivos etc.)
  - Horário (usando `LocalDateTime`)
  - Descrição
- Participação e cancelamento em eventos
- Listagem dos eventos em ordem cronológica
- Verificação de eventos passados, atuais e futuros
- Armazenamento dos eventos em arquivo de texto (`events.data`)
- Carregamento automático dos eventos ao iniciar o sistema

## 🧱 Estrutura

O projeto contém as seguintes classes:
- `Usuario`: representa um usuário
- `Evento`: representa um evento
- `EventoManager`: gerencia a lista de eventos e participações
- `Main`: ponto de entrada para execução do programa

## 📁 Arquivos

- `events.data`: arquivo de texto onde os eventos são salvos
- `.gitignore`: para ignorar arquivos de build/IDE
- `README.md`: este arquivo com a descrição do projeto
- `DiagramaSistemaEventos.png`: imagem com o diagrama de classes (opcional)

## ▶️ Como executar

1. Importe o projeto na sua IDE (Eclipse, IntelliJ, NetBeans etc.)
2. Compile e execute a classe `Main.java`
3. Use o menu no console para interagir com o sistema

## 💡 Observações

- O projeto utiliza a API `java.time.LocalDateTime` para gerenciar os horários dos eventos
- A estrutura do código pode ser facilmente adaptada para um sistema com interface gráfica ou web no futuro

## 🧩 Diagrama de Classes

Caso deseje visualizar o diagrama das classes, utilize o arquivo `DiagramaSistemaEventos.png` incluído no projeto.

---

Desenvolvido para fins educacionais com foco em prática de programação orientada a objetos.
