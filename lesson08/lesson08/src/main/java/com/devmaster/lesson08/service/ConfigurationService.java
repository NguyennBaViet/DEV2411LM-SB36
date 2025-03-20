package com.devmaster.lesson08.service;

import com.devmaster.lesson08.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;

    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }
    public Configuration getConfigurationById(Long id) {
        return configurationRepository.findById(id).orElse(null);
    }
    public Configuration save(Configuration configuration) {
        return configurationRepository.save(configuration);
    }
    public void deleteConfigurationById(Long id) {
        configurationRepository.deleteById(id);
    }
}
