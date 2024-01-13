package JBDC.Services;

import JBDC.Repository.UsuarioRepository;
import JBDC.UserClass.Usuarios;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

public class Services {
    public static void inserir (Usuarios user){
        UsuarioRepository.save(user);
    }
    public static void inserir (List<Usuarios> usuarios) {for(Usuarios user : usuarios) UsuarioRepository.save(user);}

    public static void apagar(String name){
        UsuarioRepository.delete(name);
        System.out.println("User apagado com sucesso! ");
    }
    public static void apagar(Integer id){
        UsuarioRepository.delete(id);
    }
    public static void apagar(Integer id_inicio, Integer id_fim){
        for (int i = id_inicio.intValue(); i <= id_fim.intValue(); i++) UsuarioRepository.delete(i);
    }

    public static List<Usuarios> procurator(){
        return UsuarioRepository.dados();
    }

    public static <T> List<Usuarios> procurator(T searchKey){
        return UsuarioRepository.dadoBy(searchKey);
    }

    public static List<Usuarios> procurator(Integer id_inicio, Integer id_fim){
        List<Usuarios> allusers = new ArrayList<>();
        for (int i = id_inicio.intValue(); i <= id_fim.intValue(); i++) allusers.addAll(UsuarioRepository.dadoBy(i));
        return allusers;
        }
    public static void Statistics(){
        System.out.println("Inseridos: %d\nEditados: %d\nApagados: %d\n ".formatted(UsuarioRepository.inseridos, UsuarioRepository.editados, UsuarioRepository.removidos));
    }
}
