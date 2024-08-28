package com.senai.sd.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class CommandExecutor {

    private String serverAddress;
    private int serverPort;

    public CommandExecutor(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void listenForCommands() {
        try {
            // Conectar ao servidor
            Socket socket = new Socket(serverAddress, serverPort);

            // Escutar por comandos do servidor
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String command;

            while ((command = (String) in.readObject()) != null) {
                System.out.println("Comando recebido: " + command);
                executeCommand(command);
            }

            // Fechar conexão
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void executeCommand(String command) {
        // Aqui você pode implementar a lógica para executar o comando recebido
        System.out.println("Executando comando: " + command);
        // Exemplo: você poderia usar Runtime.getRuntime().exec(command) para executar um comando no sistema
    }
}
