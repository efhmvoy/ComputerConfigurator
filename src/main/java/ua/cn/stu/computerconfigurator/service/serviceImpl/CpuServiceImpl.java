package ua.cn.stu.computerconfigurator.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ua.cn.stu.computerconfigurator.model.Brand;
import ua.cn.stu.computerconfigurator.model.Cpu;
import ua.cn.stu.computerconfigurator.model.Socket;
import ua.cn.stu.computerconfigurator.repository.BrandRepository;
import ua.cn.stu.computerconfigurator.repository.ImageRepository;
import ua.cn.stu.computerconfigurator.repository.SocketRepository;
import ua.cn.stu.computerconfigurator.repository.CpuRepository;
import ua.cn.stu.computerconfigurator.service.CpuService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class CpuServiceImpl implements CpuService {

    private final BrandRepository brandRepository;
    private final SocketRepository socketRepository;
    private final CpuRepository cpuRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public CpuServiceImpl(BrandRepository brandRepository, SocketRepository socketRepository, CpuRepository cpuRepository, ImageRepository imageRepository) {
        this.brandRepository = brandRepository;
        this.socketRepository = socketRepository;
        this.cpuRepository = cpuRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Page<Cpu> findAllCustom(Integer pageNumber, Integer pageSize, Set<String> brands, Set<Long> coreCount, Set<Long> threadCount, Set<String> socket, Set<String> model, Set<String> frequency) {
        var paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString("asc"), "id"));

        if(brands==null)
        {
            brands=cpuRepository.findAllBrands();
        }
        if(coreCount==null)
        {
            coreCount=cpuRepository.findAllCoreCount();
        }
        if(threadCount==null)
        {
            threadCount=cpuRepository.findAllThreadCount();
        }
        if(socket==null)
        {
            socket=cpuRepository.findAllSockets();
        }
        if(model==null)
        {
            model=cpuRepository.findAllModels();
        }
        if(frequency==null)
        {
            frequency=cpuRepository.findAllFormFrequencies();
        }

        return cpuRepository.findAllCustom(brands,coreCount,threadCount,socket,model,frequency, paging);
    }

    @Override
    public Cpu getCpuById(Long id) {
        return cpuRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find case by id: " + id));
    }


    @Override
    public Cpu createCpu(Cpu cpu) {

        Optional<Brand> brandByName = brandRepository.findByName(cpu.getBrand().getName());
        brandByName.ifPresent(cpu::setBrand);
        Optional<Socket> socketByName = socketRepository.findByName(cpu.getSocket().getName());
        socketByName.ifPresent(cpu::setSocket);

        brandRepository.save(cpu.getBrand());
        socketRepository.save(cpu.getSocket());
        imageRepository.save(cpu.getImage());

        return  cpuRepository.save(cpu);
    }

    @Override
    public void updateCpu(Cpu cpu) {

    }

    @Override
    public void deleteCpu(Long id)
    {
        if(!cpuRepository.findById(id).isPresent())
        { throw new EntityNotFoundException("Can not find cpu by id: " + id); }
        cpuRepository.deleteById(id);
    }
}
