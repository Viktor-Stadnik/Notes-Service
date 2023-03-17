package com.notesservice.service.impl;

import com.notesservice.model.Role;
import com.notesservice.repository.RoleRepository;
import com.notesservice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role add(Role role) {
        return repository.save(role);
    }
}
