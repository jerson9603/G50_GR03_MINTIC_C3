package com.misiontic2022.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.inventario.interfaceService.IusuarioService;
import com.misiontic2022.inventario.interfaces.IUsuario;
import com.misiontic2022.inventario.modelo.Usuario;

@Service
public class UsuarioService implements IusuarioService{
    @Autowired
    private IUsuario data;
    
    @Override
    public List<Usuario> listar() {
        // TODO Auto-generated method stub
        return (List<Usuario>)data.findAll();
    }

    @Override
    public Optional<Usuario> listarId(int index_id) {
        return data.findById(index_id);
    }

    @Override
    public int save(Usuario u) {
        int res=0;
        Usuario usuario=data.save(u);
        if(!usuario.equals(null)){ //cuando sea diferente de null
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int index_id) {
        data.deleteById(index_id);        
    }

}
