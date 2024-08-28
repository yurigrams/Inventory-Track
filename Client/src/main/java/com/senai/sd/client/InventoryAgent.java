package com.senai.sd.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.senai.sd.shared.models.InventoryData;
import com.senai.sd.shared.utils.SystemInfoUtil;

public class InventoryAgent {

    private String serverAddress;
    private int serverPort;

    public InventoryAgent(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void collectAndSendData() {
        try {
            // Coletar informações do sistema
            InventoryData data = SystemInfoUtil.collectSystemInfo();

            // Conectar ao servidor
            Socket socket = new Socket(serverAddress, serverPort);

            // Enviar dados ao servidor
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(data);
            out.flush();

            // Fechar conexão
            out.close();
            socket.close();

            System.out.println("Dados enviados com sucesso ao servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
