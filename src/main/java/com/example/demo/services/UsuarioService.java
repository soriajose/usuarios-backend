package com.example.demo.services;

import com.example.demo.dto.Response;
import com.example.demo.model.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Response findAll(){
        Response response = new Response();
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
        response.setData(usuarioEntityList);
        return response;
    }

    public Response findOne(Integer idUsuario){
        Response response = new Response();
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario).get();
        response.setData(usuarioEntity);
        return response;
    }

    public Response save(UsuarioEntity usuarioEntity){
        Response response = new Response();
        response.setData(usuarioRepository.save(usuarioEntity));
        return response;
    }

    public Response update(UsuarioEntity input){
        Response response = new Response();
        usuarioRepository.save(input);
        response.setData("ok");
        return response;
    }

    public Response delete(Integer idUsuario){
        Response response = new Response();
        usuarioRepository.delete(usuarioRepository.getById(idUsuario));
        response.setData("ok");
        return response;
    }

}
