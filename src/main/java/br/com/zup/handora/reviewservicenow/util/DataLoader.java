package br.com.zup.handora.reviewservicenow.util;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.handora.reviewservicenow.projeto.Projeto;
import br.com.zup.handora.reviewservicenow.projeto.ProjetoRepository;
import br.com.zup.handora.reviewservicenow.usuario.Usuario;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public DataLoader(UsuarioRepository usuarioRepository, ProjetoRepository projetoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            loadUsuarios();
        }

        if (projetoRepository.count() == 0) {
            loadProjetos();
        }
    }

    private void loadUsuarios() {
        Usuario usuario1 = new Usuario(
            "Marina", "marina@zup.com.br", Map.of(4321L, "Dell Latitude 1234"), "ACADEMIA"
        );
        Usuario usuario2 = new Usuario(
            "Thiago", "thiago@zup.com.br", Map.of(4321L, "Dell Latitude 1234"), "ACADEMIA"
        );

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        usuario1.aprovar(usuario2);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

    private void loadProjetos() {
        Projeto projeto1 = new Projeto("789 - ACADEMIA TECH");
        Projeto projeto2 = new Projeto("876 - BOOTCAMP");

        projetoRepository.save(projeto1);
        projetoRepository.save(projeto2);
    }

}
