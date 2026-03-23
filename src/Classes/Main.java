package Classes;

import Telas.TelaInicial;


public class Main {
    

    public static void main(String[] args) {
        
        ConexaoDB conector = new ConexaoDB();
        conector.conectDB();
        
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);

    }

}