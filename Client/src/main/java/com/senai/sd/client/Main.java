package com.senai.sd.client;

public class Main {
    public static void main(String[] args) {
        InventoryAgent agent = new InventoryAgent();
        agent.collectAndSendData();

        // Exemplo de execução de comandos recebidos
        CommandExecutor executor = new CommandExecutor();
        executor.listenForCommands();
    }
}
