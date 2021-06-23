package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.MaintainsDTO;

import java.util.ArrayList;

public interface MaintainsService {

    boolean addMaintains(MaintainsDTO dto);

    boolean deleteMaintains(Long id);

    MaintainsDTO searchMaintains(Long id);

    ArrayList<MaintainsDTO> getAllMaintains();

    boolean updateMaintains(MaintainsDTO dto);


}
