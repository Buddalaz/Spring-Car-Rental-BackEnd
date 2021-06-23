package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.DamageDTO;

import java.util.ArrayList;

public interface DamageService {

    boolean addDamage(DamageDTO dto);

    boolean deleteDamage(Long id);

    DamageDTO searchDamage(Long id);

    ArrayList<DamageDTO> getAllDamage();

    boolean updateDamage(DamageDTO dto);


}
