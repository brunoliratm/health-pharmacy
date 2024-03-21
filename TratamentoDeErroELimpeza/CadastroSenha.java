package TratamentoDeErroELimpeza;
import java.util.Scanner;

public class CadastroSenha {
    Scanner sc = new Scanner(System.in);

    public String cadastroSenha(String senha){
        boolean s1 = false;
        
        while ( s1==false) {
            
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
