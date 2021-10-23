package com.example.demo.controllers;

import com.example.demo.dto.Response;
import com.example.demo.model.UsuarioEntity;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Response> getAllUsuarios(){
        Response response = usuarioService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getOneUsuario(@PathVariable(value = "id") Integer idUsuario){
        Response response = usuarioService.findOne(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> createUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity){
        Response response = usuarioService.save(usuarioEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUsuario(@PathVariable(value = "id") Integer idUsuario, @Valid @RequestBody UsuarioEntity usuarioEntity){
        Response response = usuarioService.update(usuarioEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUsuario(@PathVariable(value = "id") Integer idUsuario){
        Response response = usuarioService.delete(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
