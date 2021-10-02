package da.qlcn.service.impl;

import da.qlcn.model.Fund;
import da.qlcn.repository.FundRepo;
import da.qlcn.service.IFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundServiceImpl implements IFundService {
    @Autowired
    private FundRepo fundRepo;


    @Override
    public Iterable<Fund> findAll() {
        return fundRepo.findAll();
    }

    @Override
    public Optional<Fund> findById(long id) {
        return fundRepo.findById(id);
    }

    @Override
    public Fund save(Fund fund) {
        return fundRepo.save(fund);
    }

    @Override
    public void deleteById(long id) {
        fundRepo.deleteById(id);
    }

    @Override
    public Iterable<Fund> findByUserId(long userId) {
        return fundRepo.findByUserId(userId);
    }
}
