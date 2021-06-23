package lk.easycarrentalpvt.spring.service.impl;


import lk.easycarrentalpvt.spring.dto.MaintainsDTO;
import lk.easycarrentalpvt.spring.entity.Maintains;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.MaintainsRepo;
import lk.easycarrentalpvt.spring.service.MaintainsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaintainsServiceImpl implements MaintainsService {

    @Autowired
    MaintainsRepo maintainsRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean addMaintains(MaintainsDTO dto) {
        if (maintainsRepo.existsById(dto.getMaintainID())){
            throw new ValidateException("This Maintains still maintain");
        }
        maintainsRepo.save(mapper.map(dto, Maintains.class));
        return true;
    }

    @Override
    public boolean deleteMaintains(Long id) {
        if (!maintainsRepo.existsById(id)) {
            throw new ValidateException("The Entered Customer Is Not Exits Please Enter Valid Customer");
        }
        maintainsRepo.deleteById(id);
        return true;
    }

    @Override
    public MaintainsDTO searchMaintains(Long id) {
        Optional<Maintains> maintains = maintainsRepo.findById(id);
        if (maintains.isPresent()){
            return mapper.map(maintains.get(),MaintainsDTO.class);
        }
        return null;
    }

    @Override
    public boolean updateMaintains(MaintainsDTO dto) {
        if (maintainsRepo.existsById(dto.getMaintainID())){
            maintainsRepo.save(mapper.map(dto,Maintains.class));
//            throw new ValidateException("Maintains Not Found");
        }
        return true;
    }

    @Override
    public ArrayList<MaintainsDTO> getAllMaintains() {
        List<Maintains> maintainsList = maintainsRepo.findAll();
        return mapper.map(maintainsList, new TypeToken<ArrayList<MaintainsDTO>>() {
        }.getType());
    }
}
