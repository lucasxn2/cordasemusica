package Classes;

import Telas.CadastroCVIEW;


public class Main {
    

    public static void main(String[] args) {
        
        ConexaoDB conector = new ConexaoDB();
        conector.conectDB();
        
        CadastroCVIEW tela = new CadastroCVIEW();
        tela.setVisible(true);

    }

}