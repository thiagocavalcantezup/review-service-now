package br.com.zup.handora.reviewservicenow;

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
        Usuario usuario = new Usuario("Thiago", "ACADEMY", "Maria");

        usuarioRepository.save(usuario);
    }

}
