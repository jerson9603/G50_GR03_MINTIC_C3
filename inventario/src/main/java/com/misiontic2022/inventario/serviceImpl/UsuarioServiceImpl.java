package com.misiontic2022.inventario.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.misiontic2022.inventario.controller.dto.UsuarioRegistroDTO;
import com.misiontic2022.inventario.domain.Rol;
import com.misiontic2022.inventario.domain.Usuario;
import com.misiontic2022.inventario.repository.UsuarioRepository;
import com.misiontic2022.inventario.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), 
				registroDTO.getApellido(),registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepository.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
}
