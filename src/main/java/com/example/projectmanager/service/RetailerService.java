package com.example.projectmanager.service;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.role.Role;
import com.example.projectmanager.repository.RetailerRepository;
import com.example.projectmanager.service.impl.RetailerInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RetailerService implements RetailerInterface {

    private final RetailerRepository retailerRepository;

    @Override
    public boolean createRetailer(Retailer retailer) {
        String login = retailer.getLogin();
        if (retailerRepository.findRetailerByName(retailer.getName()) != null)
            return false;
        retailer.setActive(true);
        //retailer.setPassword(passwordEncoder.encode(retailer.getPassword()));
        //retailer.getRoles().add(Role.ROLE_RETAILER);
        log.info("Saving new User with login: {}", login);
        retailerRepository.save(retailer);
        return true;

    }

    @Override
    public List<Retailer> getAllRetailers() { // достайм всех продавцов
        return retailerRepository.findAll();
    }

    @Override
    public Retailer getRetailerByName(String name) { // достаём продавца по имени
        Retailer retailer = new Retailer();
        if (retailer.getName().equals(name)) {
            return retailerRepository.findRetailerByName(name);
        }else {
            return null;
        }
    }

    @Override
    public Retailer getRetailerById(Long id) {  // достаём продавца по id
        return retailerRepository.findById(id).orElse(null); // если нет ни одного, тогда null
    }

    @Override
    public void deleteRetailerById(Long id) { //удаляем продавца по id
        retailerRepository.deleteById(id);
    }

    @Override
    public void deleteAllRetailers() { //удаляем всех
        retailerRepository.deleteAll();
    }


}
