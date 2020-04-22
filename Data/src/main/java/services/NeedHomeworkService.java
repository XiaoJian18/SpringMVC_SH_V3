package services;

import dao.NeedHomeworkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NeedHomework;

import java.util.List;

/**
 * @author XJ
 * @date 2020-4-12
 */

@Service
public class NeedHomeworkService {
    @Autowired
    private NeedHomeworkDao needHomeworkDao;


    public List<NeedHomework> getAllNeed()
    {
        return needHomeworkDao.selectAllNeed();
    }

    public void AddNeed(NeedHomework needHomework)
    {
        needHomeworkDao.addNeedHomework(needHomework);
    }


}

