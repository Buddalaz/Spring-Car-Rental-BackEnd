package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.DamageDTO;

import java.util.ArrayList;

public interface DamageService {

    boolean addDamage(DamageDTO dto);

    boolean deleteDamage(int id);

    DamageDTO searchDamage(int id);

    ArrayList<DamageDTO> getAllDamage();

    boolean updateDamage(DamageDTO dto);


}
