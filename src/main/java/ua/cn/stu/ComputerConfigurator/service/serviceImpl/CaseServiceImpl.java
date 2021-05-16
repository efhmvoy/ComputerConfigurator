package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.Case;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.CaseRepository;
import ua.cn.stu.ComputerConfigurator.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final BrandRepository brandRepository;
    @Autowired
    public CaseServiceImpl(CaseRepository caseRepository, BrandRepository brandRepository) {
        this.caseRepository = caseRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Case getByName(String name) {
        return null;
    }

    @Override
    public Page<Case> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Case> getAllByFormFactor(String formFactor, Pageable pageable) {
        return null;
    }

    @Override
    public Case createCase(Case cas) {
        return null;
    }

    @Override
    public void deleteCase(Long id) {

    }

    @Override
    public void updateCase(Case cas) {

    }
}
