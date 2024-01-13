package JBDC.Main;

import JBDC.Services.Services;
import JBDC.UserClass.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class main
{
    public static void main(String[] args){
        List<Usuarios> usuarios = new ArrayList<>();
        usuarios = Services.procurator();
        System.out.println("Foi encontrado %d itens na busca:".formatted(usuarios.size()));
        for (Usuarios user : usuarios) System.out.println(user);

    }
}
