package com.codegym.service;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);

    }

    @Override
    public void delete(Long id) {
        provinceRepository.delete(id);
    }
}
