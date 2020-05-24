package com.example.IPApp.repository;

import com.example.IPApp.entity.Register;
import com.example.IPApp.model.InfoResponse;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class Repository {
    private final RepositoryInterface repositoryInterface;

    public Repository(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    public void save(InfoResponse infoResponse) {
        Optional<Register> optionalRegister = repositoryInterface.findByName(infoResponse.getName());
        Register register;
        if (optionalRegister.isPresent()) {
            register = optionalRegister.get();
            Integer oldCantInvocations = register.getInvocations();
            register.setInvocations(++oldCantInvocations);
        } else {
            register = new Register();
            register.setName(infoResponse.getName());
            register.setDistance(infoResponse.getEstimatedDistance());
            register.setInvocations(1);
        }
        repositoryInterface.save(register);
    }

    public List<Register> getRegisters() {
        Iterator<Register> iterator = repositoryInterface.findAll().iterator();
        return IteratorUtils.toList(iterator);
    }
}
