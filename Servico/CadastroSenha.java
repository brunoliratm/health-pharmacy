package Servico;
import java.util.Scanner;

import TratamentoDeErroELimpeza.tratamento;

public class CadastroSenha {
    Scanner sc = new Scanner(System.in);
    public String cadastroSenha(){
        boolean s1 = false;
        String senha = null;
        while ( s1==false) {
            System.out.print("\nSenha: ");
            senha = sc.nextLine();
            System.out.print("\nConfirme Sua Senha: ");
            String ConfirmarSenhaFuncionario = sc.nextLine();
            if (senha.equals(ConfirmarSenhaFuncionario)) {
                s1=true;
                System.out.println("Funcionario Cadastrado com Sucesso!!!");
                return ConfirmarSenhaFuncionario;
            }else{
                tratamento.senhaIncorreta();
                
            }
        }
        return senha;
        
    }
}
