package br.com.zup.handora.reviewservicenow.util;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.handora.reviewservicenow.usuario.Usuario;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        Usuario usuario1 = new Usuario("Thiago", Map.of(4321L, "Dell Latitude 1234"), "ACADEMY");
        Usuario usuario2 = new Usuario("Martina", Map.of(4321L, "Dell Latitude 1234"), "ACADEMY");

        usuario2.aprovar(usuario1);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

}
