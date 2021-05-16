package ua.cn.stu.ComputerConfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.cn.stu.ComputerConfigurator.model.MotherBoard;
import ua.cn.stu.ComputerConfigurator.repository.BrandRepository;
import ua.cn.stu.ComputerConfigurator.repository.ChipsetRepository;
import ua.cn.stu.ComputerConfigurator.repository.MemoryDetailsRepository;
import ua.cn.stu.ComputerConfigurator.repository.MotherBoardRepository;
import ua.cn.stu.ComputerConfigurator.service.MotherBoardService;

@Service
public class MotherBoardServiceImpl implements MotherBoardService {

    private final MotherBoardRepository motherBoardRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final ChipsetRepository chipsetRepository;
    @Autowired
    public MotherBoardServiceImpl(MotherBoardRepository motherBoardRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository, ChipsetRepository chipsetRepository) {
        this.motherBoardRepository = motherBoardRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
        this.chipsetRepository = chipsetRepository;
    }


    @Override
    public MotherBoard getByName(String name) {
        return null;
    }

    @Override
    public Page<MotherBoard> getAllByBrand(String brand, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MotherBoard> getAllByChipset(String chipset, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MotherBoard> getAllByFormFactor(String FormFactor, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MotherBoard> getAllByMemoryType(String memoryType, Pageable pageable) {
        return null;
    }

    @Override
    public MotherBoard createMotherboard(MotherBoard motherBoard) {
        return null;
    }

    @Override
    public void updateMotherBoard(MotherBoard motherBoard) {

    }

    @Override
    public void deleteMotherBoard(Long id) {

    }
}
