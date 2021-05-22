package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.Brand;
import ua.cn.stu.computerconfigurator.model.Case;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.CaseRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.service.CaseService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class CaseServiceImpl implements CaseService {


    @Override
    public Case getCaseyById(Long id) {
        return caseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find case by id: " + id));
    }

    @Override
    public Page<Case> findAll(Integer pageNumber, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));
        return caseRepository.findAll(paging);
    }

    private final CaseRepository caseRepository;
    private final BrandRepository brandRepository;
    private final ImageRepository imageRepository;
    @Autowired
    public CaseServiceImpl(CaseRepository caseRepository, BrandRepository brandRepository, ImageRepository imageRepository) {
        this.caseRepository = caseRepository;
        this.brandRepository = brandRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Page<Case> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brands, Set<String> formFactors) {
      PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

      if(brands==null)
      {
          brands=caseRepository.findAllBrands();
      }
      if(formFactors==null)
      {
          formFactors=caseRepository.findAllFormFactors();
      }
      return caseRepository.findAllCustom(brands,formFactors, paging);

    }




    @Override
    public Case createCase(Case cas) {

        Optional<Brand> brandByName = brandRepository.findByName(cas.getBrand().getName());
        if(brandByName.isPresent())
        { cas.setBrand(brandByName.get()); }
        brandRepository.save(cas.getBrand());
        imageRepository.save(cas.getImage());
        return caseRepository.save(cas);
    }

    @Override
    public void deleteCase(Long id) {
        if(!caseRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find case by id: " + id); }
        caseRepository.deleteById(id);
    }

    @Override
    public void updateCase(Case cas) {

    }
}
