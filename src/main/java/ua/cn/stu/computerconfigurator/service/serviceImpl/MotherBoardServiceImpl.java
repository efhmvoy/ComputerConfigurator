package ua.cn.stu.computerconfigurator.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.*;
import ua.cn.stu.computerconfigurator.repository.*;
import ua.cn.stu.computerconfigurator.service.MotherBoardService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class MotherBoardServiceImpl implements MotherBoardService {

    private final MotherBoardRepository motherBoardRepository;
    private final BrandRepository brandRepository;
    private final MemoryDetailsRepository memoryDetailsRepository;
    private final SocketRepository socketRepository;
    private final ImageRepository imageRepository;
    @Autowired
    public MotherBoardServiceImpl(MotherBoardRepository motherBoardRepository, BrandRepository brandRepository, MemoryDetailsRepository memoryDetailsRepository, SocketRepository socketRepository, ImageRepository imageRepository) {
        this.motherBoardRepository = motherBoardRepository;
        this.brandRepository = brandRepository;
        this.memoryDetailsRepository = memoryDetailsRepository;
        this.socketRepository = socketRepository;
        this.imageRepository = imageRepository;
    }


    @Override
    public MotherBoard getMotherBoardById(Long id) {
        return motherBoardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find case by id: " + id));
    }

    @Override
    public Page<MotherBoard> findAllCustrom(Integer pageNumber, Integer pageSize, Set<String> brand, Set<String> chipset, Set<Long> memorySize, Set<String> memoryType, Set<String> socket, Set<String> formFactor) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

        if(brand==null)
        {
            brand=motherBoardRepository.findAllBrands();
        }
        if(chipset==null)
        {
            chipset=motherBoardRepository.findAllChipsets();
        }
        if(memorySize==null)
        {
            memorySize=motherBoardRepository.findAllMemorySizes();
        }
        if(memoryType==null)
        {
            memoryType=motherBoardRepository.findAllMemoryTypes();
        }
        if(socket==null)
        {
            socket=motherBoardRepository.findAllSockets();
        }
        if(formFactor==null)
        {
            formFactor=motherBoardRepository.findAllFormFactors();
        }

        return motherBoardRepository.findAllCustom(brand,chipset,memorySize,memoryType,socket,formFactor, paging);
    }

    @Override
    public MotherBoard createMotherboard(MotherBoard motherBoard) {
        Optional<Brand> brandByName = brandRepository.findByName(motherBoard.getBrand().getName());
        brandByName.ifPresent(motherBoard::setBrand);
        Optional<MemoryDetails> memoryDetailsByName = memoryDetailsRepository.findBySizeAndType(motherBoard.getMemoryDetails().getSize(),motherBoard.getMemoryDetails().getType());
        memoryDetailsByName.ifPresent(motherBoard::setMemoryDetails);
        Optional<Socket> socketByName = socketRepository.findByName(motherBoard.getSocket().getName());
        socketByName.ifPresent(motherBoard::setSocket);

        brandRepository.save(motherBoard.getBrand());
        memoryDetailsRepository.save(motherBoard.getMemoryDetails());
        socketRepository.save(motherBoard.getSocket());
        imageRepository.save(motherBoard.getImage());
        MotherBoard res = motherBoardRepository.save(motherBoard);
        return res;

    }

    @Override
    public void updateMotherBoard(MotherBoard motherBoard) {

    }

    @Override
    public void deleteMotherBoard(Long id) {
        if(!motherBoardRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find motherboard by id: " + id); }
        motherBoardRepository.deleteById(id);
    }
}
