package br.com.aplrm.aplrm.controllers;


import br.com.aplrm.aplrm.dto.UserDTO;


import br.com.aplrm.aplrm.repositories.UserRepository;
import br.com.aplrm.aplrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/usuario")
public class UsuarioControle {

    @Autowired

    private UserService service;
    private UserRepository repository;


    @GetMapping

    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
}}