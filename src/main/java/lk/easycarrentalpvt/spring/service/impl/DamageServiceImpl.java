package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.DamageDTO;
import lk.easycarrentalpvt.spring.entity.Damage;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.DamageRepo;
import lk.easycarrentalpvt.spring.service.DamageService;
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
public class DamageServiceImpl implements DamageService {

    @Autowired
    DamageRepo damageRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean addDamage(DamageDTO dto) {
        if (damageRepo.existsById(dto.getDamageID())) {
            throw new ValidateException("Entered Value is Already Exists");
        }
        damageRepo.save(mapper.map(dto, Damage.class));
        return true;
    }

    @Override
    public boolean deleteDamage(int id) {
        if (!damageRepo.existsById(id)){
            throw new ValidateException("Entered Value is Not Exists");
        }
        damageRepo.deleteById(id);
        return true;
    }

    @Override
    public DamageDTO searchDamage(int id) {
        Optional<Damage> damage = damageRepo.findById(id);
        if (damage.isPresent()){
            return mapper.map(damage.get(),DamageDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DamageDTO> getAllDamage() {
        List<Damage> damageList = damageRepo.findAll();
        return mapper.map(damageList, new TypeToken<ArrayList<DamageDTO>>() {
        }.getType());
//        return null;
    }

    @Override
    public boolean updateDamage(DamageDTO dto) {
        if (damageRepo.existsById(dto.getDamageID())){
            damageRepo.save(mapper.map(dto,Damage.class));
        }
        return true;
    }
}
