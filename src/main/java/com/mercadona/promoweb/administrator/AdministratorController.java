package com.mercadona.promoweb.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mercadona.promoweb.exception.ResourceNotFoundException;
import java.util.List;

@RestController
public class AdministratorController {
    @Autowired
    private AdministratorRepository administratorRepository;
   
    @PostMapping("/administrators")
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @GetMapping("/administrators")
    public List<Administrator> getAdministrators() {
        return administratorRepository.findAll();
    }

    @GetMapping("/administrators/{id}")
    public Administrator getAdministrator(@PathVariable Long id) {
        return administratorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrator not found"));
    }

    @PutMapping("/administrators/{id}")
    
    public Administrator updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        Administrator administratorToUpdate = administratorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrator not found"));
        administratorToUpdate.setLogin(administrator.getLogin());
        administratorToUpdate.setPassword(administrator.getPassword());
        return administratorRepository.save(administratorToUpdate);
    }

    @DeleteMapping("/administrators/{id}")
    public void deleteAdministrator(@PathVariable Long id) {
        Administrator administratorToDelete = administratorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrator not found"));
        administratorRepository.delete(administratorToDelete);
    }

}
