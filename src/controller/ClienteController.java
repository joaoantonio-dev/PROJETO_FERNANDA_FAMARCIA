package controller;

import model.Cliente;
import service.ClienteService;
import java.util.List;

public class ClienteController {
    private ClienteService service;

    public ClienteController() {
        this.service = new ClienteService();
    }

    public void adicionarCliente(String nome, String cpf, String telefone, String email) {
        try {
            Cliente novo = new Cliente(null, nome, cpf, telefone, email);
            service.cadastrarCliente(novo);
            System.out.println("Cliente cadastrado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void exibirClientes() {
        List<Cliente> lista = service.listarClientes();
        System.out.println("--- Lista de Clientes ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : lista) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome() + " | CPF: " + c.getCpf());
        }
    }
}
