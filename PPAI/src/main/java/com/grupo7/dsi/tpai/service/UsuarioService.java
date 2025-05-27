package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Usuario;
import com.grupo7.dsi.tpai.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findById(nombreUsuario).orElse(null);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deleteById(String nombreUsuario) {
        usuarioRepository.deleteById(nombreUsuario);
    }
}
