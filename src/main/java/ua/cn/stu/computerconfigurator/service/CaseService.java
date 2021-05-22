package ua.cn.stu.computerconfigurator.service;

import org.springframework.data.domain.Page;
import ua.cn.stu.computerconfigurator.model.Case;

import java.util.Set;


public interface CaseService {

    Case getCaseyById(Long id);

    Page<Case> findAll(Integer pageNumber, Integer pageSize);

    Page<Case> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brands, Set<String> formFactors);

    Case createCase(Case cas);

    void deleteCase(Long id);

    void updateCase(Case cas);

}
